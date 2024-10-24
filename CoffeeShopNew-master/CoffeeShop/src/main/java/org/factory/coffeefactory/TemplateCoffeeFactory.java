package org.factory.coffeefactory;

import org.coffee.Coffee;
import org.coffee.TemplateCoffee;

public class TemplateCoffeeFactory implements CoffeeFactoryStrategy{

    @Override
    public Coffee createCoffee() {
        return new TemplateCoffee();
    }
}
