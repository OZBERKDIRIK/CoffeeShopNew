package org.app;

import org.coffee.Americano;
import org.coffee.CustomBeverage;
import org.coffee.NewBeverage;
import org.factory.coffeefactory.CoffeeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeLabApplicationTest {

    private CoffeeOrderManager coffeeOrderManager;
    private CoffeeFactory coffeeFactory;
    private CustomBeverage customNewBeverage;

    private Americano americano;
    @BeforeEach
   private void setUp(){
        coffeeFactory = new CoffeeFactory();
        coffeeOrderManager = new CoffeeOrderManager(coffeeFactory);
        customNewBeverage = new CustomBeverage("Sizin Kahveniz : ");

        americano = new Americano();
    }


    @Test
    void testAddIngredientCoffee(NewBeverage newBeverage){
        //
        


    }

    @Test
    void testFinalizeOrder(){

    }
}