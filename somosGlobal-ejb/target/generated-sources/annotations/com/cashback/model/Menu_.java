package com.cashback.model;

import com.cashback.model.MenuPerfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile ListAttribute<Menu, MenuPerfil> menuPerfils;
    public static volatile SingularAttribute<Menu, String> menUrl;
    public static volatile SingularAttribute<Menu, String> menEstado;
    public static volatile SingularAttribute<Menu, String> menTipo;
    public static volatile SingularAttribute<Menu, Integer> menId;
    public static volatile SingularAttribute<Menu, String> menNombre;

}