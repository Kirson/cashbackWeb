/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.servicios;

import com.cashback.interfaces.IItemLoc;
import com.cashback.model.Actor;
import com.cashback.model.ItemGlo;
import com.cashback.model.ItemLoc;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author somosGlobal
 */
@Stateless
public class SItemLoc extends AbstractService implements IItemLoc{

    @Override
    public List<ItemLoc> getAll() {
        String jpql = "SELECT il FROM ItemLoc il";
	Query q = emCashback.createQuery(jpql);
        List<ItemLoc> result = q.getResultList();
        return result;
    }

    @Override
    public List<ItemLoc> findByLocal(Actor local) {
        String jpql = "SELECT il FROM ItemLoc il WHERE il.actor =:local";
	Query q = emCashback.createQuery(jpql);
        q.setParameter("local", local);
        List<ItemLoc> result = q.getResultList();
        return result;
    }

    @Override
    public List<ItemLoc> findByItemGlobal(ItemGlo iglo) {
        String jpql = "SELECT il FROM ItemLoc il WHERE il.idIg =:itemGlobal";
	Query q = emCashback.createQuery(jpql);
        q.setParameter("itemGlobal", iglo);
        List<ItemLoc> result = q.getResultList();
        return result;
    }

    @Override
    public ItemLoc findById(Long id) {
        ItemLoc item = emCashback.find(ItemLoc.class, id);
	return item;
    }
    
}
