package org.factory.ingredientfactory;

import org.ingredients.CoffeeIngredients;
import org.ingredients.HotWater;

public class HotWaterFactory implements IngredientFactoryStrategy {
    @Override
    public CoffeeIngredients createIngredient() {
        return new HotWater();
    }
}
