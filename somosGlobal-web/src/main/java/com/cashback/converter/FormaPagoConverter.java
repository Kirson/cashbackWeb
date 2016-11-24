/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.converter;

import com.cashback.model.FormaPago;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

/**
 *
 * @author somosGlobal
 */
@FacesConverter(value="FormaPagoConverter")
public class FormaPagoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent component, String value) {
        Object ret = null;

        if (component instanceof PickList) {
            Object dualList = ((PickList) component).getValue();
            DualListModel dl = (DualListModel) dualList;
            for (Object o : dl.getSource()) {
                String id = "" + ((FormaPago) o).getIdForPag();
                if (value.equals(id)) {
                    ret = o;
                    break;
                }
            }
            if (ret == null) {
                for (Object o : dl.getTarget()) {
                    String id = "" + ((FormaPago) o).getIdForPag();
                    if (value.equals(id)) {
                        ret = o;
                        break;
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
         String str = "";
        if (value instanceof FormaPago) {
            str = "" + ((FormaPago) value).getIdForPag();
        }
        return str;
    }
    
}
