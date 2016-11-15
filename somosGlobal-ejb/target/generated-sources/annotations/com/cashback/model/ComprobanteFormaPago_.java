package com.cashback.model;

import com.cashback.model.Comprobante;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T06:03:37")
@StaticMetamodel(ComprobanteFormaPago.class)
public class ComprobanteFormaPago_ { 

    public static volatile SingularAttribute<ComprobanteFormaPago, String> numComprobante;
    public static volatile SingularAttribute<ComprobanteFormaPago, Integer> idFp;
    public static volatile SingularAttribute<ComprobanteFormaPago, Comprobante> idComprobante;
    public static volatile SingularAttribute<ComprobanteFormaPago, String> descripcionFormaPago;
    public static volatile SingularAttribute<ComprobanteFormaPago, BigDecimal> valorFormaPago;

}