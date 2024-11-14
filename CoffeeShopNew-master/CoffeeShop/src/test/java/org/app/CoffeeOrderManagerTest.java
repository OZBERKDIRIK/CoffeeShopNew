package org.app;

import org.factory.coffeefactory.CoffeeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class CoffeeOrderManagerTest {

    @BeforeEach
    void setUp() {
        CoffeeFactory cfs = new CoffeeFactory();
        CoffeeFactory mockFactory =  Mockito.mock(cfs);
        CoffeeOrderManager coffeeOrderManager = new CoffeeOrderManager(cfs);
    }

    private static Stream<Arguments> provideTestParameters() {
        return IntStream.range(0, 8).mapToObj(i -> convertCallback(i));
    }

    private static Arguments convertCallback(int i) {
        return Arguments.of(i);
    }

    @Test
    @ParameterizedTest
    @MethodSource("provideTestParameters")
    void orderBeverage(int testNumber) {
        //Give
            //listeyi vereceğinz -- indexi vereceğiz @Paramatrized kullanılabilir
            //Listeyi mockladığımız nesneden veririz

        //When
            //Verilen index numrasına göre kahveyi bulucaz

        //Then
            //Beklenen --- Gelen assertEquals
    }

    @Test
    void getIngredient() {
    }

    @Test
    void addCoffeeToCoffeeList() {
    }

    @Test
    void addIngredientToCoffeeIngredientList() {
    }
}