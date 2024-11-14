package org.factory.coffeefactory;

import org.coffee.NewBeverage;

@FunctionalInterface
public interface CoffeeFactoryStrategy {
    NewBeverage createCoffee();
}
