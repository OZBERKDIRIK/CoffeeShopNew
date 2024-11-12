package org.factory.coffeefactory;

import org.coffee.DoubleEspresso;
import org.coffee.NewBeverage;

public class DoubleEspressoFactory implements CoffeeFactoryStrategy{

    @Override
    public NewBeverage createCoffee() {
        return new DoubleEspresso();
    }
}
