package org.factory.ingredientfactory;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;


public class IngredientFactoryService {
    private  final Map<IngredeintEnum , IngredientFactoryStrategy> ingredientsMap;

    public IngredientFactoryService() {
        ingredientsMap=new EnumMap<>(IngredeintEnum.class);
        registerIngredient(IngredeintEnum.ESPRESSO , new EsperessoFactory());
        registerIngredient(IngredeintEnum.HOT_CHOCOLATE , new HotChocolateFactory());
        registerIngredient(IngredeintEnum.HOT_WATER , new HotWaterFactory());
        registerIngredient(IngredeintEnum.MILK_FOAM , new MilkFoamFactory());
        registerIngredient(IngredeintEnum.STEAMED_MILK , new SteamedMilkFactory());
    }


    public void registerIngredient(IngredeintEnum ingredeintEnum , IngredientFactoryStrategy ingredientStrategy)
    {
        ingredientsMap.put(ingredeintEnum,ingredientStrategy);
    }

    public IngredientFactoryStrategy getIngredientStrategy(IngredeintEnum ingredeintEnum) {
        IngredientFactoryStrategy ingredient = ingredientsMap.get(ingredeintEnum);

        if (Objects.isNull(ingredient))
            throw new IllegalArgumentException("Strategy bulunamadı");
        return ingredient;
    }

}
