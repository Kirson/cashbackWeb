/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.interfaces.IItemGlo;
import com.cashback.model.ItemGlo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SItemGlo extends AbstractService implements IItemGlo {

    @Override
    public List<ItemGlo> getAll() {
        String jpql = "SELECT ig FROM ItemGlo ig";
	Query q = emCashback.createQuery(jpql);
        List<ItemGlo> result = q.getResultList();
        return result;
    }

    @Override
    public ItemGlo finById(Long id) {
        ItemGlo item = emCashback.find(ItemGlo.class, id);
	return item;
    }
    
}
