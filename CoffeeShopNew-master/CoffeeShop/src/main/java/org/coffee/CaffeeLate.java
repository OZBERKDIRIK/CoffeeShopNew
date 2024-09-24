package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.HotWater;

public class CaffeeLate extends Coffee{
    public CaffeeLate() {
        super("Caffee Late");
        Espresso espresso = new Espresso();
        addIngredient(espresso,1);

        HotWater hotWater = new HotWater();
        addIngredient(hotWater,4);

    }
}
