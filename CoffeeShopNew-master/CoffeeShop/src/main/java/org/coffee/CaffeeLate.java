package org.coffee;

import org.factory.ingredientfactory.IngredientType;
import org.ingredients.Espresso;
import org.ingredients.HotWater;

public class CaffeeLate extends NewBeverage{
    public CaffeeLate() {
        super("Caffee Late" , 18);
        addIngredient(new Espresso(),1);

        addIngredient(new HotWater() ,4);

    }
}
