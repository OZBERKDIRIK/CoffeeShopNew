package org.factory;

import org.coffee.Beverage;
import org.ingredients.Ingredients;

public class IngredientFactory {
    public static Ingredients getIngredient(IngredeintEnum ingredeintEnum){
        IngredeintEnum [] ingredeintEnums = IngredeintEnum.values();
        for(IngredeintEnum ingredeint :ingredeintEnums){
            if(ingredeint.getName().equals(ingredeintEnum.getName())){
                return ingredeint.getIngredients();
            }
        }
        return null;
    }
}
