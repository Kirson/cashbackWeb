package com.cashback.model;

import com.cashback.model.Actor;
import com.cashback.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-22T02:09:27")
@StaticMetamodel(PuntosActor.class)
public class PuntosActor_ { 

    public static volatile SingularAttribute<PuntosActor, Actor> actor;
    public static volatile SingularAttribute<PuntosActor, Date> vigHasta;
    public static volatile SingularAttribute<PuntosActor, Integer> totalPuntos;
    public static volatile SingularAttribute<PuntosActor, Date> vigDesde;
    public static volatile SingularAttribute<PuntosActor, Usuario> usuario;
    public static volatile SingularAttribute<PuntosActor, Integer> id;
    public static volatile SingularAttribute<PuntosActor, String> numDocumentoActor;

}