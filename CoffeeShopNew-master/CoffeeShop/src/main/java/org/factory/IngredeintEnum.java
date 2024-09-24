package org.factory;
import org.ingredients.*;

public enum IngredeintEnum {
    ESPRESSO("Espresso", new Espresso()),
    HOT_CHOCOLATE("Sıcak Çikolata",new HotChocolate()),
    HOT_WATER("Sıcak Su",new HotWater()),
    MILK_FOAM("Süt Köpüğü" , new MilkFoam()),
    STEAMED_MILK("Sıcak Süt" , new SteamedMilk());


    private final String  name ;
    private final CoffeeIngredients ingredients;

    IngredeintEnum(String name, CoffeeIngredients ingredients){
        this.name=name;
        this.ingredients=ingredients;
    }

    public CoffeeIngredients getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
