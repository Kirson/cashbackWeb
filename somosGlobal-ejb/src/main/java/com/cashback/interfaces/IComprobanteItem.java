/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.interfaces;

import com.cashback.model.Comprobante;
import com.cashback.model.ComprobanteItem;
import java.util.List;

/**
 *
 * @author somosGlobal
 */
public interface IComprobanteItem {
    
    void guardarItem(ComprobanteItem item);
    List<ComprobanteItem> listarItemsComprobante(Comprobante comprobante);
}
