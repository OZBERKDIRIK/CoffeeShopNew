package org.factory.coffeefactory;

import org.coffee.Cappuccino;
import org.coffee.NewBeverage;

public class CappuccinoFactory implements CoffeeFactoryStrategy {
    @Override
    public NewBeverage createCoffee() {
        return new Cappuccino();
    }
}
