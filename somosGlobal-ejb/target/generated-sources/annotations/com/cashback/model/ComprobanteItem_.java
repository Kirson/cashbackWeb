package com.cashback.model;

import com.cashback.model.Comprobante;
import com.cashback.model.ItemLoc;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(ComprobanteItem.class)
public class ComprobanteItem_ { 

    public static volatile SingularAttribute<ComprobanteItem, Comprobante> idComprobante;
    public static volatile SingularAttribute<ComprobanteItem, String> descripcionItem;
    public static volatile SingularAttribute<ComprobanteItem, BigDecimal> valorItem;
    public static volatile SingularAttribute<ComprobanteItem, Long> cantidad;
<<<<<<< HEAD
    public static volatile SingularAttribute<ComprobanteItem, BigDecimal> porcentajeAplicado;
=======
    public static volatile SingularAttribute<ComprobanteItem, ItemLoc> item;
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
    public static volatile SingularAttribute<ComprobanteItem, Integer> idItem;
    public static volatile SingularAttribute<ComprobanteItem, String> numComprobante;
    public static volatile SingularAttribute<ComprobanteItem, BigDecimal> valorTotal;

}