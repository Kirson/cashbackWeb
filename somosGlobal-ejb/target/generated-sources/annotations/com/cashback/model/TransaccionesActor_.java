package com.cashback.model;

import com.cashback.model.Actor;
import com.cashback.model.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-25T21:46:30")
@StaticMetamodel(TransaccionesActor.class)
public class TransaccionesActor_ { 

    public static volatile SingularAttribute<TransaccionesActor, Integer> puntosTransaccion;
    public static volatile SingularAttribute<TransaccionesActor, String> tipo;
    public static volatile SingularAttribute<TransaccionesActor, String> descripcionCompra;
    public static volatile SingularAttribute<TransaccionesActor, BigDecimal> valorCompra;
    public static volatile SingularAttribute<TransaccionesActor, String> numeroComprobante;
    public static volatile SingularAttribute<TransaccionesActor, String> numDocumentoActor;
    public static volatile SingularAttribute<TransaccionesActor, Actor> localVenta;
    public static volatile SingularAttribute<TransaccionesActor, Actor> beneficiario;
    public static volatile SingularAttribute<TransaccionesActor, Integer> puntosGanados;
    public static volatile SingularAttribute<TransaccionesActor, Date> fechaTransaccion;
    public static volatile SingularAttribute<TransaccionesActor, String> numDocumentoBeneficiario;
    public static volatile SingularAttribute<TransaccionesActor, BigDecimal> porcentajeDescuento;
    public static volatile SingularAttribute<TransaccionesActor, String> signo;
    public static volatile SingularAttribute<TransaccionesActor, Usuario> usuario;
    public static volatile SingularAttribute<TransaccionesActor, Integer> id;
    public static volatile SingularAttribute<TransaccionesActor, Actor> consumidor;

}