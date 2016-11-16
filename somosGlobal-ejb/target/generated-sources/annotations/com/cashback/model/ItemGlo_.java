package com.cashback.model;

import com.cashback.model.ItemLoc;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-16T11:53:06")
@StaticMetamodel(ItemGlo.class)
public class ItemGlo_ { 

    public static volatile SingularAttribute<ItemGlo, String> monbreIg;
    public static volatile SingularAttribute<ItemGlo, String> refIg;
    public static volatile ListAttribute<ItemGlo, ItemLoc> itemLocList;
    public static volatile SingularAttribute<ItemGlo, Long> idIg;

}