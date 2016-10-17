/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.enums.AppMensajes;
import com.cashback.excepciones.ExcGuardarRegistro;
import com.cashback.interfaces.ITransaccionesActor;
import com.cashback.model.Actor;
import com.cashback.model.TransaccionesActor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class STransaccionesActor extends AbstractService implements ITransaccionesActor{

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void crearTransaccion(TransaccionesActor transaccion) throws ExcGuardarRegistro {
        try {
            emCashback.persist(transaccion);
	} catch (PersistenceException e) {
            e.printStackTrace();
            throw new ExcGuardarRegistro(AppMensajes.ERR_CREAR_REGISTRO);
	}
    }

    @Override
    public List<TransaccionesActor> recuperarHistorialTransaccion(Actor actor) {
        String jpql = "SELECT p FROM TransaccionesActor p WHERE p.actor =:actor";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("actor", actor);
	@SuppressWarnings("unchecked")
	List<TransaccionesActor> puntosList = (List<TransaccionesActor>) q.getResultList();
	return puntosList;
    }
    
}
