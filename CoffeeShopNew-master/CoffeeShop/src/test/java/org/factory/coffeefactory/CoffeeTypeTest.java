package org.factory.coffeefactory;

import org.app.Menu;
import org.coffee.Beverage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTypeTest {

    private Menu coffeeOrderManager;
    private  CoffeeFactory cfs;
    @BeforeEach
    private void setUp(){
        coffeeOrderManager=new Menu(new CoffeeFactory());
        cfs = new CoffeeFactory();
    }
    static Stream<Arguments> coffeeTypeProvider(){
        return  Stream.of(Arguments.of(1, CoffeeType.getCoffeeType(1)),
                Arguments.of(2, CoffeeType.getCoffeeType(2)),
                Arguments.of(3, CoffeeType.getCoffeeType(3)),
                Arguments.of(4, CoffeeType.getCoffeeType(4)),
                Arguments.of(5, CoffeeType.getCoffeeType(5)));
    }

    static Stream<Arguments> coffeeProvider(){
        CoffeeFactory cfs = new CoffeeFactory();
        return  Stream.of(Arguments.of(1, cfs.createBeverage(1)),
                Arguments.of(2, cfs.createBeverage(2)),
                Arguments.of(3, cfs.createBeverage(3)),
                Arguments.of(4, cfs.createBeverage(4)),
                Arguments.of(5, cfs.createBeverage(5)));
    }
    @ParameterizedTest
    @MethodSource("coffeeProvider")
    void getCoffee(int number , Beverage exceptedBeverage) {
        //When
           Beverage actualBeverage = cfs.createBeverage(number) ;

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