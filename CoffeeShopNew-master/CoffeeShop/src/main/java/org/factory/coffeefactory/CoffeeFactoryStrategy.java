package org.factory.coffeefactory;

import org.coffee.Beverage;

@FunctionalInterface
public interface CoffeeFactoryStrategy {
    Beverage createCoffee();
}
