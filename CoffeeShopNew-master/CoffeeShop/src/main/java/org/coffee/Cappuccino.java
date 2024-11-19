package org.coffee;

import org.ingredients.Espresso;
import org.ingredients.MilkFoam;
import org.ingredients.SteamedMilk;

public class Cappuccino extends Beverage {
    public Cappuccino() {
        super("Cappucino" , 32);
        addIngredient0(new Espresso(),1);

        addIngredient0(new SteamedMilk(),2);

        addIngredient0(new MilkFoam() , 2);


    }
}
