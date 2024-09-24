package org.factory;

import org.coffee.Beverage;

public  class CoffeeFactory {
    public static Beverage getBeverage(CoffeeEnum coffeeEnum){
      CoffeeEnum [] coffeeEnums = CoffeeEnum.values();
      for(CoffeeEnum coffee :coffeeEnums){
          if(coffee.getName().equals(coffeeEnum.getName())){
              return coffee.getCoffee();
          }
      }
      return null;
    }
}
