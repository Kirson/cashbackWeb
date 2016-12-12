package com.cashback.model;

import com.cashback.model.Categoria;
import com.cashback.model.HorarioAtencion;
import com.cashback.model.LocalPromocion;
import com.cashback.model.Persona;
import com.cashback.model.Puntos;
import com.cashback.model.Transaccion;
import com.cashback.model.Ubicacion;
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
@StaticMetamodel(LocalVenta.class)
public class LocalVenta_ { 

    public static volatile ListAttribute<LocalVenta, HorarioAtencion> horarioAtencions;
    public static volatile SingularAttribute<LocalVenta, String> lvTelCel;
    public static volatile SingularAttribute<LocalVenta, String> lvLogo;
    public static volatile SingularAttribute<LocalVenta, String> lvvideo;
    public static volatile ListAttribute<LocalVenta, Transaccion> transaccions;
    public static volatile SingularAttribute<LocalVenta, Date> lvFechaCrea;
    public static volatile SingularAttribute<LocalVenta, String> lvFoto;
    public static volatile SingularAttribute<LocalVenta, String> lvmas;
    public static volatile SingularAttribute<LocalVenta, Categoria> categoria;
    public static volatile SingularAttribute<LocalVenta, String> lvNombreCom;
    public static volatile SingularAttribute<LocalVenta, String> lvEmail;
    public static volatile SingularAttribute<LocalVenta, String> lvUsrModifica;
    public static volatile SingularAttribute<LocalVenta, String> lvSlogan;
    public static volatile SingularAttribute<LocalVenta, String> lvEstado;
    public static volatile SingularAttribute<LocalVenta, Integer> lvId;
    public static volatile SingularAttribute<LocalVenta, String> lvTelefono;
    public static volatile SingularAttribute<LocalVenta, String> lvActividadPri;
    public static volatile SingularAttribute<LocalVenta, String> lvRazonSocial;
    public static volatile ListAttribute<LocalVenta, Ubicacion> ubicacions;
    public static volatile SingularAttribute<LocalVenta, String> lvUsrCrea;
    public static volatile SingularAttribute<LocalVenta, String> lvtwitter;
    public static volatile ListAttribute<LocalVenta, Puntos> puntos;
    public static volatile SingularAttribute<LocalVenta, String> lvPalabrasClave;
    public static volatile SingularAttribute<LocalVenta, String> lvfacebook;
    public static volatile SingularAttribute<LocalVenta, Date> lvFechaModifica;
    public static volatile SingularAttribute<LocalVenta, String> lvWeb;
    public static volatile SingularAttribute<LocalVenta, String> lvServicio;
    public static volatile SingularAttribute<LocalVenta, String> lvRuc;
    public static volatile ListAttribute<LocalVenta, LocalPromocion> localPromocionList;
    public static volatile SingularAttribute<LocalVenta, Integer> lvRanking;
    public static volatile SingularAttribute<LocalVenta, String> lvgeo;
    public static volatile SingularAttribute<LocalVenta, Persona> persona;
    public static volatile SingularAttribute<LocalVenta, String> lvpromo;

}