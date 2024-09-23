package org.app;

import org.coffee.*;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderOperation{
    List<Beverage> coffeelist;
    public CoffeeOrderOperation(){
        //Referans ile tutulmasına gerek yoktur
//        Americano americano = new Americano();
//        Espresso espresso = new Espresso();
//        DoubleEspresso doubleEspresso = new DoubleEspresso();
//        Cappuccino cappuccino = new Cappuccino();
//        Mocha mocha = new Mocha();
//        CaffeeLate caffeeLate = new CaffeeLate();

        coffeelist = new ArrayList<>();

        coffeelist.add(new Americano());
        coffeelist.add(new Espresso());
        coffeelist.add(new DoubleEspresso());
        coffeelist.add(new Cappuccino());
        coffeelist.add(new Mocha());
        coffeelist.add(new CaffeeLate());

    }

    //İndex kısmı enum ile düzenlenmeli
    public void listOfCoffee(){
        StringBuilder coffeList = new StringBuilder();
        int index = 1;
        for(Beverage coffee :coffeelist){
            coffeList.append(index  + " - " +coffee.getName() +  " --- Fiyat: " + coffee.getPrice() +"\n");
            index++;
        }
        System.out.println(coffeList);
    }

    /*
     Seçim Metodu Düzenlenmeli ......
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
     */
}
