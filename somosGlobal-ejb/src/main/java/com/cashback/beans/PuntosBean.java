/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.beans;

import com.cashback.model.Actor;
import com.cashback.model.Comprobante;
import com.cashback.model.PuntosActor;
import com.cashback.model.TransaccionesActor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public class PuntosBean implements Serializable {
    
    private String documentoActor;
    private String documentoLocal;
    private Actor actor;
    private Actor local;
    private PuntosActor puntosActor;
    private PuntosActor puntosLocal;
    private List<TransaccionesActor> transaccionesActor;
    private List<TransaccionesActor> transaccionesLocal;
    private List<TransaccionesActor> transaccionesComprobante;
    private String numeroComprobante;
    private Comprobante comprobante;
    
    @SuppressWarnings("Convert2Diamond")
    public PuntosBean(){
        transaccionesActor = new ArrayList<TransaccionesActor>();
        transaccionesLocal = new ArrayList<TransaccionesActor>();
        transaccionesComprobante = new ArrayList<TransaccionesActor>();
        actor = new Actor();
        local = new Actor();
        puntosActor = new PuntosActor();
        puntosLocal = new PuntosActor();
        documentoActor = "";
        documentoLocal = "";
        numeroComprobante = "";
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getDocumentoActor() {
        return documentoActor;
    }

    public void setDocumentoActor(String documentoActor) {
        this.documentoActor = documentoActor;
    }

    public String getDocumentoLocal() {
        return documentoLocal;
    }

    public void setDocumentoLocal(String documentoLocal) {
        this.documentoLocal = documentoLocal;
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

    public PuntosActor getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(PuntosActor puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public List<TransaccionesActor> getTransaccionesActor() {
        return transaccionesActor;
    }

    public void setTransaccionesActor(List<TransaccionesActor> transaccionesActor) {
        this.transaccionesActor = transaccionesActor;
    }

    public List<TransaccionesActor> getTransaccionesLocal() {
        return transaccionesLocal;
    }

    public void setTransaccionesLocal(List<TransaccionesActor> transaccionesLocal) {
        this.transaccionesLocal = transaccionesLocal;
    }

    public List<TransaccionesActor> getTransaccionesComprobante() {
        return transaccionesComprobante;
    }

    public void setTransaccionesComprobante(List<TransaccionesActor> transaccionesComprobante) {
        this.transaccionesComprobante = transaccionesComprobante;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    
    
}
