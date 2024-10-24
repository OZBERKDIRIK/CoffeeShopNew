package org.factory.ingredientfactory;

import org.ingredients.CoffeeIngredients;
import org.ingredients.Ingredients;

public interface IngredientFactoryStrategy {
    Ingredients createIngredient();
}
