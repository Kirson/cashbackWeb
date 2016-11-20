/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.enums.AppMensajes;
import com.cashback.excepciones.ExcGuardarRegistro;
import com.cashback.model.Actor;
import com.cashback.model.PuntosActor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import com.cashback.interfaces.IPuntosActor;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SPuntosActor extends AbstractService implements IPuntosActor{

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void crearPuntos(PuntosActor puntos) throws ExcGuardarRegistro {
        try {
            emCashback.persist(puntos);
	} catch (PersistenceException e) {
            e.printStackTrace();
            throw new ExcGuardarRegistro(AppMensajes.ERR_CREAR_REGISTRO);
	}
    }

    @Override
    public PuntosActor recuperarPuntos(Actor actor) {
       String jpql = "SELECT p FROM PuntosActor p WHERE p.actor =:actor";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("actor", actor);
        
	@SuppressWarnings("unchecked")
        PuntosActor puntos = (PuntosActor) q.getSingleResult();
	return puntos;
    }

    @Override
    public List<PuntosActor> getPuntos() {
        String jpql = "SELECT p FROM PuntosActor p ";
        Query q = emCashback.createQuery(jpql);
        @SuppressWarnings("unchecked")
        List<PuntosActor> puntos = (List<PuntosActor>) q.getSingleResult();
        return puntos;
    }

    @Override
    public void actualizarPuntos(PuntosActor puntos) throws ExcGuardarRegistro {
        try {
            emCashback.merge(puntos);
	} catch (PersistenceException e) {
            e.printStackTrace();
            throw new ExcGuardarRegistro(AppMensajes.ERR_CREAR_REGISTRO);
	}
    }
    
    
    
}
