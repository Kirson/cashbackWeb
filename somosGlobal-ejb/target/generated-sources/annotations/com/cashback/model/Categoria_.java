package com.cashback.model;

import com.cashback.model.LocalVenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-24T22:16:38")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> catId;
    public static volatile SingularAttribute<Categoria, String> catImagen;
    public static volatile ListAttribute<Categoria, LocalVenta> localVentas;
    public static volatile SingularAttribute<Categoria, String> catEstado;
    public static volatile SingularAttribute<Categoria, String> catNombre;

}