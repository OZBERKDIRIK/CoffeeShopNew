package org.factory.ingredientfactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    void getIngredient(IngredientType testType) {
        assertEquals(IngredientType.getIngredient(testType.getIndex()), testType);
    }
}