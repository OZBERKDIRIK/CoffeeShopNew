package org.factory;

import org.coffee.*;

public enum CoffeeEnum
{
    AMERICANO("Americano",1,new Americano()),
    ESPRESSO("Espresso",2,new Espresso()),
    DOUBLE_ESPRESSO("Double Espresso" ,3, new DoubleEspresso()),
    CAFFEE_LATE("Caffee Late" ,4,new CaffeeLate()),
    CAPPUCINO("Cappucino",5, new Cappuccino()),
    MOCHA("Mocha",6,new Mocha()),
    DEFAULT("Yaratmak istediğiniz kahve türü ",7,new TemplateCoffee()),
    ;

    private final String name;
    private final int index;
    private final Coffee coffee;

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    CoffeeEnum(String name, int index , Coffee coffe) {
        this.name=name;
        this.index=index;
        this.coffee=coffe;
    }

}
