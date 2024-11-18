package org.coffee;


import org.ingredients.*;
import org.ingredients.Espresso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

public class CoffeeTest {

   //NewBeverage içerisindeki calculatePrice ve addIngredient metotları test edilemesi amaçlanmıştır

    private  CustomBeverage customBeverage;
    private Americano americano;
    @BeforeEach
    void setUp(){
        americano =new Americano();
        customBeverage = new CustomBeverage(americano);
        customBeverage.addIngredient0(new Espresso() , 5);
        customBeverage.addIngredient0(new MilkFoam(), 16);
        customBeverage.addIngredient0(new SteamedMilk(),18);
        customBeverage.addIngredient0(new HotWater() , 20);
    }

    @Test
    public void testGetName() {
        assertEquals("Americano", americano.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(18, americano.getPrice());
    }

    @Test
    public void testSetValidPrice() {
        americano.setPrice(10);
        assertEquals(10, americano.getPrice());
    }

    @Test
    public void testSetInvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> americano.setPrice(-1));
    }

    @Test
    void testCalculatePrice(){
       //Give
            float expectedPricePrice = 5*10 +16*4+ 18*7;
            System.out.println("Expected price : " + expectedPricePrice);

       //when
        customBeverage.calculatePrice();
         float actualPrice= customBeverage.getPrice();
        System.out.println("Actual Price : " + actualPrice);

       //Then
            assertEquals(expectedPricePrice,actualPrice,"Fiyat doğru hesaplanamamıştır");
   }

   @Test
    void testAddIngredient(){
        //Give
       Map<Ingredient ,Integer > contentOfBeverage = customBeverage.getContetOfCoffee();
       System.out.println(contentOfBeverage.toString());
       //When
       contentOfBeverage.put(new HotChocolate() , 19);
       Map<Ingredient , Integer > expectedContentOfBeverage = contentOfBeverage;
       System.out.println(expectedContentOfBeverage.toString());



       customBeverage.addIngredient0(new HotChocolate(), 19);
       Map<Ingredient , Integer> actualContentOfBeverage=customBeverage.getContetOfCoffee();
       //Then
       assertEquals(expectedContentOfBeverage , actualContentOfBeverage);
       System.out.println(actualContentOfBeverage.toString());

   }
}

