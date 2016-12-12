package com.cashback.model;

import com.cashback.model.LocalVenta;
import com.cashback.model.Persona;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(Puntos.class)
public class Puntos_ { 

    public static volatile SingularAttribute<Puntos, Date> ptoVigDesde;
    public static volatile SingularAttribute<Puntos, BigDecimal> ptoValor;
    public static volatile SingularAttribute<Puntos, Date> ptoVigHasta;
    public static volatile SingularAttribute<Puntos, LocalVenta> localVenta;
    public static volatile SingularAttribute<Puntos, Integer> ptoCantidad;
    public static volatile SingularAttribute<Puntos, Integer> ptoId;
    public static volatile SingularAttribute<Puntos, Persona> persona;

}