/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.controller;

import com.cashback.bean.ArchivoTransaccionBean;
import com.cashback.interfaces.IActor;
import com.cashback.interfaces.ITransaccionesActor;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author somosGlobal
 */
@SessionScoped
@ManagedBean
public class CargaPuntosCtr extends Controladores {
    
    @EJB
    private IActor sActor;

    @EJB
    private ITransaccionesActor sTransaccionesActor;
    
    private ArchivoTransaccionBean archivoTransaccionBean;

    public ArchivoTransaccionBean getArchivoTransaccionBean() {
        return archivoTransaccionBean;
    }

    public void setArchivoTransaccionBean(ArchivoTransaccionBean archivoTransaccionBean) {
        this.archivoTransaccionBean = archivoTransaccionBean;
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
