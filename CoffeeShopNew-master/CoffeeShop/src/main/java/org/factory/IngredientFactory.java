package org.factory;

import org.coffee.Beverage;
import org.coffee.Coffee;
import org.ingredients.*;

import java.util.HashMap;
import java.util.Map;

public class IngredientFactory {
    private final Map<IngredeintEnum, CoffeeIngredients> ingredientsMap;

    public IngredientFactory() {
        ingredientsMap=new HashMap<>();
        registerIngredient(IngredeintEnum.ESPRESSO, new Espresso());
        registerIngredient(IngredeintEnum.HOT_CHOCOLATE, new HotChocolate());
        registerIngredient(IngredeintEnum.HOT_WATER,new HotWater());
        registerIngredient(IngredeintEnum.MILK_FOAM,new MilkFoam());
        registerIngredient(IngredeintEnum.STEAMED_MILK,new SteamedMilk());
    }


    public void registerIngredient(IngredeintEnum ingredeintEnum , CoffeeIngredients ingredient){
        ingredientsMap.put(ingredeintEnum,ingredient);
    }

    public CoffeeIngredients createCoffeeIngredient(IngredeintEnum ingredeintEnum){
            for(Map.Entry<IngredeintEnum,CoffeeIngredients> map : ingredientsMap.entrySet()){
                if(map.getKey().getName().equals(ingredeintEnum.getName())){
                    return ingredientsMap.get(ingredeintEnum);
                }
            }
            return null;
    }


}
