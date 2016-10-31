/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.interfaces.IComprobanteItem;
import com.cashback.model.Comprobante;
import com.cashback.model.ComprobanteItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SComprobanteItem extends AbstractService implements IComprobanteItem{

    @Override
    public void guardarItem(ComprobanteItem item) {
        emCashback.persist(item);
    }

    @Override
    public List<ComprobanteItem> listarItemsComprobante(Comprobante comprobante) {
        String jpql = "SELECT ci FROM ComprobanteItem ci WHERE ci.comprobante =:comprobante";
	Query q = emCashback.createQuery(jpql);
	q.setParameter("comprobante", comprobante);
	@SuppressWarnings("unchecked")
	List<ComprobanteItem> list = (List<ComprobanteItem>) q.getResultList();
        
        return list;
    }
    
}
