package org.coffee;

import org.ingredients.Ingredients;

import java.util.HashMap;
import java.util.Map;

public abstract class Coffee implements Beverage {

    private int price;
    private String name;
    protected Map<Ingredients, Integer> contetOfCoffee;


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
        calculatePrice();
    }



    //Fiyatı Geri Döndürüyor
    @Override
    public int getPrice() {
        return price;
    }

    //Fiyatı Hesaplıyor
    @Override
    public void calculatePrice() {
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


    @Override
    public String getContents(int price) {
        String content = name + " içerisinde ----> "+"\n";
       for(Map.Entry<Ingredients, Integer> map :contetOfCoffee.entrySet()){
           content = content + map.getValue() + " doz " + map.getKey().getName() + "\n";
       }
       content+="içermektedir." +"\n" + "Fiyatı : "+price;
       return content;
    }


}
