package org.coffee;

import org.factory.ingredientfactory.IngredientType;
import org.ingredients.Espresso;
import org.ingredients.HotWater;


public class Americano extends NewBeverage {
    public Americano() {
        super("Americano",18);
        addIngredient(new Espresso() ,1);

        addIngredient(new HotWater(),4);

    }
}
