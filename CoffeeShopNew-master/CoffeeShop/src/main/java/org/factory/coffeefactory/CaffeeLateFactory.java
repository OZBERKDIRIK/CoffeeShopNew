package org.factory.coffeefactory;

import org.coffee.CaffeeLate;
import org.coffee.Coffee;

public class CaffeeLateFactory implements CoffeeFactoryStrategy {
    @Override
    public Coffee createCoffee() {
        return new CaffeeLate();
    }
}
