package org.factory;

import org.ingredients.*;


import java.util.ArrayList;
import java.util.List;


public class IngredientFactory {
    private final List<IngredeintEnum> ingredientsMap;

    public IngredientFactory() {
        ingredientsMap=new ArrayList<>();
        registerIngredient(IngredeintEnum.ESPRESSO);
        registerIngredient(IngredeintEnum.HOT_CHOCOLATE);
        registerIngredient(IngredeintEnum.HOT_WATER);
        registerIngredient(IngredeintEnum.MILK_FOAM);
        registerIngredient(IngredeintEnum.STEAMED_MILK);
    }


    public void registerIngredient(IngredeintEnum ingredeintEnum){
        ingredientsMap.add(ingredeintEnum);
    }

    public CoffeeIngredients createCoffeeIngredient(IngredeintEnum ingredeintEnum){
            for(IngredeintEnum ingredeintEnumValue : ingredientsMap){
                if(ingredeintEnumValue.getName().equals(ingredeintEnum.getName())){
                    return ingredeintEnumValue.getNewInstance();
                }
            }
            return null;
    }


}
