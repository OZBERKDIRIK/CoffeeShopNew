package org.coffee;

import org.ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public  class NewBeverage {
    private float price; //base fiyat
    private String name;


    private Map<Ingredient, Integer> contetOfCoffee;

    protected NewBeverage(String name, float price) {
        this.price = price;
        this.name = name;
        contetOfCoffee=new HashMap<>();
    }

    protected NewBeverage()
    {

    }
    public Map<Ingredient, Integer> getContetOfCoffee() {
        return contetOfCoffee;
    }

    public void addIngredient(Ingredient ingredient , int doses){
        if (contetOfCoffee.containsKey(ingredient)) {
            int currentDoses = contetOfCoffee.get(ingredient);
            contetOfCoffee.put(ingredient, currentDoses + doses);
        } else {
            contetOfCoffee.put(ingredient, doses);
        }
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price>=0)
        {
            this.price=price;
        }else{
            throw new IllegalArgumentException("Fiyat negatif olamaz .... ");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 public void calculatePrice(){
        float sumOfCoffeePrice = 0f;
     for(Map.Entry<Ingredient, Integer> map :contetOfCoffee.entrySet()){
         float ingredientPrice = map.getKey().getPrice();
         int doses = map.getValue();

         sumOfCoffeePrice= sumOfCoffeePrice+ingredientPrice*doses + this.price;
     }
     this.price=sumOfCoffeePrice;
 }

    @Override
    public String toString(){
        String coffeeInfo = this.name + "içerisinde --> \n";
        for(Map.Entry<Ingredient, Integer> map :contetOfCoffee.entrySet()){
            Ingredient ingredient = map.getKey();
            int doses = map.getValue();
            coffeeInfo = coffeeInfo + doses + " doz " + ingredient.getName() + " ";
        }
        coffeeInfo = coffeeInfo + " bulunmaktadır \n" + "Fiyat : " + this.price ;

        return coffeeInfo;
    }

}
