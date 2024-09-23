package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.HotWater;

public class DoubleEspresso extends CoffeeBase{
    public DoubleEspresso() {
        super("Double Espresoo");
        Espresso espresso = new Espresso();
        addIngredient(espresso,2);

        calculatePrice();
    }
}
