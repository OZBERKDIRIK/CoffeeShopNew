package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.Ingredient;

import java.util.Map;

public class CustomBeverage extends  NewBeverage {

    private float price;

    public CustomBeverage()
    {
        super("Custom Kahve : ",0);
        addIngredient(new Espresso(),1);
    }



    public void calculatePrice(){
        float sumOfCoffeePrice = 0f;
        for(Map.Entry<Ingredient, Integer> map :getContetOfCoffee().entrySet()){
            float ingredientPrice = map.getKey().getPrice();
            int doses = map.getValue();
            sumOfCoffeePrice= sumOfCoffeePrice+ingredientPrice*doses + this.price;
        }
        super.setPrice(sumOfCoffeePrice);
    }

}
