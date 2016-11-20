/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.interfaces.IComprobanteFormaPago;
import com.cashback.model.Comprobante;
import com.cashback.model.ComprobanteFormaPago;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SComprobanteFormaPago extends AbstractService implements IComprobanteFormaPago {

    @Override
    public void guardarFormaPago(ComprobanteFormaPago formaPago) {
         emCashback.persist(formaPago);
    }

    @Override
    public List<ComprobanteFormaPago> listarFormaPagoComprobante(Comprobante comprobante) {
         String jpql = "SELECT cfp FROM ComprobanteFormaPago cfp WHERE cfp.idComprobante =:comprobante";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("comprobante", comprobante);
	@SuppressWarnings("unchecked")
	List<ComprobanteFormaPago> list = (List<ComprobanteFormaPago>) q.getResultList();
        return list;
    }
    
}
