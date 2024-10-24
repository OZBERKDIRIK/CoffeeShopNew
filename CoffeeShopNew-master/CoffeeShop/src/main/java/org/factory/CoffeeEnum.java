package org.factory;

import org.coffee.*;

public enum CoffeeEnum
{
    AMERICANO("Americano",1),
    ESPRESSO("Espresso",2) ,
    DOUBLE_ESPRESSO("Double Espresso" ,3),
    CAFFEE_LATE("Caffee Late" ,4) ,
    CAPPUCINO("Cappucino",5) ,
    MOCHA("Mocha",6) ,
    DEFAULT("Yaratmak istediğiniz kahve türü ",7) ;
    private final String name;
    private final int index;
    public String getName() {
        return name;
    }
    public int getIndex() {
        return index;
    }
    CoffeeEnum(String name, int index) {
        this.name=name;
        this.index=index;
    }
}
