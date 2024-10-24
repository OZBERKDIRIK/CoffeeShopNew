package org.factory.coffeefactory;

import org.coffee.Americano;
import org.coffee.Coffee;

public class AmericanoFactory implements CoffeeFactoryStrategy {

    @Override
    public Coffee createCoffee() {
        return new Americano();
    }
}
