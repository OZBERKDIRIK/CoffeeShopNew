package org.factory.coffeefactory;

import org.coffee.*;

public enum CoffeeEnum
{
    AMERICANO("Americano",1,18),
    ESPRESSO("Espresso",2,10) ,
    DOUBLE_ESPRESSO("Double Espresso" ,3,20),
    CAFFEE_LATE("Caffee Late" ,4,18) ,
    CAPPUCINO("Cappucino",5,32) ,
    MOCHA("Mocha",6,41) ,
    DEFAULT("Yaratmak istediğiniz kahve türü ",7,0) ;
    private final String name;
    private final int index;

    private final int price;
    public String getName() {
        return name;
    }
    public int getIndex() {
        return index;
    }
    public int getPrice(){
        return price;
    }
    CoffeeEnum(String name, int index,int price) {
        this.name=name;
        this.index=index;
        this.price=price;
    }
}
