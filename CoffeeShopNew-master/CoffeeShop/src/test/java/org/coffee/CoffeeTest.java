package org.coffee;


import org.ingredients.Espresso;
import org.ingredients.HotWater;
import org.ingredients.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoffeeTest {

    private NewBeverage coffee;
    private Ingredient espresso;
    private Ingredient hotWater;

    // Setup - Testlerin öncesinde çalışır
    @BeforeEach
    public void setUp() {
        coffee = new NewBeverage("Test Coffee", 100);

        espresso = new Espresso();

        hotWater = new HotWater();
    }

    // addIngredient metodunu test eder
    @Test
    public void testAddIngredient() {
        coffee.addIngredient(espresso, 2);
        coffee.addIngredient(hotWater, 1);

        // Espresso için güncelleme
        coffee.addIngredient(espresso, 3);

        assertEquals(52, coffee.getPrice());
    }

    // writeContents metodunu test eder
    @Test
    public void testWriteContents() {
        coffee.addIngredient(espresso, 1);
        coffee.addIngredient(hotWater, 2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        System.out.println(coffee);

        String expectedOutput = "Test Coffee içerisinde ---> 2 doz Hot Water içermektedir. 1 doz Espresso içermektedir. Toplam Fiyat : 14";

        assertEquals(expectedOutput, outContent.toString().trim());
    }
}

