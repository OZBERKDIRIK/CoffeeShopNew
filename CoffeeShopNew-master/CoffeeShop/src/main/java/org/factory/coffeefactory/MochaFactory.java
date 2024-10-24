package org.factory.coffeefactory;

import org.coffee.Coffee;
import org.coffee.Mocha;

public class MochaFactory implements CoffeeFactoryStrategy{

    @Override
    public Coffee createCoffee() {
        return new Mocha();
    }
}
