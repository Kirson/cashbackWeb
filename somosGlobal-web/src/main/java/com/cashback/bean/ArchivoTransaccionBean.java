/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.bean;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public class ArchivoTransaccionBean implements Serializable {
    
    private List<LineaTransaccionBean> lineas;
    private File archivo;
    
    @SuppressWarnings("Convert2Diamond")
    public ArchivoTransaccionBean(){
        lineas = new ArrayList<LineaTransaccionBean>();
    }

    public List<LineaTransaccionBean> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaTransaccionBean> lineas) {
        this.lineas = lineas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
}
