package org.factory.coffeefactory;

import org.coffee.Beverage;

public enum CoffeeType {
    AMERICANO(1),
    CAFFEE_LATE(2) ,
    CAPPUCCINO(3) ,
    ESPRESSO(4) ,
    DOUBLE_ESPRESSO(5) ,
    MOCHA(6),
    CUSTOM_BEVERAGE(7);
    private final int index;

    CoffeeType (int index)
    {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static CoffeeType getCoffeeType(int index) {
        for(CoffeeType type : CoffeeType.values()) {
            if(type.index == index) {
                return type;
            }
        }
        throw new IllegalArgumentException("Geçerli bir index girin. ");
    }

}
