package org.factory.coffeefactory;

import org.coffee.Mocha;
import org.coffee.NewBeverage;

public class MochaFactory implements CoffeeFactoryStrategy{

    @Override
    public NewBeverage createCoffee() {
        return new Mocha();
    }
}
