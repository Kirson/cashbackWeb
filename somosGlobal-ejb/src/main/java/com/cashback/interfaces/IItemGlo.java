/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.interfaces;

import com.cashback.model.ItemGlo;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public interface IItemGlo {
    
    List<ItemGlo> getAll();
    ItemGlo finById(Long id);
}
