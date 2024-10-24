package org.factory.ingredientfactory;

import org.ingredients.CoffeeIngredients;
import org.ingredients.HotChocolate;

public class HotChocolateFactory implements IngredientFactoryStrategy {

    @Override
    public CoffeeIngredients createIngredient() {
        return new HotChocolate();
    }
}
