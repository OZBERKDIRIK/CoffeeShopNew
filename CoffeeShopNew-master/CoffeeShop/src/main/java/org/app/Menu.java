package org.app;

import org.coffee.Beverage;
import org.factory.coffeefactory.CoffeeType;
import org.factory.ingredientfactory.IngredientType;
import org.factory.coffeefactory.CoffeeFactory;
import org.ingredients.Ingredient;

import java.util.*;

public class Menu {

    private final CoffeeFactory coffeeFactory;
    private final List<IngredientType> coffeeIngredientsList;
    private final List<CoffeeType> coffeeList;
    public Menu(CoffeeFactory cfs){
        coffeeFactory = cfs;

        coffeeList = new ArrayList<>();
        addCoffeeToCoffeeList();

        coffeeIngredientsList = new ArrayList<>();
        addIngredientToCoffeeIngredientList();
    }

    public Beverage orderBeverage(int number) {
       return coffeeFactory.createBeverage(number);
    }

    public void printMenu() {
        StringBuilder coffeeListInfo = new StringBuilder();
        for(CoffeeType coffeeType :coffeeList){
            if(CoffeeType.CUSTOM_BEVERAGE==coffeeType){
                continue;
            }
            Beverage coffee= coffeeFactory.createBeverage(coffeeType.getIndex());
             coffeeListInfo.append(coffeeType.getIndex() )
                     .append(" Kahve: ")
                     .append(coffee.getName())
                     .append(" ----> " )
                     .append(" Fiyatı : ")
                     .append(coffee.getPrice())
                     .append("\n");
        }
        coffeeListInfo.append("Seçmek istediğiniz kahve türünün numarasını girin çıkmak için q'ya basın : ");
        System.out.println(coffeeListInfo.toString());
    }

    public void printIngredientMenu() {
        StringBuilder ingredientList = new StringBuilder();
        for (IngredientType ingredientEnum : coffeeIngredientsList) {
            Ingredient ingredient = ingredientEnum.getIngredient();
            ingredientList.append(ingredientEnum.getIndex())
                    .append(" --- ").
                    append(ingredient.getName())
                    .append(" --- Fiyatı : ")
                    .append(ingredient.getPrice())
                    .append("\n");

        }
        ingredientList.append("Kahvenize Koymak istediğiniz içerikleri seçin : \n")
                .append("Eklemeyi bitirmek istediğinizde q'ya basın : \n");
        System.out.println(ingredientList.toString());
    }

    public Ingredient getIngredient(int number) {
        Ingredient ingredient= IngredientType.getIngredient(number);
        return  ingredient;

    }


    private void addCoffeeToCoffeeList (){
        CoffeeType[] coffeeTypes = CoffeeType.values();
        Arrays.sort(coffeeTypes, Comparator.comparing(CoffeeType::getIndex));
        for(CoffeeType coffeeType :coffeeTypes){
            coffeeList.add(coffeeType);
        }
    }

    private void addIngredientToCoffeeIngredientList(){
        IngredientType[] ingredeintEnums = IngredientType.values();
        Arrays.sort(ingredeintEnums, Comparator.comparing(IngredientType::getIndex));
        for(IngredientType ingredeintEnum :ingredeintEnums){
            coffeeIngredientsList.add(ingredeintEnum);
        }
    }
}
