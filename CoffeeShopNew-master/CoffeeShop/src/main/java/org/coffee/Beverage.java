package org.coffee;

import org.ingredients.Ingredients;

public interface Beverage {
    int getPrice();

    void calculatePrice();

    String getName();

    String getContents(int price);

    void addIngredient(Ingredients ingredient, int doses);
}
