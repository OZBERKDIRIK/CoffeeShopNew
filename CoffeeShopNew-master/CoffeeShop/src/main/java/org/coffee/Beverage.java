package org.coffee;

import org.ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class Beverage {
    private float price; //base fiyat
    private String name;


    private Map<Ingredient, Integer> contetOfCoffee;

    protected Beverage(String name, float price) {
        this.price = price;
        this.name = name;
        contetOfCoffee=new HashMap<>();
    }

    public Map<Ingredient, Integer> getContetOfCoffee() {
        return contetOfCoffee;
    }

    protected void addIngredient0(Ingredient ingredient , int doses){
        if (contetOfCoffee.containsKey(ingredient)) {
            int currentDoses = contetOfCoffee.get(ingredient);
            contetOfCoffee.put(ingredient, currentDoses + doses);
        } else {
            contetOfCoffee.put(ingredient, doses);
        }
    }

    public String getName() {
        return name;
    }

    public float getPrice(){
        return  price;
    }

    public void setPrice(float price){
        if(price <0){
            throw new IllegalArgumentException("Uygun bir fiyat degeri biriniz.");
        }else{
            this.price=price;
        }
    }

    @Override
    public String toString(){
        String coffeeInfo = this.name + " içerisinde --> \n";
        for(Map.Entry<Ingredient, Integer> map :contetOfCoffee.entrySet()){
            Ingredient ingredient = map.getKey();
            int doses = map.getValue();
            coffeeInfo = coffeeInfo + doses + " doz " + ingredient.getName() + " ";
        }
        coffeeInfo = coffeeInfo + " bulunmaktadır \n" + "Fiyat : " + this.price ;

        return coffeeInfo;
    }
}
