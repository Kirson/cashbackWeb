package com.cashback.model;

import com.cashback.model.Actor;
import com.cashback.model.ItemGlo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-24T22:16:38")
@StaticMetamodel(ItemLoc.class)
public class ItemLoc_ { 

    public static volatile SingularAttribute<ItemLoc, Actor> idAct;
    public static volatile SingularAttribute<ItemLoc, Double> porcFijoIl;
    public static volatile SingularAttribute<ItemLoc, String> nombreIl;
    public static volatile SingularAttribute<ItemLoc, ItemGlo> idIg;
    public static volatile SingularAttribute<ItemLoc, Double> porcVarIl;
    public static volatile SingularAttribute<ItemLoc, String> ivaIl;
    public static volatile SingularAttribute<ItemLoc, Double> cosUniIl;
    public static volatile SingularAttribute<ItemLoc, Long> idIl;

}