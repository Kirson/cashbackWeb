/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.beans;

import com.cashback.model.Actor;
import com.cashback.model.Comprobante;
import com.cashback.model.ComprobanteFormaPago;
import com.cashback.model.ComprobanteItem;
import com.cashback.model.Secuencia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public class ComprobanteBean implements Serializable {
    
    private Comprobante comprobante;
    private List<ComprobanteItem> items;
    private List<ComprobanteFormaPago> listaFormaPago;
    private Secuencia secuencia;
    private String accion;
    private Actor cliente;
    private Actor local;
    private String resultado;
    private List<String> errores;
    private Boolean pagaConPuntos;
    
    @SuppressWarnings("Convert2Diamond")
    public ComprobanteBean(){
        items = new ArrayList<ComprobanteItem>();
        listaFormaPago = new ArrayList<ComprobanteFormaPago>();
        errores = new ArrayList<String>();
        comprobante = new Comprobante();
        pagaConPuntos = Boolean.FALSE;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public List<ComprobanteItem> getItems() {
        return items;
    }

    public void setItems(List<ComprobanteItem> items) {
        this.items = items;
    }

    public List<ComprobanteFormaPago> getListaFormaPago() {
        return listaFormaPago;
    }

    public void setListaFormaPago(List<ComprobanteFormaPago> listaFormaPago) {
        this.listaFormaPago = listaFormaPago;
    }

    public Secuencia getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Secuencia secuencia) {
        this.secuencia = secuencia;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Actor getCliente() {
        return cliente;
    }

    public void setCliente(Actor cliente) {
        this.cliente = cliente;
    }

    public Actor getLocal() {
        return local;
    }

    public void setLocal(Actor local) {
        this.local = local;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public Boolean getPagaConPuntos() {
        return pagaConPuntos;
    }

    public void setPagaConPuntos(Boolean pagaConPuntos) {
        this.pagaConPuntos = pagaConPuntos;
    }
    
    
}
