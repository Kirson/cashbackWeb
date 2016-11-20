/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.controller;

import com.cashback.beans.CierreDiaLocalBean;
import com.cashback.beans.FormaPagoBean;
import com.cashback.interfaces.IComprobante;
import com.cashback.interfaces.IComprobanteFormaPago;
import com.cashback.interfaces.IFormaPago;
import com.cashback.model.Actor;
import com.cashback.model.Comprobante;
import com.cashback.model.ComprobanteFormaPago;
import com.cashback.model.FormaPago;
import com.cashback.model.Usuario;
import com.cashback.utilidades.DateUtil;
import com.cashback.utilidades.NumberUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author somosGlobal
 */
@SessionScoped
@ManagedBean
public class ConsultaVentaLocalCtr extends Controladores {

    private CierreDiaLocalBean cierreLocal;
    private Actor local;
    private List<FormaPagoBean> listaFormaPagoBean;
    private List<FormaPago> listaFormaPago;

    @EJB
    private IComprobante sComprobante;

    @EJB
    private IComprobanteFormaPago sComprobanteFormaPago;

    @EJB
    private IFormaPago sFormaPago;

    public CierreDiaLocalBean getCierreLocal() {
        return cierreLocal;
    }

    public void setCierreLocal(CierreDiaLocalBean cierreLocal) {
        this.cierreLocal = cierreLocal;
    }

    public Actor getLocal() {
        return local;
    }

    public void setLocal(Actor local) {
        this.local = local;
    }

    @PostConstruct
    @SuppressWarnings("Convert2Diamond")
    public void inicio() {
        cierreLocal = new CierreDiaLocalBean();
        usuario = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("usuario");

        determinarLocal();

        listaFormaPago = new ArrayList<FormaPago>();
        listaFormaPagoBean = new ArrayList<FormaPagoBean>();

        listaFormaPago = sFormaPago.getAll();
        
        if(listaFormaPago!=null && !listaFormaPago.isEmpty()){
            for(FormaPago fp:listaFormaPago){
                FormaPagoBean fpb = new FormaPagoBean();
                fpb.setFormaPago(fp);
                listaFormaPagoBean.add(fpb);
            }
        }
    }

    private void determinarLocal() {
        if (usuario != null) {
            local = usuario.getActor();
        }
    }

    public void consultarCierre() {
        Double total = 0D;
        if (cierreLocal.getFechaConsulta() != null) {
            List<Comprobante> comprobantes = sComprobante.listarComprobantesLocalFecha(local, DateUtil.fromDateToString(cierreLocal.getFechaConsulta()));
            if(comprobantes!=null && !comprobantes.isEmpty()){
                cierreLocal.setLocal(local);
                cierreLocal.setNumeroTransacciones(new Long(comprobantes.size()));
                for(Comprobante cr:comprobantes){
                    total = total +cr.getTotalCompra().doubleValue();
                    total = NumberUtil.round(total);
                    List<ComprobanteFormaPago> consultaListaFormaPago = sComprobanteFormaPago.listarFormaPagoComprobante(cr);
                    if(consultaListaFormaPago!=null && !consultaListaFormaPago.isEmpty()){
                        for(FormaPagoBean fpb:listaFormaPagoBean){
                            for(ComprobanteFormaPago cfp:consultaListaFormaPago){
                                if(fpb.getFormaPago().equals(cfp.getFormaPago())){
                                    Double subFormaPago = fpb.getTotalFormaPago();
                                    subFormaPago = subFormaPago + cfp.getValorFormaPago().doubleValue();
                                    subFormaPago = NumberUtil.round(subFormaPago);
                                    fpb.setTotalFormaPago( subFormaPago);
                                    
                                }
                            }
                        }
                    }
                }//fin del for
                cierreLocal.setListaFormaPago(listaFormaPagoBean);
                cierreLocal.setTotalVentas(total);
            }
        }
    }
    
    public void limpiar(){
      cierreLocal = new CierreDiaLocalBean();
    }
}
