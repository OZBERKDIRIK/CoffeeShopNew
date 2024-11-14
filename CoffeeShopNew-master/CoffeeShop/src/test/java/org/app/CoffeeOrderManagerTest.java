package org.app;

import org.coffee.*;
import org.factory.coffeefactory.CoffeeFactory;
import org.factory.coffeefactory.CoffeeType;
import org.factory.ingredientfactory.IngredientType;
import org.ingredients.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeOrderManagerTest {
    private CoffeeOrderManager coffeeOrderManager;

    @BeforeEach
    void setUp() {
        CoffeeFactory factory = new CoffeeFactory();
        coffeeOrderManager = new CoffeeOrderManager(factory);
    }

    static Stream<Arguments> orderProvider() {
        return Stream.of(Arguments.of(1, CoffeeType.getCoffeeType(1).getCoffee()),
                Arguments.of(2, CoffeeType.getCoffeeType(2).getCoffee()),
                Arguments.of(3, CoffeeType.getCoffeeType(3).getCoffee()),
                Arguments.of(4, CoffeeType.getCoffeeType(4).getCoffee()),
                Arguments.of(5, CoffeeType.getCoffeeType(5).getCoffee()),
                Arguments.of(6, CoffeeType.getCoffeeType(6).getCoffee()),
                Arguments.of(7, CoffeeType.getCoffeeType(7).getCoffee()));
    }

    static Stream<Arguments> ingredientProvider(){
        return  Stream.of(Arguments.of(1, IngredientType.getIngredient(1)),
                Arguments.of(2, IngredientType.getIngredient(2)),
                Arguments.of(3, IngredientType.getIngredient(3)),
                Arguments.of(4, IngredientType.getIngredient(4)),
                Arguments.of(5, IngredientType.getIngredient(5)));
    }
    @MethodSource("orderProvider")
    @ParameterizedTest
    void orderBeverage(int testNumber, NewBeverage expectedBeverage) {
        //Give
            //listeyi vereceğinz -- indexi vereceğiz @Paramatrized kullanılabilir
            //Listeyi mockladığımız nesneden veririz

        //When
            //Verilen index numrasına göre kahveyi bulucaz
        NewBeverage actualBeverage =  coffeeOrderManager.orderBeverage(testNumber);

        //Then
            //Beklenen --- Gelen assertEquals
        assertEquals(expectedBeverage.getClass(), actualBeverage.getClass());
    }

    @ParameterizedTest
    @MethodSource("ingredientProvider")
    void getIngredient(int testNumber , Ingredient excpetedIngredient){
        //give
            //---> params initilaze
        //When

            Ingredient actualIngredient = coffeeOrderManager.getIngredient(testNumber);
        //Then
            assertEquals(excpetedIngredient,actualIngredient);

    }

    @Test
    void addCoffeeToCoffeeList(){
        //Give
            //coffeeType initlize
        List<CoffeeType> expectedCoffeeList = Arrays.asList(CoffeeType.values());
        expectedCoffeeList.sort(Comparator.comparing(CoffeeType::getIndex));
        //when
            //CoffeFactory yukarıda initilaze edildiği için constructorda addCoffeeToCoffeeList çağrıldı
            List<CoffeeType> actualCoffeeList = coffeeOrderManager.coffeeList;
        //Then
            assertEquals(expectedCoffeeList,actualCoffeeList);
    }
    @Test
    void addIngredientToCoffeeIngredientList(){
        //Give
            //ingredientType initlize
        List<IngredientType> expectedIngredientList = Arrays.asList(IngredientType.values());
        expectedIngredientList.sort(Comparator.comparing(i->i.getIndex()));

        //When
            //CoffeFactory yukarıda initilaze edildiği için constructorda addIngredientToCoffeeIngredientList çağrıldı
            List<IngredientType> actualIngredientList = coffeeOrderManager.coffeeIngredientsList;

        //Then
            assertEquals(expectedIngredientList,actualIngredientList);
    }
}