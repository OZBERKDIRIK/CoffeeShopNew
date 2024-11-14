package org.coffee;


import org.factory.ingredientfactory.IngredientType;
import org.ingredients.*;
import org.ingredients.Espresso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.stream.Stream;

public class CoffeeTest {

   //NewBeverage içerisindeki calculatePrice ve addIngredient metotları test edilemesi amaçlanmıştır

    private  CustomBeverage customBeverage;
    private Americano americano;
    @BeforeEach
    void setUp(){
        americano =new Americano();
        customBeverage=new CustomBeverage("Kahve : ");
        customBeverage.addIngredient(new Espresso() , 5);
        customBeverage.addIngredient(new MilkFoam(), 16);
        customBeverage.addIngredient(new SteamedMilk(),18);
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
            float expectedPricePrice = 5*10+ 16*4+ 18*7;
            System.out.println("Expected price : " + expectedPricePrice);

       //when
        customBeverage.calculatePrice();
         float actualPrice= customBeverage.getPrice();
        System.out.println("Actual Price : " + actualPrice);

       //Then
            assertEquals(expectedPricePrice,actualPrice);
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



       customBeverage.addIngredient(new HotChocolate(), 19);
       Map<Ingredient , Integer> actualContentOfBeverage=customBeverage.getContetOfCoffee();
       //Then
       assertEquals(expectedContentOfBeverage , actualContentOfBeverage);
       System.out.println(actualContentOfBeverage.toString());

   }
}

