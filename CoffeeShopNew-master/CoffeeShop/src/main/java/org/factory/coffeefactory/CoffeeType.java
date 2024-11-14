package org.factory.coffeefactory;

import org.coffee.NewBeverage;
import org.coffee.*;

public enum CoffeeType {
    AMERICANO(new Americano(), 1),
    CAFFEE_LATE(new CaffeeLate(), 2) ,
    CAPPUCCINO(new Cappuccino() , 3) ,
    ESPRESSO(new Espresso(), 4) ,
    DOUBLE_ESPRESSO(new DoubleEspresso(), 5) ,
    MOCHA(new Mocha(), 6) ,
    CUSTOM_BEVERAGE(new CustomBeverage("Olusturulan Kahve ") ,7);
    private final int index;
    private final NewBeverage coffee;

    CoffeeType (NewBeverage coffee, int index)
    {
        this.coffee = coffee;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public NewBeverage getCoffee() {
        return coffee;
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
