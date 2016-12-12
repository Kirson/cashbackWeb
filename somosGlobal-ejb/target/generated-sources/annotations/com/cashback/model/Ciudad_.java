package com.cashback.model;

import com.cashback.model.Barrio;
import com.cashback.model.Provincia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, Integer> ciuId;
    public static volatile SingularAttribute<Ciudad, Provincia> provincia;
    public static volatile ListAttribute<Ciudad, Barrio> barrioList;
    public static volatile SingularAttribute<Ciudad, String> ciuNombre;

}