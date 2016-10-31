/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.interfaces.ISecuencia;
import com.cashback.model.Secuencia;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SSecuencia extends AbstractService implements ISecuencia {

    @Override
    public Secuencia obtenerSecuencia(String tabla) {
        
        String jpql = "SELECT s FROM Secuencia s WHERE s.tabla =:tabla";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("tabla", tabla);
	@SuppressWarnings("unchecked")
	Secuencia secuencia = (Secuencia) q.getSingleResult();
        
        Integer siguienteValor = secuencia.getSiguienteValor();
        Integer incremento = secuencia.getIncremento();
        siguienteValor = siguienteValor + incremento;
        
        secuencia.setSiguienteValor(siguienteValor);
        
        emCashback.persist(secuencia);
        return secuencia;
    }
    
}
