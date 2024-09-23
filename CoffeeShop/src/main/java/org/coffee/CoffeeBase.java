package org.coffee;

import org.ingredients.CoffeeIngredients;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CoffeeBase implements BeverageBehaviour {
    private String coffeeName;

    private String description;

    public int getCoffeePrice() {
        return coffeePrice;
    }

    private int coffeePrice;

    private Map<CoffeeIngredients,Integer> contetOfCoffee;


    public CoffeeBase(){
        calculatePrice();
    }

    public CoffeeBase(String coffeeName)
    {
        this.coffeeName=coffeeName;
        this.contetOfCoffee=new HashMap<>();
    }

    public void calculatePrice() {
        Set<CoffeeIngredients>  ingredients= this.contetOfCoffee.keySet();
        this.coffeePrice=0;
        for(CoffeeIngredients ingredient :ingredients){
            int doses = this.contetOfCoffee.get(ingredient);
            int price = ingredient.getCoffeeIngredientPrice();
            this.coffeePrice+=price*doses;
        }

    }

    public void createDescription() {
        StringBuilder description = new StringBuilder();
        description.append(this.coffeeName);
        for (Map.Entry<CoffeeIngredients, Integer> entry : contetOfCoffee.entrySet()) {
            String ingredientName = entry.getKey().getCoffeeIngredientName();
            int doses = entry.getValue();
            description.append(" -- " + doses+ " " + ingredientName+ " içermektedir");
        }
        System.out.println(description + " Fiyatı : " +this.coffeePrice);
    }

    public void addIngredient(CoffeeIngredients ingredient, int doses){
        this.contetOfCoffee.put(ingredient,doses);
    }


    public String getCoffeeName() {
        return coffeeName;
    }

    public void mixedCoffee(CoffeeBase coffeeBase){
        Map<CoffeeIngredients ,Integer> coffeeIngredients = new HashMap<>();
        coffeeIngredients.putAll(coffeeBase.contetOfCoffee);
        String mixedCoffeeName = this.coffeeName + " - " + coffeeBase.coffeeName + " karıştırıldı ";
        System.out.println(mixedCoffeeName);
        for (Map.Entry<CoffeeIngredients, Integer> entry : coffeeIngredients.entrySet()) {
            System.out.println(entry.getValue() + " doz " +entry.getKey() + " içermektedir. ");
        }
    }
}
