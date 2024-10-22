package org.factory;

import org.coffee.*;

import java.util.ArrayList;
import java.util.List;

public  class CoffeeFactory {

    //Map içerisinde bir enum key value-object olsun
    //Bu mape eleman ekleme metodu olsun
    //Bu map üzerinden
    private final List<CoffeeEnum > coffeeList = new ArrayList<>();

    public CoffeeFactory() {
        registerCoffee(CoffeeEnum.AMERICANO);
        registerCoffee(CoffeeEnum.ESPRESSO);
        registerCoffee(CoffeeEnum.CAFFEE_LATE);
        registerCoffee(CoffeeEnum.CAPPUCINO);
        registerCoffee(CoffeeEnum.DOUBLE_ESPRESSO);
        registerCoffee(CoffeeEnum.MOCHA);
        registerCoffee(CoffeeEnum.DEFAULT);
    }

    public void registerCoffee(CoffeeEnum coffeeEnum) {
        coffeeList.add(coffeeEnum);

    }

    public Coffee createCoffee(CoffeeEnum coffeeEnum){
        for(CoffeeEnum coffeeEnumValue : coffeeList){
            if(coffeeEnumValue.getName().equals(coffeeEnum.getName())){
                return coffeeEnumValue.getNewInstance();
            }
        }
        return null;
    }
}
