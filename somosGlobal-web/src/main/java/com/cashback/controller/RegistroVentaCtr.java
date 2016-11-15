/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.controller;

import com.cashback.beans.ActorSearch;
import com.cashback.beans.ClienteBean;
import com.cashback.beans.ComprobanteBean;
import com.cashback.excepciones.ExcGuardarRegistro;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.IActorRol;
import com.cashback.interfaces.IComprobante;
import com.cashback.interfaces.IComprobanteFormaPago;
import com.cashback.interfaces.IComprobanteItem;
import com.cashback.interfaces.IItemGlo;
import com.cashback.interfaces.IItemLoc;
import com.cashback.interfaces.IPuntosActor;
import com.cashback.interfaces.ISecuencia;
import com.cashback.interfaces.ITransaccionesActor;
import com.cashback.model.Actor;
import com.cashback.model.ActorRol;

import com.cashback.model.ComprobanteFormaPago;
import com.cashback.model.ComprobanteItem;
import com.cashback.model.ItemGlo;
import com.cashback.model.ItemLoc;
import com.cashback.model.PuntosActor;
import com.cashback.model.Secuencia;
import com.cashback.model.TransaccionesActor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author somosGlobal
 */
@SessionScoped
@ManagedBean
public class RegistroVentaCtr extends Controladores {

    private Actor consumidor;
    private Actor local;
    private PuntosActor puntosActor;
    private TransaccionesActor transaccionActor;
    private ComprobanteBean comprobanteBean;
    private Secuencia secuencia;
    private String numeroSecuencia;
    private ClienteBean clienteBean;
    private ActorSearch actorSearch;
    private List<ActorRol> actorRolList;
    private ActorRol actorRol;
    private List<ItemGlo> itemsGlobal;
    private List<ItemLoc> itemsLocal;
    private ItemLoc itemSeleccionado;

    @EJB
    private IActor sActor;

    @EJB
    private IPuntosActor sPuntosActor;

    @EJB
    private ITransaccionesActor sTransaccionesActor;

    @EJB
    private IComprobante sComprobante;

    @EJB
    private IComprobanteItem sComprobanteItem;

    @EJB
    private IComprobanteFormaPago sComprobanteFormaPago;

    @EJB
    private IActorRol sActorRol;

    @EJB
    private ISecuencia sSecuencia;

    @EJB
    private IItemGlo sItemGlo;

    @EJB
    private IItemLoc sItemLoc;

    public Actor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Actor consumidor) {
        this.consumidor = consumidor;
    }

    public Actor getLocal() {
        return local;
    }

    public void setLocal(Actor local) {
        this.local = local;
    }

    public PuntosActor getPuntosActor() {
        return puntosActor;
    }

    public void setPuntosActor(PuntosActor puntosActor) {
        this.puntosActor = puntosActor;
    }

    public TransaccionesActor getTransaccionActor() {
        return transaccionActor;
    }

    public void setTransaccionActor(TransaccionesActor transaccionActor) {
        this.transaccionActor = transaccionActor;
    }

    public ComprobanteBean getComprobanteBean() {
        return comprobanteBean;
    }

    public void setComprobanteBean(ComprobanteBean comprobanteBean) {
        this.comprobanteBean = comprobanteBean;
    }

    public Secuencia getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Secuencia secuencia) {
        this.secuencia = secuencia;
    }

    public String getNumeroSecuencia() {
        return numeroSecuencia;
    }

    public void setNumeroSecuencia(String numeroSecuencia) {
        this.numeroSecuencia = numeroSecuencia;
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public ActorSearch getActorSearch() {
        return actorSearch;
    }

    public void setActorSearch(ActorSearch actorSearch) {
        this.actorSearch = actorSearch;
    }

    public List<ActorRol> getActorRolList() {
        return actorRolList;
    }

    public void setActorRolList(List<ActorRol> actorRolList) {
        this.actorRolList = actorRolList;
    }

    public ActorRol getActorRol() {
        return actorRol;
    }

    public void setActorRol(ActorRol actorRol) {
        this.actorRol = actorRol;
    }

    public List<ItemGlo> getItemsGlobal() {
        return itemsGlobal;
    }

    public void setItemsGlobal(List<ItemGlo> itemsGlobal) {
        this.itemsGlobal = itemsGlobal;
    }

    public List<ItemLoc> getItemsLocal() {
        return itemsLocal;
    }

    public void setItemsLocal(List<ItemLoc> itemsLocal) {
        this.itemsLocal = itemsLocal;
    }

    public ItemLoc getItemSeleccionado() {
        return itemSeleccionado;
    }

    public void setItemSeleccionado(ItemLoc itemSeleccionado) {
        this.itemSeleccionado = itemSeleccionado;
    }

    @PostConstruct
    @SuppressWarnings("Convert2Diamond")
    public void inicio() {
        secuencia = sSecuencia.obtenerSecuencia("Comprobante");
        if (secuencia != null) {
            numeroSecuencia = formatSecuence(secuencia);
        }
        comprobanteBean = new ComprobanteBean();
        clienteBean = new ClienteBean();
        actorRolList = new ArrayList<ActorRol>();
        actorSearch = new ActorSearch();
        actorRol = new ActorRol();
        itemsGlobal = new ArrayList<ItemGlo>();
        itemsLocal = new ArrayList<ItemLoc>();

        itemsGlobal = sItemGlo.getAll();

        if (local != null) {
            itemsLocal = sItemLoc.findByLocal(local);
        } else {
            itemsLocal = sItemLoc.getAll();
        }

        itemSeleccionado = new ItemLoc();
    }

    private String formatSecuence(Secuencia secuencia) {

        String num = secuencia.getSiguienteValor() + "";

        while (num.length() < secuencia.getLongitud()) {
            num = secuencia.getCaracter() + num;
        }

        return num;
    }

    public void addRow() {

        ComprobanteItem ci = new ComprobanteItem();

        this.comprobanteBean.getItems().add(ci);

    }

    public void addFormaPago() {

        ComprobanteFormaPago cfp = new ComprobanteFormaPago();

        this.comprobanteBean.getListaFormaPago().add(cfp);

    }

    public void onEditItem(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Item Edited", ((ComprobanteItem) event.getObject()).getDescripcionItem());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancelItem(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Item Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.comprobanteBean.getItems().remove((ComprobanteItem) event.getObject());
    }

    public void onEditFP(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Forma Pago Edited", ((ComprobanteFormaPago) event.getObject()).getDescripcionFormaPago());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancelFP(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Forma Pago Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.comprobanteBean.getListaFormaPago().remove((ComprobanteFormaPago) event.getObject());
    }

    public void buscarConsumidorLista() {
        actorRolList = sActorRol.findAllByDatosActor(actorSearch.getCedRucPasAct(),
        actorSearch.getRazonSocialAct(), actorSearch.getNombres(), actorSearch.getApellidos());
    }

    public void establecerConsumidor() {

        consumidor = sActor.recuperarActorByCedRucPas(clienteBean.getDocumento());

        if (consumidor != null) {
            consumidor.setEncontrado(Boolean.TRUE);
        } else {
            consumidor = new Actor();
            consumidor.setNombresAct(clienteBean.getNombre());
            consumidor.setApellidosAct(clienteBean.getApellido());
            consumidor.setCedrucpasAct(clienteBean.getDocumento());
            consumidor.setEncontrado(Boolean.FALSE);
            consumidor.setMailAct(clienteBean.getEmail());
            crearConsumidor();
        }
    }

    private void crearConsumidor() {

        if (consumidor != null) {
            if (!consumidor.getEncontrado()) {
                try {
                    sActor.crearActor(consumidor);
                } catch (ExcGuardarRegistro ex) {
                    Logger.getLogger(RegistroVentaCtr.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @SuppressWarnings("Convert2Diamond")
    public void limpiarDatos() {
        actorRolList = new ArrayList<ActorRol>();
        consumidor = new Actor();
        actorSearch = new ActorSearch();
        actorRol = new ActorRol();
        clienteBean = new ClienteBean();
    }

    public String seleccionarActor() {
        limpiarDatos();

        consumidor = actorRol.getActor();

        if (consumidor != null) {

            clienteBean.setNombre(consumidor.getNombresAct());
            clienteBean.setApellido(consumidor.getApellidosAct());
            clienteBean.setDocumento(consumidor.getCedrucpasAct());
            clienteBean.setFechaNacimiento(consumidor.getFecNacAct());
            clienteBean.setEmail(consumidor.getMailAct());
            clienteBean.setCelular("");
            consumidor.setEncontrado(Boolean.TRUE);
        }
        return "OK";
    }

    public void handleChange(ComprobanteItem item) {
        if(item!=null){
            System.out.println("Item no es nulo");
            
            
            if (itemSeleccionado != null) {
                System.out.println("Existe elemento seleccionado ");
                comprobanteBean.getItems().remove(item);
                ComprobanteItem ci = new ComprobanteItem();
                ci.setItem(itemSeleccionado);
                ci.setValorItem(new BigDecimal(itemSeleccionado.getCosUniIl()));
                ci.setDescripcionItem(itemSeleccionado.getNombreIl());
                ci.setValorTotal(new BigDecimal(itemSeleccionado.getCosUniIl()));
                comprobanteBean.getItems().add(ci);
            }
        }else{
            System.out.println("Item es nulo");
        }
        
    }

    public String guardarComprobante() {

        String result = "OK";

        try {
            establecerConsumidor();

            comprobanteBean.getComprobante().setCliente(consumidor);
            comprobanteBean.getComprobante().setLocalVenta(local);
            comprobanteBean.getComprobante().setNumComprobante(this.secuencia.getSiguienteValor() + "");

            sComprobante.guardarComprobante(comprobanteBean);

            ponerMensajeInfo("", "Comprobante registrado exitosamente");
            
        } catch (Exception e) {
            ponerMensajeError("", "Error al registrar comprobante");
            Logger.getLogger(RegistroVentaCtr.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error al guarar comprobante "+e.getMessage());
        }
        return result;

    }

}
