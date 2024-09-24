package org.app;

import org.coffee.Beverage;
import org.ingredients.Ingredients;

import java.util.Set;


public interface Order {
    void writeBeverageList();

    Beverage getBeverage(int number);

    void writeIngredientList();
    Ingredients getIngredient(int number);

    void loadBeverage();
    void loadIngredients();


}
