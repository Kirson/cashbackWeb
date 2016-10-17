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
    public List<PuntosActor> recuperarPuntos(Actor actor) {
       String jpql = "SELECT p FROM PuntosActor p WHERE p.actor =:actor";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("actor", actor);
	@SuppressWarnings("unchecked")
	List<PuntosActor> puntosList = (List<PuntosActor>) q.getResultList();
	return puntosList;
    }
    
}
