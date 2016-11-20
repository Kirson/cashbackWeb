/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.beans;

import com.cashback.model.Actor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public class CierreDiaLocalBean implements Serializable{
    
    private Actor local;
    private Long numeroTransacciones;
    private Double totalVentas;
    private List<FormaPagoBean> listaFormaPago;
    private Date fechaConsulta;
    
    @SuppressWarnings("Convert2Diamond")
    public CierreDiaLocalBean(){
        listaFormaPago = new ArrayList<FormaPagoBean>();
        totalVentas = new Double(0);
        numeroTransacciones = 0L;
        fechaConsulta = new Date();
    }

    public Actor getLocal() {
        return local;
    }

    public void setLocal(Actor local) {
        this.local = local;
    }

    public Long getNumeroTransacciones() {
        return numeroTransacciones;
    }

    public void setNumeroTransacciones(Long numeroTransacciones) {
        this.numeroTransacciones = numeroTransacciones;
    }

    public Double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public List<FormaPagoBean> getListaFormaPago() {
        return listaFormaPago;
    }

    public void setListaFormaPago(List<FormaPagoBean> listaFormaPago) {
        this.listaFormaPago = listaFormaPago;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }
    
    
}
