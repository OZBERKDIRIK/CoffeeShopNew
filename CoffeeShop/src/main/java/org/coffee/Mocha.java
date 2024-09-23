package org.coffee;

import org.ingredients.*;
import org.ingredients.Espresso;

public class Mocha extends Coffee{
    public Mocha() {
        super("Mocha");
        Espresso espresso = new Espresso();
        addIngredient(espresso,1);

        SteamedMilk steamedMilk = new SteamedMilk();
        addIngredient(steamedMilk,1);

        MilkFoam milkFoam = new MilkFoam();
        addIngredient(milkFoam , 1);

        HotChocolate hotChocolate = new HotChocolate();
        addIngredient(hotChocolate,2);

    }
}
