package org.app;

import org.coffee.*;
import org.factory.CoffeeEnum;
import org.factory.IngredeintEnum;
import org.factory.IngredientFactory;
import org.factory.coffeefactory.CoffeeFactoryService;
import org.factory.coffeefactory.CoffeeFactoryStrategy;
import org.ingredients.Ingredients;

import java.util.*;

public class CoffeeOrderManager implements Order{

    CoffeeFactoryService coffeeFactory;
    IngredientFactory ingredientFactory;
    List<CoffeeEnum> coffeeEnumList;
    List<IngredeintEnum> coffeeIngredientsEnumList;

    public CoffeeOrderManager(){
        coffeeEnumList=new ArrayList<>();
        addCoffeeToCoffeeEnumList();


        coffeeIngredientsEnumList=new ArrayList<>();
        addIngredientToCoffeeIngredientList();

        coffeeFactory = new CoffeeFactoryService();
        ingredientFactory=new IngredientFactory();
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
        Arrays.sort(coffeeEnums, Comparator.comparing(CoffeeEnum::getIndex));
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
