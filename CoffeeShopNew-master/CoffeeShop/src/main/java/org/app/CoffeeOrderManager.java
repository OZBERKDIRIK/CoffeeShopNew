package org.app;

import org.coffee.NewBeverage;
import org.factory.coffeefactory.CoffeeType;
import org.factory.ingredientfactory.IngredientType;
import org.factory.coffeefactory.CoffeeFactory;
import org.factory.coffeefactory.CoffeeFactoryStrategy;
import org.ingredients.Ingredient;

import java.util.*;

public class CoffeeOrderManager{

    CoffeeFactory coffeeFactory;
    List<IngredientType> coffeeIngredientsList;
    List<CoffeeType> coffeeList;
    public CoffeeOrderManager(CoffeeFactory cfs){
        coffeeFactory = cfs;

        coffeeList = new ArrayList<>();
        addCoffeeToCoffeeList();

        coffeeIngredientsList = new ArrayList<>();
        addIngredientToCoffeeIngredientList();
    }

    public NewBeverage orderBeverage(int number) {
        Map<CoffeeType , CoffeeFactoryStrategy> CoffeeMap  = coffeeFactory.getCoffeeList();
        CoffeeType coffeeType = CoffeeType.getCoffeeType(number);
        if(coffeeType == null) {
            throw new IllegalArgumentException("İlgili index numarasında bir kahve yoktur ");
        }
        return CoffeeMap.get(coffeeType).createCoffee();
    }

    public String toStringCoffeeList() {
        String coffeeListInfo="";
        for(CoffeeType coffeeType :coffeeList){
            NewBeverage coffee = coffeeType.getCoffee();
             coffeeListInfo=coffeeListInfo+" " + coffeeType.getIndex() + " Kahve: " + coffee.getName()+ " ----> " + " Fiyatı : " + coffee.getPrice() +"\n";
        }
        return coffeeListInfo;
    }

    public String toStringIngredientList()
    {
        String ingredientList="";
        for(IngredientType ingredientEnum :coffeeIngredientsList){
            Ingredient ingredient = ingredientEnum.getIngredient();
            ingredientList = ingredientList+ingredientEnum.getIndex() +" --- "+ingredient.getName()+" --- Fiyatı : "+ingredient.getPrice() +"\n";
        }
        return ingredientList;
    }

    public Ingredient getIngredient(int number) {
        Ingredient ingredient= IngredientType.getIngredient(number);
        return  ingredient;

    }


    public void addCoffeeToCoffeeList (){
        CoffeeType[] coffeeTypes = CoffeeType.values();
        Arrays.sort(coffeeTypes, Comparator.comparing(CoffeeType::getIndex));
        for(CoffeeType coffeeType :coffeeTypes){
            coffeeList.add(coffeeType);
        }
    }

    public void addIngredientToCoffeeIngredientList(){
        IngredientType[] ingredeintEnums = IngredientType.values();
        Arrays.sort(ingredeintEnums, Comparator.comparing(IngredientType::getIndex));
        for(IngredientType ingredeintEnum :ingredeintEnums){
            coffeeIngredientsList.add(ingredeintEnum);
        }
    }
}
