package com.cashback.model;

import com.cashback.model.LocalVenta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-25T21:46:30")
@StaticMetamodel(LocalPromocion.class)
public class LocalPromocion_ { 

    public static volatile SingularAttribute<LocalPromocion, String> lpUsrCrea;
    public static volatile SingularAttribute<LocalPromocion, String> lpTipo;
    public static volatile SingularAttribute<LocalPromocion, String> lpDetalle;
    public static volatile SingularAttribute<LocalPromocion, String> lpEstado;
    public static volatile SingularAttribute<LocalPromocion, Date> lpFecCrea;
    public static volatile SingularAttribute<LocalPromocion, String> lpUsrModif;
    public static volatile SingularAttribute<LocalPromocion, Integer> lpId;
    public static volatile SingularAttribute<LocalPromocion, LocalVenta> localVenta;
    public static volatile SingularAttribute<LocalPromocion, String> lpImagen;

}