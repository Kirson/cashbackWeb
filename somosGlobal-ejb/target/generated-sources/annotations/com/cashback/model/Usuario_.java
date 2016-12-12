package com.cashback.model;

import com.cashback.model.Actor;
import com.cashback.model.Perfil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Date> usrFecCrea;
    public static volatile SingularAttribute<Usuario, String> usrNombre;
    public static volatile SingularAttribute<Usuario, String> usrNombre2;
    public static volatile SingularAttribute<Usuario, Integer> usrId;
    public static volatile SingularAttribute<Usuario, Perfil> perfil;
    public static volatile SingularAttribute<Usuario, String> usrCreadoPor;
    public static volatile SingularAttribute<Usuario, String> usrModPor;
    public static volatile SingularAttribute<Usuario, String> usrEstado;
    public static volatile SingularAttribute<Usuario, Actor> actor;
    public static volatile SingularAttribute<Usuario, String> usrPassword;
    public static volatile SingularAttribute<Usuario, String> usrCambiaPassword;
    public static volatile SingularAttribute<Usuario, Date> usrFecMod;

}