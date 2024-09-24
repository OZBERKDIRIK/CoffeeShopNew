package org.coffee;

import org.ingredients.Ingredients;

import java.util.HashMap;
import java.util.Map;

public abstract class Coffee implements Beverage {

    private int price;
    private String name;
    private Map<Ingredients, Integer> contetOfCoffee;


    protected Coffee() {
        contetOfCoffee=new HashMap<>();
        price=0;
    }

    protected Coffee(String name) {
        this();
        this.name = name;
    }

    //İçerik Eklemek için kullanıyor
    @Override
    public void addIngredient(Ingredients ingredient, int doses) {
        if (contetOfCoffee.containsKey(ingredient)) {
            int currentDoses = contetOfCoffee.get(ingredient);
            contetOfCoffee.put(ingredient, currentDoses + doses);
        } else {
            contetOfCoffee.put(ingredient, doses);
        }
        setPrice();
    }



    //Fiyatı Geri Döndürüyor
    @Override
    public int getPrice() {
        return price;
    }

    //Fiyatı Hesaplıyor
    @Override
    public void setPrice() {
        price =0;
        for(Ingredients ingredients : contetOfCoffee.keySet()){
            int ingredientPrice = ingredients.getPrice()*contetOfCoffee.get(ingredients);
            price+=ingredientPrice;
        }
    }

    //İsmini Getiriyor
    @Override
    public String getName() {
        return name;
    }


    //İçerikleri Yazdırıyor
    @Override
    public void writeContents(int price) {
        contetOfCoffee.forEach((key, value) -> {
            System.out.print(value + " doz " + key.getName() + " içermektedir. ");
        });
        System.out.println("Toplam Fiyat : " + price);
    }


}
