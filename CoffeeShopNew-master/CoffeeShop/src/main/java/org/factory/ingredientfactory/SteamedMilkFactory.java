package org.factory.ingredientfactory;

import org.ingredients.CoffeeIngredients;
import org.ingredients.SteamedMilk;

public class SteamedMilkFactory implements IngredientFactoryStrategy {

    @Override
    public CoffeeIngredients createIngredient() {
        return new SteamedMilk();
    }
}
