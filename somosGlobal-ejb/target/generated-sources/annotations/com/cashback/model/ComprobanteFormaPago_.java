package com.cashback.model;

import com.cashback.model.Comprobante;
import com.cashback.model.FormaPago;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
@StaticMetamodel(ComprobanteFormaPago.class)
public class ComprobanteFormaPago_ { 

    public static volatile SingularAttribute<ComprobanteFormaPago, Integer> idFp;
    public static volatile SingularAttribute<ComprobanteFormaPago, Comprobante> idComprobante;
    public static volatile SingularAttribute<ComprobanteFormaPago, BigDecimal> valorFormaPago;
    public static volatile SingularAttribute<ComprobanteFormaPago, FormaPago> formaPago;
    public static volatile SingularAttribute<ComprobanteFormaPago, String> numComprobante;
    public static volatile SingularAttribute<ComprobanteFormaPago, String> descripcionFormaPago;

}