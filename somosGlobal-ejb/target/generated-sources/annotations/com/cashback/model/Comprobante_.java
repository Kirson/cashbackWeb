package com.cashback.model;

import com.cashback.model.Actor;
import com.cashback.model.ComprobanteFormaPago;
import com.cashback.model.ComprobanteItem;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(Comprobante.class)
public class Comprobante_ { 

    public static volatile SingularAttribute<Comprobante, String> fecha;
    public static volatile SingularAttribute<Comprobante, BigDecimal> porcentajeDescuento;
    public static volatile SingularAttribute<Comprobante, Date> fechaComprobante;
    public static volatile ListAttribute<Comprobante, ComprobanteFormaPago> comprobanteFormaPagoList;
    public static volatile SingularAttribute<Comprobante, String> descripcionCompra;
    public static volatile SingularAttribute<Comprobante, BigDecimal> totalCompra;
    public static volatile ListAttribute<Comprobante, ComprobanteItem> comprobanteItemList;
    public static volatile SingularAttribute<Comprobante, Integer> idComprobante;
    public static volatile SingularAttribute<Comprobante, Integer> puntosGanados;
    public static volatile SingularAttribute<Comprobante, Actor> localVenta;
    public static volatile SingularAttribute<Comprobante, Actor> cliente;
    public static volatile SingularAttribute<Comprobante, BigDecimal> valorCompra;
    public static volatile SingularAttribute<Comprobante, String> numComprobante;
    public static volatile SingularAttribute<Comprobante, Boolean> pagaPuntos;
    public static volatile SingularAttribute<Comprobante, String> numDocumento;
    public static volatile SingularAttribute<Comprobante, BigDecimal> valorIva;
    public static volatile SingularAttribute<Comprobante, Integer> puntosTransaccion;

}