package org.app;

import org.coffee.*;
import org.factory.CoffeeEnum;
import org.factory.CoffeeFactory;
import org.factory.IngredeintEnum;
import org.factory.IngredientFactory;
import org.ingredients.CoffeeIngredients;
import org.ingredients.Ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CoffeeOrderManager implements Order{

    CoffeeFactory coffeeFactory;
    IngredientFactory ingredientFactory;
    List<CoffeeEnum> coffeeEnumList;
    List<IngredeintEnum> coffeeIngredientsEnumList;

    public CoffeeOrderManager(){
        coffeeEnumList=new ArrayList<>();
        addCoffeeToCoffeeEnumList();


        coffeeIngredientsEnumList=new ArrayList<>();
        addIngredientToCoffeeIngredientList();

        coffeeFactory = new CoffeeFactory();
        ingredientFactory=new IngredientFactory();
    }

    @Override
    public String getBeverageList() {
        String coffeeList="";
        for(CoffeeEnum coffeeEnum :coffeeEnumList){
            Beverage coffee = coffeeFactory.createCoffee(coffeeEnum);
            coffeeList = coffeeList+coffeeEnum.getIndex() +" --- "+ coffeeEnum.getName()+"--- Fiyatı: "+coffee.getPrice() +"\n";
        }
        return coffeeList;
    }

    @Override
    public Beverage orderBeverage(int number) {
        int index = number -1 ;
        CoffeeEnum coffeeEnum =  coffeeEnumList.get(index);
        Beverage coffee = coffeeFactory.createCoffee(coffeeEnum);
        return coffee;
    }

    @Override
    public String getIngredientList()
    {
        String ingredientList="";
        for(IngredeintEnum ingredientEnum :coffeeIngredientsEnumList){
            Ingredients ingredients =ingredientFactory.createCoffeeIngredient(ingredientEnum);
            ingredientList = ingredientList+ingredientEnum.getIndex() +" --- "+ingredientEnum.getName()+" --- Fiyatı : "+ingredients.getPrice() +"\n";
        }
        return ingredientList;
    }

    @Override
    public Ingredients getIngredient(int number) {
        int index = number -1 ;
        IngredeintEnum ingredientEnum =  coffeeIngredientsEnumList.get(index);
        Ingredients ingredient = ingredientFactory.createCoffeeIngredient(ingredientEnum);
        return ingredient;
    }


    public void addCoffeeToCoffeeEnumList (){
        CoffeeEnum[] coffeeEnums = CoffeeEnum.values();
        for(CoffeeEnum coffeeEnum :coffeeEnums){
            coffeeEnumList.add(coffeeEnum);
        }

    }

    public void addIngredientToCoffeeIngredientList(){
        IngredeintEnum[] ingredeintEnums = IngredeintEnum.values();
        for(IngredeintEnum ingredeintEnum :ingredeintEnums){
            coffeeIngredientsEnumList.add(ingredeintEnum);
        }
    }
}
