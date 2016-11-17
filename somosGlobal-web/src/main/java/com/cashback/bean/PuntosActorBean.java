/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.bean;

import com.cashback.model.Actor;
import java.io.Serializable;

/**
 *
 * @author somosGlobal
 */
public class PuntosActorBean implements Serializable {
    
    private Actor actor;
    private ActorBean consumidor;
    private ActorBean local;
    private ActorBean beneficiario;
    private String descripcionCompra;
    private Double valorCompra;
    private Double porcentaje;
    private Long punto;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

 
    public String getDescripcionCompra() {
        return descripcionCompra;
    }

    public void setDescripcionCompra(String descripcionCompra) {
        this.descripcionCompra = descripcionCompra;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Long getPunto() {
        return punto;
    }

    public void setPunto(Long punto) {
        this.punto = punto;
    }

    public ActorBean getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(ActorBean consumidor) {
        this.consumidor = consumidor;
    }

    public ActorBean getLocal() {
        return local;
    }

    public void setLocal(ActorBean local) {
        this.local = local;
    }

    public ActorBean getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(ActorBean beneficiario) {
        this.beneficiario = beneficiario;
    }
    
    
}
