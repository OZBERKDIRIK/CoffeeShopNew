package org.factory.coffeefactory;

import org.coffee.*;
import org.factory.CoffeeEnum;

import java.util.*;

public  class CoffeeFactoryService {

    //Map içerisinde bir enum key value-object olsun
    //Bu mape eleman ekleme metodu olsun
    private final Map<CoffeeEnum, CoffeeFactoryStrategy> coffeeList = new EnumMap<>(CoffeeEnum.class);

    public CoffeeFactoryService() {
        registerCoffee(CoffeeEnum.AMERICANO,new AmericanoFactory());
        registerCoffee(CoffeeEnum.ESPRESSO , new EspressoFactory() ) ;
        registerCoffee(CoffeeEnum.CAFFEE_LATE , new CaffeeLateFactory());
        registerCoffee(CoffeeEnum.CAPPUCINO , new CappuccinoFactory());
        registerCoffee(CoffeeEnum.DOUBLE_ESPRESSO , new DoubleEspressoFactory());
        registerCoffee(CoffeeEnum.MOCHA , new MochaFactory());
        registerCoffee(CoffeeEnum.DEFAULT,new TemplateCoffeeFactory());
    }

    public void registerCoffee(CoffeeEnum coffeeEnum,CoffeeFactoryStrategy coffeeReference) {
        coffeeList.put(coffeeEnum , coffeeReference);

    }

    public CoffeeFactoryStrategy getCoffeeStrategy(CoffeeEnum coffeeEnum) {
        CoffeeFactoryStrategy coffee = coffeeList.get(coffeeEnum);

        if (Objects.isNull(coffee))
            throw new IllegalArgumentException("Strategy bulunamadı");
        return coffee;
    }
}
