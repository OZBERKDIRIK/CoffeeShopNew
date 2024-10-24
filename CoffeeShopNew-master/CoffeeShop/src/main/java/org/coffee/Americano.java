package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.HotWater;


public class Americano extends Coffee {
    public Americano() {
        super("Americano");
        Espresso espresso = new Espresso();
        addIngredient(espresso,1);

        HotWater hotWater = new HotWater();
        addIngredient(hotWater,4);

    }
}
