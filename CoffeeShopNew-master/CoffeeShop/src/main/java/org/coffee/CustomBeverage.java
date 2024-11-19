package org.coffee;

import org.ingredients.Ingredient;

import java.util.Map;

public class CustomBeverage extends Beverage {

    private Beverage baseBeverage;
    private Map<Ingredient , Integer > customBeverageIngredient;
    public CustomBeverage(Beverage baseBeverage) {
        super("Custom - " + baseBeverage.getName(), baseBeverage.getPrice());
        this.baseBeverage = baseBeverage;
        customBeverageIngredient = baseBeverage.getContetOfCoffee();
        for(Map.Entry<Ingredient , Integer> customBeverage : customBeverageIngredient.entrySet()){
            addIngredient0(customBeverage.getKey() , customBeverage.getValue());
        }
    }

    public void calculatePrice() {
        float sumOfCoffeePrice = 0f;
        for (Map.Entry<Ingredient, Integer> map : customBeverageIngredient.entrySet()) {
            float ingredientPrice = map.getKey().getPrice();
            int doses = map.getValue();
            sumOfCoffeePrice = sumOfCoffeePrice + ingredientPrice * doses + baseBeverage.getPrice();
        }
        super.setPrice(sumOfCoffeePrice);
    }


    public void addIngredient(Ingredient ingredients, int dose) {
        addIngredient0(ingredients,dose);
    }
}
