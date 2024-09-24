package org.app;

import org.coffee.*;
import org.factory.CoffeeEnum;
import org.factory.CoffeeFactory;
import org.factory.IngredeintEnum;
import org.factory.IngredientFactory;
import org.ingredients.Ingredients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoffeeOrder implements Order{
   List<Beverage> coffeelist;
   private CoffeeEnum[] coffeeEnums;

   List<Ingredients> ingredientsList;
   private IngredeintEnum[] ingredeintEnums;

    public CoffeeOrder() {
         coffeeEnums = CoffeeEnum.values();
         ingredeintEnums=IngredeintEnum.values();
        loadBeverage();
        loadIngredients();
    }

    @Override
    public void writeBeverageList() {
        int index = 1;
        for(Beverage coffee :coffeelist){
            System.out.println(index + " --- " + coffee.getName() + " ---- " + " Fiyatı : " +coffee.getPrice());
            index++;
        }
    }



    @Override
    public Beverage getBeverage(int number) {

      if(number>=1 && number<=coffeeEnums.length){
          Beverage coffee = CoffeeFactory.getBeverage(coffeeEnums[number-1]);
          return coffee;
      }else{
        return null;
      }
    }

    @Override
    public void writeIngredientList() {
        int index = 1;
        for(Ingredients ingredients :ingredientsList){
            System.out.println(index + " --- " + ingredients.getName() + " ---- " + " Fiyatı : " +ingredients.getPrice());
            index++;
        }
    }

    @Override
    public Ingredients getIngredient(int number) {
        if(number>=1 && number<=ingredeintEnums.length){
            Ingredients ingredient = IngredientFactory.getIngredient(ingredeintEnums[number-1]);
            return ingredient;
        }else{
            return null;
        }
    }

    public void loadBeverage(){
        coffeelist=new ArrayList<>();
        for (CoffeeEnum coffeeType : CoffeeEnum.values()) {
            coffeelist.add(coffeeType.getCoffee());
        }
    }

    public void loadIngredients(){
        ingredientsList=new ArrayList<>();
        for (IngredeintEnum ingredeintType : IngredeintEnum.values()) {
            ingredientsList.add(ingredeintType.getIngredients());
        }
    }

}
