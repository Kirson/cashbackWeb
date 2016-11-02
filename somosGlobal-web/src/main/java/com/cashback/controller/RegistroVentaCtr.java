/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.controller;

import com.cashback.beans.ClienteBean;
import com.cashback.beans.ComprobanteBean;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.IActorRol;
import com.cashback.interfaces.IPuntosActor;
import com.cashback.interfaces.ISecuencia;
import com.cashback.interfaces.ITransaccionesActor;
import com.cashback.model.Actor;
import com.cashback.model.ComprobanteFormaPago;
import com.cashback.model.ComprobanteItem;
import com.cashback.model.ICatalogoGen;
import com.cashback.model.PuntosActor;
import com.cashback.model.Secuencia;
import com.cashback.model.TransaccionesActor;
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

    @EJB
    private IActor sActor;

    @EJB
    private IPuntosActor sPuntosActor;

    @EJB
    private ITransaccionesActor sTransaccionesActor;

    @EJB
    private ICatalogoGen sCatalogoGen;

    @EJB
    private IActorRol sActorRol;
    
    @EJB
    private ISecuencia sSecuencia;

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
    
    
    
    @PostConstruct
    public void inicio() {
        secuencia = sSecuencia.obtenerSecuencia("Comprobante");
        if(secuencia!=null){
            numeroSecuencia = formatSecuence(secuencia); 
        }
        comprobanteBean = new ComprobanteBean();
        clienteBean = new ClienteBean();
    }

    
    private String formatSecuence(Secuencia secuencia){
       
        String num = secuencia.getSiguienteValor()+"";
        
        while(num.length()<secuencia.getLongitud()){
            num = secuencia.getCaracter()+num;
        }
        
        return num;
    }
    
    public void addRow(){
       
        ComprobanteItem ci = new ComprobanteItem();
        
        this.comprobanteBean.getItems().add(ci);
    
    }
    
     public void addFormaPago(){
       
        ComprobanteFormaPago cfp = new ComprobanteFormaPago();
        
        this.comprobanteBean.getListaFormaPago().add(cfp);
    
    }
     
    public void onEditItem(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Item Edited",((ComprobanteItem) event.getObject()).getDescripcionItem());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
       
    public void onCancelItem(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Item Cancelled");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        this.comprobanteBean.getItems().remove((ComprobanteItem) event.getObject());
    }  
    
     public void onEditFP(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Forma Pago Edited",((ComprobanteFormaPago) event.getObject()).getDescripcionFormaPago());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
       
    public void onCancelFP(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Forma Pago Cancelled");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        this.comprobanteBean.getListaFormaPago().remove((ComprobanteFormaPago) event.getObject());
    }  
}
