package org.factory.ingredientfactory;

import org.app.Menu;
import org.factory.coffeefactory.CoffeeFactory;
import org.ingredients.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {

    private Menu coffeeOrderManager;
    @BeforeEach
    private void setUp(){
        coffeeOrderManager=new Menu(new CoffeeFactory());
    }
    static Stream<Arguments> ingredientProvider(){
        return  Stream.of(Arguments.of(1, IngredientType.getIngredient(1)),
                Arguments.of(2, IngredientType.getIngredient(2)),
                Arguments.of(3, IngredientType.getIngredient(3)),
                Arguments.of(4, IngredientType.getIngredient(4)),
                Arguments.of(5, IngredientType.getIngredient(5)));
    }



    @ParameterizedTest
    @MethodSource("ingredientProvider")
    void testGetIngredient(int testNumber , Ingredient excpetedIngredient){
        //give
        //---> params initilaze
        //When
        Ingredient actualIngredient = coffeeOrderManager.getIngredient(testNumber);


        //Then
        assertEquals(excpetedIngredient,actualIngredient);
        assertThrows(IllegalArgumentException.class , ()-> IngredientType.getIngredient(10) );
    }
}