package org.coffee;

import org.ingredients.Ingredients;

public interface Beverage {
    int getPrice();

    void setPrice();

    String getName();

    void writeContents(int price);

    void addIngredient(Ingredients ingredient, int doses);
}
