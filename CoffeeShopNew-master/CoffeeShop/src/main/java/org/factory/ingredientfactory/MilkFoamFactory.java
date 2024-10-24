package org.factory.ingredientfactory;

import org.ingredients.CoffeeIngredients;
import org.ingredients.MilkFoam;

public class MilkFoamFactory implements IngredientFactoryStrategy {
    @Override
    public CoffeeIngredients createIngredient() {
        return new MilkFoam();
    }
}
