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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.faces.validator.Validator;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class STransaccionesActor extends AbstractService implements ITransaccionesActor {

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void crearTransaccion(TransaccionesActor transaccion) throws ExcGuardarRegistro {
        try {

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            javax.validation.Validator validator = factory.getValidator();
            Set<ConstraintViolation<TransaccionesActor>> constraintViolations = validator.validate(transaccion);
            if (constraintViolations.size() > 0) {
                Iterator<ConstraintViolation<TransaccionesActor>> iterator = constraintViolations.iterator();
                while (iterator.hasNext()) {
                    ConstraintViolation<TransaccionesActor> cv = iterator.next();
                    System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());

                    //JsfUtil.addErrorMessage(cv.getRootBeanClass().getSimpleName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
                }
            } else {
                emCashback.persist(transaccion);
            }

            //emCashback.persist(transaccion);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new ExcGuardarRegistro(AppMensajes.ERR_CREAR_REGISTRO);
        }
    }

    @Override
    public List<TransaccionesActor> recuperarHistorialTransaccion(Actor consumidor) {
        String jpql = "SELECT ta FROM TransaccionesActor ta WHERE ta.consumidor =:consumidor";
        Query q = emCashback.createQuery(jpql);
        q.setParameter("consumidor", consumidor);
        @SuppressWarnings("unchecked")
        List<TransaccionesActor> puntosList = (List<TransaccionesActor>) q.getResultList();
        return puntosList;
    }

    @Override
    public List<TransaccionesActor> buscarTransaccionesComprobante(String numeroComprobante) {
        String jpql = "SELECT ta FROM TransaccionesActor ta WHERE ta.numeroComprobante =:numeroComprobante";
        Query q = emCashback.createQuery(jpql);
        q.setParameter("numeroComprobante", numeroComprobante);
        @SuppressWarnings("unchecked")
        List<TransaccionesActor> puntosList = (List<TransaccionesActor>) q.getResultList();
        return puntosList;
    }

}
