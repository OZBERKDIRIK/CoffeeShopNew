package org.factory.coffeefactory;

import org.coffee.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeFactoryTest {
//    private  Map<CoffeeType, CoffeeFactoryStrategy> coffeeList;
    private CoffeeFactory coffeeFactory;
    @BeforeEach
    void setUp(){
        coffeeFactory  =new CoffeeFactory();
        Map<CoffeeType, Supplier<Beverage>>coffeeList = coffeeFactory.getCoffeeCreatingMap();
        coffeeList.put(CoffeeType.ESPRESSO, ()->new Espresso());
        coffeeList.put(CoffeeType.DOUBLE_ESPRESSO, ()->new DoubleEspresso());
        coffeeList.put(CoffeeType.MOCHA, ()->new Mocha());
        coffeeList.put(CoffeeType.CAPPUCCINO, ()->new Cappuccino());
        coffeeList.put(CoffeeType.CAFFEE_LATE, ()->new CaffeeLate());
    }

    @Test
    void testGetCoffeeList(){
        //Give
            Map<CoffeeType , Supplier<Beverage>> expectedCoffeeList = coffeeFactory.getCoffeeCreatingMap();

            //When
          expectedCoffeeList.put(CoffeeType.AMERICANO , ()->new Americano());
          Map<CoffeeType , Supplier<Beverage>>actualCoffeeList = coffeeFactory.getCoffeeCreatingMap();

        //Then

        assertEquals(expectedCoffeeList, actualCoffeeList);

    }



    @Test
    void testRegisterCoffeeList(){
        //Give
          Map<CoffeeType , Supplier<Beverage>> expectedCoffeeList = coffeeFactory.getCoffeeCreatingMap();
        System.out.println("Expected : " + expectedCoffeeList);

        //When
            coffeeFactory.registerCoffee(CoffeeType.AMERICANO , ()->new Americano());
            coffeeFactory.registerCoffee(CoffeeType.CAPPUCCINO , ()->new Cappuccino());
            Map<CoffeeType , Supplier<Beverage>> actualCoffeeList = coffeeFactory.getCoffeeCreatingMap();
            System.out.println("Actual : " +actualCoffeeList);
        //Then

        assertEquals(expectedCoffeeList, actualCoffeeList);

    }
}