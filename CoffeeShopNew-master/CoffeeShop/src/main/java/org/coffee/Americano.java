package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.HotWater;


public class Americano extends Beverage {
    public Americano() {
        super("Americano",18);
        addIngredient0(new Espresso() ,1);

        addIngredient0(new HotWater(),4);

    }
}
