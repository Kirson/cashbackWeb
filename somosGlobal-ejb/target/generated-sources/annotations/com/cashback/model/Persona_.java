package com.cashback.model;

import com.cashback.model.Contacto;
import com.cashback.model.HobbiePersona;
import com.cashback.model.LocalVenta;
import com.cashback.model.Puntos;
import com.cashback.model.Transaccion;
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
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> perApellidos;
    public static volatile SingularAttribute<Persona, String> perNombres;
    public static volatile SingularAttribute<Persona, Date> perFecNac;
    public static volatile ListAttribute<Persona, Contacto> contactos;
    public static volatile SingularAttribute<Persona, Integer> perId;
    public static volatile ListAttribute<Persona, Transaccion> transaccions;
    public static volatile SingularAttribute<Persona, String> perEmail;
    public static volatile SingularAttribute<Persona, String> perCedRucPas;
    public static volatile SingularAttribute<Persona, String> perEstado;
    public static volatile ListAttribute<Persona, Puntos> puntos;
    public static volatile SingularAttribute<Persona, String> perFoto;
    public static volatile ListAttribute<Persona, HobbiePersona> hobbiePersonas;
    public static volatile SingularAttribute<Persona, Integer> perSexo;
    public static volatile ListAttribute<Persona, LocalVenta> localVentas;

}