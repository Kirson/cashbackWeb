/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.beans;

import com.cashback.model.FormaPago;
import java.io.Serializable;

/**
 *
 * @author somosGlobal
 */
public class FormaPagoBean implements Serializable {
    
    private FormaPago formaPago;
    private Double totalFormaPago;
    
    public FormaPagoBean(){
        totalFormaPago = new Double(0);
    }

    /**
     * @return the formaPago
     */
    public FormaPago getFormaPago() {
        return formaPago;
    }

    /**
     * @param formaPago the formaPago to set
     */
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @return the totalFormaPago
     */
    public Double getTotalFormaPago() {
        return totalFormaPago;
    }

    /**
     * @param totalFormaPago the totalFormaPago to set
     */
    public void setTotalFormaPago(Double totalFormaPago) {
        this.totalFormaPago = totalFormaPago;
    }
    
    
}
