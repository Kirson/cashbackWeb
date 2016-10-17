/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.interfaces;

import com.cashback.excepciones.ExcGuardarRegistro;
import com.cashback.model.Actor;
import com.cashback.model.PuntosActor;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public interface IPuntosActor {
    
    void crearPuntos(PuntosActor puntos) throws ExcGuardarRegistro;

    List<PuntosActor> recuperarPuntos(Actor actor);
}
