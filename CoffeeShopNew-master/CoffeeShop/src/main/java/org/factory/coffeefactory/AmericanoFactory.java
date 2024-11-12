package org.factory.coffeefactory;

import org.coffee.Americano;
import org.coffee.NewBeverage;

public class AmericanoFactory implements CoffeeFactoryStrategy {

    @Override
    public NewBeverage createCoffee() {
        return new Americano();
    }
}
