package com.cashback.model;

import com.cashback.model.LocalVenta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T17:27:07")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T20:07:58")
>>>>>>> c208ce7b9f6ec6e782159ee34b30719f8d73a5c4
@StaticMetamodel(LocalPromocion.class)
public class LocalPromocion_ { 

    public static volatile SingularAttribute<LocalPromocion, String> lpEstado;
    public static volatile SingularAttribute<LocalPromocion, Integer> lpId;
    public static volatile SingularAttribute<LocalPromocion, String> lpUsrModif;
    public static volatile SingularAttribute<LocalPromocion, LocalVenta> localVenta;
    public static volatile SingularAttribute<LocalPromocion, String> lpDetalle;
    public static volatile SingularAttribute<LocalPromocion, String> lpImagen;
    public static volatile SingularAttribute<LocalPromocion, String> lpTipo;
    public static volatile SingularAttribute<LocalPromocion, Date> lpFecCrea;
    public static volatile SingularAttribute<LocalPromocion, String> lpUsrCrea;

}