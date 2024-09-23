package org.coffee;

import org.ingredients.HotWater;

public class Espresso extends CoffeeBase{
    public Espresso() {
        super("Espresso");
        org.ingredients.Espresso espresso = new org.ingredients.Espresso();
        addIngredient(espresso,1);

        calculatePrice();
    }
}
