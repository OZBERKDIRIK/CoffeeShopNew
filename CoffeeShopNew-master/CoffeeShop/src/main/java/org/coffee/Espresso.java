package org.coffee;

public class Espresso extends NewBeverage{
    public Espresso() {
        super("Espresso" , 10 );
        addIngredient( new org.ingredients.Espresso(), 1);
    }
}
