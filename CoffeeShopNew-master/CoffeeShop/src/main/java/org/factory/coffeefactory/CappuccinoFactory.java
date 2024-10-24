package org.factory.coffeefactory;

import org.coffee.Cappuccino;
import org.coffee.Coffee;

public class CappuccinoFactory implements CoffeeFactoryStrategy {
    @Override
    public Coffee createCoffee() {
        return new Cappuccino();
    }
}
