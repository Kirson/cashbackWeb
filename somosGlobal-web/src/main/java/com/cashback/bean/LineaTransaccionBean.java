/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author somosGlobal
 */
public class LineaTransaccionBean implements Serializable{
    
    private Long idLocal;
    private String numDocumentoActor;
    private String nombreActor;
    private String apellidoActor;
    private String email;
    private Double valorCompra;
    private Date fechaCompra;

    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public String getNumDocumentoActor() {
        return numDocumentoActor;
    }

    public void setNumDocumentoActor(String numDocumentoActor) {
        this.numDocumentoActor = numDocumentoActor;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public String getApellidoActor() {
        return apellidoActor;
    }

    public void setApellidoActor(String apellidoActor) {
        this.apellidoActor = apellidoActor;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
