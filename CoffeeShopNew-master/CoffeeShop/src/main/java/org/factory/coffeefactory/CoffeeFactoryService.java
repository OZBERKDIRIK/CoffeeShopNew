package org.factory.coffeefactory;

import org.coffee.Americano;
import org.coffee.NewBeverage;

import java.util.*;

public class CoffeeFactoryService {

    private final Map<CoffeeType,CoffeeFactoryStrategy> coffeeList = new HashMap<>();

    public CoffeeFactoryService() {
        registerCoffee(CoffeeType.AMERICANO,new AmericanoFactory());
        registerCoffee(CoffeeType.ESPRESSO,new EspressoFactory() ) ;
        registerCoffee(CoffeeType.CAFFEE_LATE,new CaffeeLateFactory());
        registerCoffee(CoffeeType.CAPPUCCINO,new CappuccinoFactory());
        registerCoffee(CoffeeType.DOUBLE_ESPRESSO,new DoubleEspressoFactory());
        registerCoffee(CoffeeType.MOCHA,new MochaFactory());
        registerCoffee(CoffeeType.CUSTOM_BEVERAGE,new CustomCoffeeFactory());
    }

    public Map<CoffeeType, CoffeeFactoryStrategy> getCoffeeList() {
        return coffeeList;
    }
    public void registerCoffee(CoffeeType coffeeType, CoffeeFactoryStrategy coffeeReference) {
        coffeeList.put(coffeeType , coffeeReference);

    }

    public CoffeeFactoryStrategy getCoffeeStrategy(CoffeeType coffeeType) {
        CoffeeFactoryStrategy coffee = coffeeList.get(coffeeType);

        if (Objects.isNull(coffee))
            throw new IllegalArgumentException("Strategy bulunamadı");
        return coffee;
    }


}
