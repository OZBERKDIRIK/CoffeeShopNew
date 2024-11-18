package org.app;

import org.coffee.*;
import org.factory.coffeefactory.CoffeeFactory;
import org.factory.coffeefactory.CoffeeType;
import org.factory.ingredientfactory.IngredientType;
import org.ingredients.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MenuTest {
    private Menu menu;
    CoffeeFactory factory;
    @BeforeEach
    void setUp() {
        factory = new CoffeeFactory();
        menu = new Menu(factory);
    }

    static Stream<Arguments> orderProvider() {
        return Stream.of(Arguments.of(1,new CoffeeFactory().createBeverage(1)),
                Arguments.of(2,new CoffeeFactory().createBeverage(2)),
                Arguments.of(3, new CoffeeFactory().createBeverage(3)),
                Arguments.of(4, new CoffeeFactory().createBeverage(4)),
                Arguments.of(5, new CoffeeFactory().createBeverage(5)),
                Arguments.of(6, new CoffeeFactory().createBeverage(6)));
    }


    @MethodSource("orderProvider")
    @ParameterizedTest
    void orderBeverage(int testNumber, Beverage expectedBeverage) {
        //Give
            //listeyi vereceğinz -- indexi vereceğiz @Paramatrized kullanılabilir
            //Listeyi mockladığımız nesneden veririz

        //When
            //Verilen index numrasına göre kahveyi bulucaz
        Beverage actualBeverage =  menu.orderBeverage(testNumber);

        //Then
            //Beklenen --- Gelen assertEquals
        assertEquals(expectedBeverage, actualBeverage.getClass());
        assertThrows(IllegalArgumentException.class , ()-> menu.orderBeverage(15));
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
    void testGetIngredient(int number , Ingredient expectedIngredient){
            Ingredient actualIngredient = menu.getIngredient(number);
            assertEquals(expectedIngredient, actualIngredient, "İçerikler Eşleşmiyor");
    }
}