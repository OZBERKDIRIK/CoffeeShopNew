package org.coffee;

import org.factory.ingredientfactory.IngredientType;
import org.ingredients.Espresso;
import org.ingredients.HotWater;
import org.ingredients.MilkFoam;
import org.ingredients.SteamedMilk;

public class Cappuccino extends NewBeverage{
    public Cappuccino() {
        super("Cappucino" , 32);
        addIngredient(new Espresso(),1);

        addIngredient(new SteamedMilk(),2);

        addIngredient(new MilkFoam() , 2);


    }
}
