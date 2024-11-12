package org.factory.coffeefactory;

import org.coffee.NewBeverage;
import org.coffee.*;

public enum CoffeeType {
    AMERICANO(new Americano(), 1),
    CAFFEE_LATE(new CaffeeLate(), 2) ,
    CAPPUCCINO(new Cappuccino() , 3) ,
    ESPRESSO(new Espresso(), 5) ,
    DOUBLE_ESPRESSO(new DoubleEspresso(), 6) ,
    MOCHA(new Mocha(), 7) ,
    CUSTOM_BEVERAGE(new CustomBeverage("Olusturulan Kahve ") ,8);
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

}
