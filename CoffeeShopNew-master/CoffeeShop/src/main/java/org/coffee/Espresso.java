package org.coffee;

public class Espresso extends Beverage {
    public Espresso() {
        super("Espresso" , 10 );
        addIngredient0( new org.ingredients.Espresso(), 1);
    }
}
