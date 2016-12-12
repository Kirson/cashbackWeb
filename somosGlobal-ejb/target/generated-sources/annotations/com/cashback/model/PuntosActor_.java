package com.cashback.model;

import com.cashback.model.Actor;
import com.cashback.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(PuntosActor.class)
public class PuntosActor_ { 

    public static volatile SingularAttribute<PuntosActor, Integer> id;
    public static volatile SingularAttribute<PuntosActor, Usuario> usuario;
    public static volatile SingularAttribute<PuntosActor, String> numDocumentoActor;
    public static volatile SingularAttribute<PuntosActor, Actor> actor;
    public static volatile SingularAttribute<PuntosActor, Date> vigDesde;
    public static volatile SingularAttribute<PuntosActor, Integer> totalPuntos;
    public static volatile SingularAttribute<PuntosActor, Date> vigHasta;

}