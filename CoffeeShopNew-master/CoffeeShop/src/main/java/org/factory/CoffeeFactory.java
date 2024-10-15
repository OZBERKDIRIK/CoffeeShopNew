package org.factory;

import org.coffee.*;

import java.util.HashMap;
import java.util.Map;

public  class CoffeeFactory {

    //Map içerisinde bir enum key value-object olsun
    //Bu mape eleman ekleme metodu olsun
    //Bu map üzerinden
    private final Map<CoffeeEnum, Coffee > coffeeMap = new HashMap<>();

    public CoffeeFactory() {
        registerCoffee(CoffeeEnum.AMERICANO, new Americano());
        registerCoffee(CoffeeEnum.ESPRESSO, new Espresso());
        registerCoffee(CoffeeEnum.CAFFEE_LATE, new CaffeeLate());
        registerCoffee(CoffeeEnum.CAPPUCINO, new Cappuccino());
        registerCoffee(CoffeeEnum.DOUBLE_ESPRESSO, new DoubleEspresso());
        registerCoffee(CoffeeEnum.MOCHA, new Mocha());
        registerCoffee(CoffeeEnum.DEFAULT, new TemplateCoffee());
    }

    public void registerCoffee(CoffeeEnum coffeeEnum, Coffee coffeeType) {
        coffeeMap.put(coffeeEnum,coffeeType);

    }

    public Coffee createCoffee(CoffeeEnum coffeeEnum){
        for(Map.Entry<CoffeeEnum,Coffee> map : coffeeMap.entrySet()){
            if(map.getKey().getName().equals(coffeeEnum.getName())){
                return coffeeMap.get(coffeeEnum);
            }
        }
        return null;
    }
}
