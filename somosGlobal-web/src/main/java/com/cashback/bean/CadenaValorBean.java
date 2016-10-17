/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.bean;

import com.cashback.model.Actor;
import com.cashback.model.ActorRol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public class CadenaValorBean implements Serializable{
    
    private Actor consumidor;
    private Actor local;
    private List<Actor> actores;
    private List<ActorRol> listaActorRol;
    
    @SuppressWarnings("Convert2Diamond")
    public CadenaValorBean(){
        actores = new ArrayList<Actor>();
        listaActorRol = new ArrayList<ActorRol>();
    }

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

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public List<ActorRol> getListaActorRol() {
        return listaActorRol;
    }

    public void setListaActorRol(List<ActorRol> listaActorRol) {
        this.listaActorRol = listaActorRol;
    }
    
    
}
