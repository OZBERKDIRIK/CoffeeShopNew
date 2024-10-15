package org.app;

import org.coffee.Beverage;
import org.ingredients.Ingredients;

import java.util.Set;


public interface Order {
    String getBeverageList();

    Beverage orderBeverage(int number);

    String getIngredientList();
    Ingredients getIngredient(int number);
}
