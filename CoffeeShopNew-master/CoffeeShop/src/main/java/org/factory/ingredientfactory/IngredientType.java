package org.factory.ingredientfactory;

import org.ingredients.*;

public enum IngredientType {
    ESPRESSO(new Espresso(), 1),
    HOT_CHOCOLATE(new HotChocolate(), 2) ,
    HOT_WATER(new HotWater(), 3) ,
    MILK_FOAM(new MilkFoam(), 4) ,
    STEAMED_MILK(new SteamedMilk(),5);
    private final int index;
    private final Ingredient ingredient;

    IngredientType(Ingredient ingredient, int index)
    {
        this.index = index;
        this.ingredient = ingredient;
    }

    public int getIndex() {
        return index;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public static Ingredient getIngredient(int index) {
        IngredientType[] values = IngredientType.values();
        for (IngredientType value : values) {
            if(index==value.index){
                return value.ingredient;
            }
        }
        throw new IllegalArgumentException("İndex numarası geçerli index numarasına karşılık düşmüyor");
    }
}
