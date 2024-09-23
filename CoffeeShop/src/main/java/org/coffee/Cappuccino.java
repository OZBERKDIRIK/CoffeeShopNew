package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.HotWater;
import org.ingredients.MilkFoam;
import org.ingredients.SteamedMilk;

public class Cappuccino extends Coffee{
    public Cappuccino() {
        super("Cappucino");
        Espresso espresso = new Espresso();
        addIngredient(espresso,1);

        SteamedMilk steamedMilk = new SteamedMilk();
        addIngredient(steamedMilk,2);

        MilkFoam milkFoam = new MilkFoam();
        addIngredient(milkFoam,2);


    }
}
