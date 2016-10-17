/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.controller;

import com.cashback.bean.PuntosBean;
import com.cashback.model.Actor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author somosGlobal
 */
@SessionScoped
@ManagedBean
public class RegistroPuntosCtr extends Controladores {
    
    private PuntosBean puntosBean;
    private List<Actor> consumidores;
    private List<Actor> locales;

    public PuntosBean getPuntosBean() {
        return puntosBean;
    }

    public void setPuntosBean(PuntosBean puntosBean) {
        this.puntosBean = puntosBean;
    }

    public List<Actor> getConsumidores() {
        return consumidores;
    }

    public void setConsumidores(List<Actor> consumidores) {
        this.consumidores = consumidores;
    }

    public List<Actor> getLocales() {
        return locales;
    }

    public void setLocales(List<Actor> locales) {
        this.locales = locales;
    }
    
    public RegistroPuntosCtr(){
        super();
    }
}
