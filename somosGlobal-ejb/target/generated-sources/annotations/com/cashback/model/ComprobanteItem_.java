package com.cashback.model;

import com.cashback.model.Comprobante;
import com.cashback.model.ItemLoc;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T06:03:36")
@StaticMetamodel(ComprobanteItem.class)
public class ComprobanteItem_ { 

    public static volatile SingularAttribute<ComprobanteItem, String> numComprobante;
    public static volatile SingularAttribute<ComprobanteItem, ItemLoc> item;
    public static volatile SingularAttribute<ComprobanteItem, BigDecimal> valorItem;
    public static volatile SingularAttribute<ComprobanteItem, Comprobante> idComprobante;
    public static volatile SingularAttribute<ComprobanteItem, BigDecimal> valorTotal;
    public static volatile SingularAttribute<ComprobanteItem, String> descripcionItem;
    public static volatile SingularAttribute<ComprobanteItem, Long> cantidad;
    public static volatile SingularAttribute<ComprobanteItem, Integer> idItem;

}