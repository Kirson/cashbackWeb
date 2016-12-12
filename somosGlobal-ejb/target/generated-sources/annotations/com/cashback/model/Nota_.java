package com.cashback.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:08")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(Nota.class)
public class Nota_ { 

    public static volatile SingularAttribute<Nota, Integer> notId;
    public static volatile SingularAttribute<Nota, String> notCuerpo;
    public static volatile SingularAttribute<Nota, Integer> notValorizacion;
    public static volatile SingularAttribute<Nota, String> notEncabezado;
    public static volatile SingularAttribute<Nota, String> notComentarioAdmin;
    public static volatile SingularAttribute<Nota, Integer> perId;
    public static volatile SingularAttribute<Nota, Integer> catId;
    public static volatile SingularAttribute<Nota, Date> notFecha;

}