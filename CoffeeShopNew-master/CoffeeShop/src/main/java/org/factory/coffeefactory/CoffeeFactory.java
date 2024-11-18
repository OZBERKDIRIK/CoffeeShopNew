package org.factory.coffeefactory;

import org.coffee.*;

import java.util.*;

public class CoffeeFactory {

    private final Map<CoffeeType, CoffeeFactoryStrategy> coffeeList = new HashMap<>();

    public CoffeeFactory() {
        registerCoffee(CoffeeType.ESPRESSO,() -> new Espresso() ) ;
        registerCoffee(CoffeeType.AMERICANO,() -> new Americano());
        registerCoffee(CoffeeType.CAFFEE_LATE,() -> new CaffeeLate());
        registerCoffee(CoffeeType.CAPPUCCINO,() -> new Cappuccino());
        registerCoffee(CoffeeType.DOUBLE_ESPRESSO, () -> new DoubleEspresso());
        registerCoffee(CoffeeType.MOCHA, () -> new Mocha());
        registerCoffee(CoffeeType.CUSTOM_BEVERAGE, () -> new CustomBeverage());
    }

    public Map<CoffeeType, CoffeeFactoryStrategy> getCoffeeList() {
        return coffeeList;
    }
    public void registerCoffee(CoffeeType coffeeType, CoffeeFactoryStrategy coffeeSupplier) {
        coffeeList.put(coffeeType , coffeeSupplier);
    }

}
