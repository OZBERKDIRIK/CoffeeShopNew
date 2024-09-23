package org.coffee;

import org.ingredients.CoffeeIngredients;

import java.util.Map;

public abstract class Coffee implements Beverage {

    private int price;
    private String name ;
    private Map<CoffeeIngredients, Integer> contetOfCoffee;


    protected Coffee() {
        setPrice();
    }

    protected Coffee(String name) {
        this();
        this.name=name;
    }

    //İçerik Eklemel için kullanıyor
    public void addIngredient(CoffeeIngredients ingredient, int doses) {
        contetOfCoffee.put(ingredient, doses);
    }


    //Fiyatı Geri Döndürüyor
    @Override
    public int  getPrice() {
        return price;
    }

    //Fiyatı Hesaplıyor
    @Override
    public void setPrice(){
        int price = contetOfCoffee.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        this.price=price;
    }

    //İsmini Getiriyor
    @Override
    public String getName(){
        return name;
    }


    //İçerikleri Yazdırıyor
    @Override
    public void writeContents(int price){
        contetOfCoffee.forEach((key , value)->{
            System.out.print(value + " doz "+ key + " içermektedir. ");
        });
        System.out.println("Toplam Fiyatt : " +price);
    }


}
