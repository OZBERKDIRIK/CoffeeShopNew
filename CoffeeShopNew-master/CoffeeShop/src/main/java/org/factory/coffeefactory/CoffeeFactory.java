package org.factory.coffeefactory;

import org.coffee.*;

import java.util.*;
import java.util.function.Supplier;

public class CoffeeFactory {

    private final Map<CoffeeType, Supplier<Beverage>> coffeeCreatingMap = new HashMap<>();

    public CoffeeFactory() {
        registerCoffee(CoffeeType.ESPRESSO,() -> new Espresso() ) ;
        registerCoffee(CoffeeType.AMERICANO,() -> new Americano());
        registerCoffee(CoffeeType.CAFFEE_LATE,() -> new CaffeeLate());
        registerCoffee(CoffeeType.CAPPUCCINO,() -> new Cappuccino());
        registerCoffee(CoffeeType.DOUBLE_ESPRESSO, () -> new DoubleEspresso());
        registerCoffee(CoffeeType.MOCHA, () -> new Mocha());
    }
    public void registerCoffee(CoffeeType coffeeType, Supplier<Beverage> coffeeSupplier) {
        coffeeCreatingMap.put(coffeeType , coffeeSupplier);
    }

    public Beverage createBeverage(int number){
        CoffeeType coffeeType = CoffeeType.getCoffeeType(number);
        if(coffeeType == null) {
            throw new IllegalArgumentException("İlgili index numarasında bir kahve yoktur ");
        }
        return coffeeCreatingMap.get(coffeeType).get();
    }

    public Map<CoffeeType, Supplier<Beverage>> getCoffeeCreatingMap() {
        return coffeeCreatingMap;
    }
}
