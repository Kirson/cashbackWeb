/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.interfaces;

import com.cashback.beans.ComprobanteBean;
import com.cashback.model.Actor;
import com.cashback.model.Comprobante;
import java.util.Date;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public interface IComprobante {
    
    ComprobanteBean guardarComprobante(ComprobanteBean comprobanteBean);
    void crearComprobante(Comprobante comprobante);
    List<Comprobante> listarComprobantesActor(Actor actor);
    List<Comprobante> listarComprobantesLocal(Actor local);
    List<Comprobante> listarComprobantesLocalFecha(Actor local, String fecha);
    List<Comprobante> listarComprobantesLocalFechaComprobante(Actor local, Date fechaComprobante);
}
