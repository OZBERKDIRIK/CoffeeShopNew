package org.factory.coffeefactory;

import org.coffee.CaffeeLate;
import org.coffee.NewBeverage;

public class CaffeeLateFactory implements CoffeeFactoryStrategy {
    @Override
    public NewBeverage createCoffee() {
        return new CaffeeLate();
    }
}
