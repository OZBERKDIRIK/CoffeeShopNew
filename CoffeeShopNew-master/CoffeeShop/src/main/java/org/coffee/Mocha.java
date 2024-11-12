package org.coffee;

import org.factory.ingredientfactory.IngredientType;
import org.ingredients.*;
import org.ingredients.Espresso;

public class Mocha extends NewBeverage{
    public Mocha() {
        super("Mocha",41);
        addIngredient(new Espresso(),1);

        addIngredient(new SteamedMilk(),1);

        addIngredient(new MilkFoam(), 1);

        addIngredient(new HotChocolate(),2);

    }
}
