package com.cashback.model;

import com.cashback.model.Actor;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-02T01:42:23")
@StaticMetamodel(TransaccionesActor.class)
public class TransaccionesActor_ { 

    public static volatile SingularAttribute<TransaccionesActor, Integer> puntosTransaccion;
    public static volatile SingularAttribute<TransaccionesActor, Integer> puntosGanados;
    public static volatile SingularAttribute<TransaccionesActor, Date> fechaTransaccion;
    public static volatile SingularAttribute<TransaccionesActor, String> numDocumentoBeneficiario;
    public static volatile SingularAttribute<TransaccionesActor, BigDecimal> porcentajeDescuento;
    public static volatile SingularAttribute<TransaccionesActor, String> descripcionCompra;
    public static volatile SingularAttribute<TransaccionesActor, BigDecimal> valorCompra;
    public static volatile SingularAttribute<TransaccionesActor, Integer> id;
    public static volatile SingularAttribute<TransaccionesActor, String> numDocumentoActor;
    public static volatile SingularAttribute<TransaccionesActor, Actor> localVenta;
    public static volatile SingularAttribute<TransaccionesActor, Actor> consumidor;
    public static volatile SingularAttribute<TransaccionesActor, Actor> beneficiario;

}