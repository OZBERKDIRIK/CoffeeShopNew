package org.coffee;

import org.ingredients.*;
import org.ingredients.Espresso;

public class Mocha extends Beverage {
    public Mocha() {
        super("Mocha",41);
        addIngredient0(new Espresso(),1);

        addIngredient0(new SteamedMilk(),1);

        addIngredient0(new MilkFoam(), 1);

        addIngredient0(new HotChocolate(),2);

    }
}
