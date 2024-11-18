package org.factory.coffeefactory;

import org.coffee.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeFactoryTest {
//    private  Map<CoffeeType, CoffeeFactoryStrategy> coffeeList;
    private CoffeeFactory coffeeFactory;
    @BeforeEach
    void setUp(){
        coffeeFactory  =new CoffeeFactory();
        Map<CoffeeType,CoffeeFactoryStrategy>coffeeList = coffeeFactory.getCoffeeList();
        coffeeList.put(CoffeeType.ESPRESSO, ()->new Espresso());
        coffeeList.put(CoffeeType.DOUBLE_ESPRESSO, ()->new DoubleEspresso());
        coffeeList.put(CoffeeType.MOCHA, ()->new Mocha());
        coffeeList.put(CoffeeType.CAPPUCCINO, ()->new Cappuccino());
        coffeeList.put(CoffeeType.CAFFEE_LATE, ()->new CaffeeLate());
    }

    @Test
    void testGetCoffeeList(){
        //Give
            Map<CoffeeType , CoffeeFactoryStrategy> expectedCoffeeList = coffeeFactory.getCoffeeList();

            //When
          expectedCoffeeList.put(CoffeeType.CUSTOM_BEVERAGE , ()->new CustomBeverage());
          Map<CoffeeType , CoffeeFactoryStrategy > actualCoffeeList = coffeeFactory.getCoffeeList();

        //Then

        assertEquals(expectedCoffeeList, actualCoffeeList);

    }



    @Test
    void testRegisterCoffeeList(){
        //Give
          Map<CoffeeType , CoffeeFactoryStrategy> expectedCoffeeList = coffeeFactory.getCoffeeList();
        System.out.println("Expected : " + expectedCoffeeList);

        //When
            coffeeFactory.registerCoffee(CoffeeType.AMERICANO , ()->new Americano());
            coffeeFactory.registerCoffee(CoffeeType.CAPPUCCINO , ()->new Cappuccino());
            Map<CoffeeType , CoffeeFactoryStrategy> actualCoffeeList = coffeeFactory.getCoffeeList();
            System.out.println("Actual : " +actualCoffeeList);
        //Then

        assertEquals(expectedCoffeeList, actualCoffeeList);

    }
}