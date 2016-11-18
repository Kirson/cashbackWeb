/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.interfaces.IFormaPago;
import com.cashback.model.FormaPago;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SFormaPago extends AbstractService implements IFormaPago{

    @Override
    public List<FormaPago> getAll() {
        String jpql = "SELECT fp FROM FormaPago fp";
	Query q = emCashback.createQuery(jpql);
        List<FormaPago> result = q.getResultList();
        return result;
    }
    
}
