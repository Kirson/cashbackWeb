package com.cashback.model;

import com.cashback.model.Ciudad;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-22T21:14:05")
@StaticMetamodel(Provincia.class)
public class Provincia_ { 

    public static volatile SingularAttribute<Provincia, Integer> prvId;
    public static volatile SingularAttribute<Provincia, String> prvNombre;
    public static volatile ListAttribute<Provincia, Ciudad> ciudads;

}