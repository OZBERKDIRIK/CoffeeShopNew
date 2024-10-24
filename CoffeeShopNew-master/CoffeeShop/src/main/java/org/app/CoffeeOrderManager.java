package org.app;

import org.coffee.*;
import org.factory.coffeefactory.CoffeeEnum;
import org.factory.ingredientfactory.IngredeintEnum;
import org.factory.ingredientfactory.IngredientFactoryService;
import org.factory.coffeefactory.CoffeeFactoryService;
import org.factory.coffeefactory.CoffeeFactoryStrategy;
import org.factory.ingredientfactory.IngredientFactoryStrategy;
import org.ingredients.CoffeeIngredients;
import org.ingredients.Ingredients;

import java.util.*;

public class CoffeeOrderManager implements Order{

    CoffeeFactoryService coffeeFactory;
    IngredientFactoryService ingredientFactory;
    List<CoffeeEnum> coffeeEnumList;
    List<IngredeintEnum> coffeeIngredientsEnumList;

    public CoffeeOrderManager(){
        coffeeEnumList=new ArrayList<>();
        addCoffeeToCoffeeEnumList();


        coffeeIngredientsEnumList=new ArrayList<>();
        addIngredientToCoffeeIngredientList();

        coffeeFactory = new CoffeeFactoryService();
        ingredientFactory=new IngredientFactoryService();
    }

    @Override
    public String getBeverageList() {
        String coffeeList="";
        for(CoffeeEnum coffeeEnum :coffeeEnumList){

            coffeeList = coffeeList+coffeeEnum.getIndex() +" --- "+ coffeeEnum.getName()+"--- Fiyatı: "+coffeeEnum.getPrice() +"\n";
        }
        return coffeeList;
    }

    @Override
    public Beverage orderBeverage(int number) {
        for(CoffeeEnum coffeeEnum :coffeeEnumList){
            if(coffeeEnum.getIndex()==number){
                CoffeeFactoryStrategy coffeeStrategy = coffeeFactory.getCoffeeStrategy(coffeeEnum);
                Coffee coffee = coffeeStrategy.createCoffee();
                return coffee;
            }
        }
        return null;
    }

    @Override
    public String getIngredientList()
    {
        String ingredientList="";
        for(IngredeintEnum ingredientEnum :coffeeIngredientsEnumList){
            ingredientList = ingredientList+ingredientEnum.getIndex() +" --- "+ingredientEnum.getName()+" --- Fiyatı : "+ingredientEnum.getPrice() +"\n";
        }
        return ingredientList;
    }

    @Override
    public Ingredients getIngredient(int number) {
        for(IngredeintEnum ingredeintEnum : coffeeIngredientsEnumList){
            if(ingredeintEnum.getIndex()==number){
                IngredientFactoryStrategy ingredientStrategy = ingredientFactory.getIngredientStrategy(ingredeintEnum);
                Ingredients ingredients = ingredientStrategy.createIngredient();
                return ingredients;
            }
        }
        return null;
    }


    public void addCoffeeToCoffeeEnumList (){
        CoffeeEnum[] coffeeEnums = CoffeeEnum.values();
        Arrays.sort(coffeeEnums, Comparator.comparing(CoffeeEnum::getIndex));
        for(CoffeeEnum coffeeEnum :coffeeEnums){
            coffeeEnumList.add(coffeeEnum);
        }
    }

    public void addIngredientToCoffeeIngredientList(){
        IngredeintEnum[] ingredeintEnums = IngredeintEnum.values();
        Arrays.sort(ingredeintEnums, Comparator.comparing(IngredeintEnum::getIndex));
        for(IngredeintEnum ingredeintEnum :ingredeintEnums){
            coffeeIngredientsEnumList.add(ingredeintEnum);
        }
    }
}
