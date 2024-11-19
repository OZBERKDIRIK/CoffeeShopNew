package org.coffee;

import org.ingredients.Espresso;

public class DoubleEspresso extends Beverage {
    public DoubleEspresso() {
        super("Double Espresoo",20);
        addIngredient0(new Espresso(),2);

    }
}
