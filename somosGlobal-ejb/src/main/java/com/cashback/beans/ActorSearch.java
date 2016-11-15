/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.beans;

import java.io.Serializable;

/**
 *
 * @author somosGlobal
 */
public class ActorSearch implements Serializable {
    
    private String cedRucPasAct;
    private String razonSocialAct;
    private String nombres;
    private String apellidos;

    public String getCedRucPasAct() {
        return cedRucPasAct;
    }

    public void setCedRucPasAct(String cedRucPasAct) {
        this.cedRucPasAct = cedRucPasAct;
    }

    public String getRazonSocialAct() {
        return razonSocialAct;
    }

    public void setRazonSocialAct(String razonSocialAct) {
        this.razonSocialAct = razonSocialAct;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
}
