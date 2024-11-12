package org.factory.coffeefactory;

import org.coffee.CustomBeverage;
import org.coffee.NewBeverage;

public class CustomCoffeeFactory implements CoffeeFactoryStrategy{

    @Override
    public NewBeverage createCoffee() {
        return new CustomBeverage("Sizin Kahveniz: ");

    }
}
