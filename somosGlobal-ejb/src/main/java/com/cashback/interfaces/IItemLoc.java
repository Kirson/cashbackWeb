/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.interfaces;

import com.cashback.model.Actor;
import com.cashback.model.ItemGlo;
import com.cashback.model.ItemLoc;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public interface IItemLoc {
    
    List<ItemLoc> getAll();
    List<ItemLoc> findByLocal(Actor local);
    List<ItemLoc> findByItemGlobal(ItemGlo iglo);
    ItemLoc findById(Long id);
}
