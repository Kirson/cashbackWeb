package com.cashback.model;

import com.cashback.model.LocalVenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:08")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(HorarioAtencion.class)
public class HorarioAtencion_ { 

    public static volatile SingularAttribute<HorarioAtencion, Integer> haId;
    public static volatile SingularAttribute<HorarioAtencion, String> haDia;
    public static volatile SingularAttribute<HorarioAtencion, LocalVenta> localVenta;
    public static volatile SingularAttribute<HorarioAtencion, String> haApertura;
    public static volatile SingularAttribute<HorarioAtencion, String> haEstado;
    public static volatile SingularAttribute<HorarioAtencion, String> haCierre;

}