package org.coffee;

import org.factory.ingredientfactory.IngredientType;
import org.ingredients.Espresso;
import org.ingredients.HotWater;

public class DoubleEspresso extends NewBeverage{
    public DoubleEspresso() {
        super("Double Espresoo",20);
        addIngredient(new Espresso(),2);

    }
}
