package com.cashback.model;

import com.cashback.model.LocalVenta;
import com.cashback.model.Persona;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:08")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, BigDecimal> traValorFac;
    public static volatile SingularAttribute<Transaccion, LocalVenta> localVenta;
    public static volatile SingularAttribute<Transaccion, Integer> traId;
    public static volatile SingularAttribute<Transaccion, String> traEstado;
    public static volatile SingularAttribute<Transaccion, String> traFactura;
    public static volatile SingularAttribute<Transaccion, Integer> traPtosAcreditados;
    public static volatile SingularAttribute<Transaccion, Integer> traTipo;
    public static volatile SingularAttribute<Transaccion, Persona> persona;

}