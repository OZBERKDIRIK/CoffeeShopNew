package org.app;

import org.coffee.*;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderOperation{
    List<CoffeeBase> coffeelist;
    public CoffeeOrderOperation(){
        Americano americano = new Americano();
        Espresso espresso = new Espresso();
        DoubleEspresso doubleEspresso = new DoubleEspresso();
        Cappuccino cappuccino = new Cappuccino();
        Mocha mocha = new Mocha();
        CaffeeLate caffeeLate = new CaffeeLate();

        coffeelist = new ArrayList<>();

        coffeelist.add(americano);
        coffeelist.add(espresso);
        coffeelist.add(doubleEspresso);
        coffeelist.add(cappuccino);
        coffeelist.add(mocha);
        coffeelist.add(caffeeLate);

    }

    public void listOfCoffee(){
        StringBuilder coffeList = new StringBuilder();
        int index = 1;
        for(CoffeeBase coffeeBase :coffeelist){
            coffeList.append(index  + " - " +coffeeBase.getCoffeeName() +  " --- Fiyat: " + coffeeBase.getCoffeePrice() +"\n");
            index++;
        }
        System.out.println(coffeList);
    }

    public CoffeeBase selecetCoffee(int number){
        if(number==1){
            return new Americano();
        }else if(number==2){
            return new Espresso() ;
        }else if (number==3){
            return new DoubleEspresso();
        }else if (number==4){
            return new Cappuccino();
        }else if (number==5){
            return new Mocha();
        }else if (number==6){
            return new CaffeeLate();
        }else {
            System.out.println("Liste Dışında Bir Değer Girdiniz !! ");
            return null;
        }
    }
}
