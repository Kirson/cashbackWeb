/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.controller;

import com.cashback.beans.PuntosBean;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.IComprobante;
import com.cashback.interfaces.ITransaccionesActor;
import com.cashback.model.Actor;
import com.cashback.model.Comprobante;
import com.cashback.model.PuntosActor;
import com.cashback.model.TransaccionesActor;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author somosGlobal
 */
@SessionScoped
@ManagedBean
public class ConsultaPuntosCtr extends Controladores {

    @EJB
    private IActor sActor;

    @EJB
    private ITransaccionesActor sTransaccionesActor;

    @EJB
    private IComprobante sComprobante;

    private PuntosBean puntosBean;

    public PuntosBean getPuntosBean() {
        return puntosBean;
    }

    public void setPuntosBean(PuntosBean puntosBean) {
        this.puntosBean = puntosBean;
    }

    @PostConstruct
    public void inicio() {
        limpiar();
    }

    public void consultarPuntosComprobante() {
        if (puntosBean != null && puntosBean.getDocumentoActor() != null) {
            Comprobante consulta = sComprobante.buscarComprobante(puntosBean.getNumeroComprobante());
            
            if(consulta!=null){
                puntosBean.setComprobante(consulta);
                
                List<TransaccionesActor> transaccionesList = sTransaccionesActor.buscarTransaccionesComprobante(puntosBean.getNumeroComprobante());
            
                if (transaccionesList != null && !transaccionesList.isEmpty()) {
                    puntosBean.setTransaccionesActor(transaccionesList);
                }
            }else{
                ponerMensajeInfo("", "No existe un comprobante ni transacciones registradas con el numero de comprobante " + puntosBean.getNumeroComprobante());
            }
        }

    }

    public void consultarPuntosActor() {
        if (puntosBean != null && puntosBean.getDocumentoActor() != null) {
            Actor consulta = sActor.recuperarActorByCedRucPas(puntosBean.getDocumentoActor());

            if (consulta != null) {
                puntosBean.setActor(consulta);
                PuntosActor puntosConsulta = sPuntosActor.recuperarPuntos(consulta);
                if (puntosConsulta != null) {
                    PuntosActor puntosActor = puntosConsulta;
                    puntosBean.setPuntosActor(puntosActor);
                }

                List<TransaccionesActor> transaccionesList = sTransaccionesActor.recuperarHistorialTransaccion(consulta);

                if (transaccionesList != null && !transaccionesList.isEmpty()) {
                    puntosBean.setTransaccionesActor(transaccionesList);
                }

            } else {
                ponerMensajeInfo("", "No existe un actor registrado con el numero de documento ingresado " + puntosBean.getDocumentoActor());
            }

        }
    }

    public void limpiar() {
        puntosBean = new PuntosBean();
    }
}
