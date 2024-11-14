package org.factory.coffeefactory;

import org.app.CoffeeOrderManager;
import org.coffee.NewBeverage;
import org.factory.ingredientfactory.IngredientType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTypeTest {

    private CoffeeOrderManager coffeeOrderManager;
    @BeforeEach
    private void setUp(){
        coffeeOrderManager=new CoffeeOrderManager(new CoffeeFactory());
    }
    static Stream<Arguments> coffeeTypeProvider(){
        return  Stream.of(Arguments.of(1, CoffeeType.getCoffeeType(1)),
                Arguments.of(2, CoffeeType.getCoffeeType(2)),
                Arguments.of(3, CoffeeType.getCoffeeType(3)),
                Arguments.of(4, CoffeeType.getCoffeeType(4)),
                Arguments.of(5, CoffeeType.getCoffeeType(5)));
    }

    static Stream<Arguments> coffeeProvider(){
        return  Stream.of(Arguments.of(1, CoffeeType.getCoffeeType(1).getCoffee()),
                Arguments.of(2, CoffeeType.getCoffeeType(2).getCoffee()),
                Arguments.of(3, CoffeeType.getCoffeeType(3).getCoffee()),
                Arguments.of(4, CoffeeType.getCoffeeType(4).getCoffee()),
                Arguments.of(5, CoffeeType.getCoffeeType(5).getCoffee()));
    }
    @ParameterizedTest
    @MethodSource("coffeeProvider")
    void getCoffee(int number , NewBeverage exceptedBeverage) {
        CoffeeType coffeeType = CoffeeType.getCoffeeType(number);

        //When
           NewBeverage actualBeverage = coffeeType.getCoffee();

        //Then
            assertEquals(exceptedBeverage, actualBeverage);
    }

    @ParameterizedTest
    @MethodSource("coffeeTypeProvider")
    void getCoffeeType(int number , CoffeeType exceptedCoffeeType) {
        //give

        //When
            CoffeeType actualCoffeeType  = CoffeeType.getCoffeeType(number);
        //Then
            assertEquals(exceptedCoffeeType, actualCoffeeType);
            assertThrows(IllegalArgumentException.class , ()-> CoffeeType.getCoffeeType(10) );
    }
}