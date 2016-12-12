package com.cashback.model;

import com.cashback.model.MenuPerfil;
import com.cashback.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile ListAttribute<Perfil, MenuPerfil> menuPerfils;
    public static volatile SingularAttribute<Perfil, String> prfCodigo;
    public static volatile ListAttribute<Perfil, Usuario> usuarioList;
    public static volatile SingularAttribute<Perfil, String> prfNombre;
    public static volatile SingularAttribute<Perfil, Integer> prfId;
    public static volatile SingularAttribute<Perfil, String> prfEstado;

}