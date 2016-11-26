/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.interfaces;

import com.cashback.excepciones.ExcGuardarRegistro;
import com.cashback.model.Actor;
import com.cashback.model.TransaccionesActor;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public interface ITransaccionesActor {
    
    void crearTransaccion(TransaccionesActor transaccion) throws ExcGuardarRegistro;

    List<TransaccionesActor> recuperarHistorialTransaccion(Actor actor);
    List<TransaccionesActor> buscarTransaccionesComprobante(String numeroComprobante);
}
