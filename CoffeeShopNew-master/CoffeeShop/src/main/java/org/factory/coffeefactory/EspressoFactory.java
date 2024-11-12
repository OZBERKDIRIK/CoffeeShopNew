package org.factory.coffeefactory;

import org.coffee.Espresso;
import org.coffee.NewBeverage;

public class EspressoFactory implements CoffeeFactoryStrategy {
    @Override
    public NewBeverage createCoffee() {
        return new Espresso();
    }
}
