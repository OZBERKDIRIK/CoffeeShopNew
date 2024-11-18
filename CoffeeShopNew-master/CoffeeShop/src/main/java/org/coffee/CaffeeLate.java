package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.HotWater;

public class CaffeeLate extends Beverage {
    public CaffeeLate() {
        super("Caffee Late" , 18);
        addIngredient0(new Espresso(),1);

        addIngredient0(new HotWater() ,4);

    }
}
