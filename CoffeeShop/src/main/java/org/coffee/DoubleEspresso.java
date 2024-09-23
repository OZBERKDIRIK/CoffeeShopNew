package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.HotWater;

public class DoubleEspresso extends Coffee{
    public DoubleEspresso() {
        super("Double Espresoo");
        Espresso espresso = new Espresso();
        addIngredient(espresso,2);

    }
}
