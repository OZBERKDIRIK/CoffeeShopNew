package org.factory.ingredientfactory;

import org.factory.coffeefactory.CoffeeEnum;
import org.factory.coffeefactory.CoffeeFactoryStrategy;
import org.ingredients.*;


import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;


public class IngredientFactoryService {
    private  final Map<IngredeintEnum , IngredientStrategy> ingredientsMap;

    public IngredientFactoryService() {
        ingredientsMap=new EnumMap<>(IngredeintEnum.class);
        registerIngredient(IngredeintEnum.ESPRESSO , new EsperessoFactory());
        registerIngredient(IngredeintEnum.HOT_CHOCOLATE , new HotChocolateFactory());
        registerIngredient(IngredeintEnum.HOT_WATER , new HotWaterFactory());
        registerIngredient(IngredeintEnum.MILK_FOAM , new MilkFoamFactory());
        registerIngredient(IngredeintEnum.STEAMED_MILK , new SteamedMilkFactory());
    }


    public void registerIngredient(IngredeintEnum ingredeintEnum , IngredientStrategy ingredientStrategy)
    {
        ingredientsMap.put(ingredeintEnum,ingredientStrategy);
    }

    public IngredientStrategy getCoffeeStrategy(IngredeintEnum ingredeintEnum) {
        IngredientStrategy ingredient = ingredientsMap.get(ingredeintEnum);

        if (Objects.isNull(ingredient))
            throw new IllegalArgumentException("Strategy bulunamadı");
        return ingredient;
    }

}
