package org.factory.coffeefactory;

import org.coffee.Coffee;
import org.coffee.DoubleEspresso;

public class DoubleEspressoFactory implements CoffeeFactoryStrategy{

    @Override
    public Coffee createCoffee() {
        return new DoubleEspresso();
    }
}
