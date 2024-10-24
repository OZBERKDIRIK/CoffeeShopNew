package org.factory.ingredientfactory;

import org.ingredients.CoffeeIngredients;
import org.ingredients.Espresso;

public class EsperessoFactory implements IngredientFactoryStrategy {

    @Override
    public CoffeeIngredients createIngredient() {
        return new Espresso();
    }
}
