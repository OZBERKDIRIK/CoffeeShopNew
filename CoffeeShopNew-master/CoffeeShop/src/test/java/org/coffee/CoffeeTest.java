package org.coffee;


import org.ingredients.CoffeeIngredients;
import org.ingredients.Ingredients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoffeeTest {

    private Coffee coffee;
    private Ingredients espresso;
    private Ingredients hotWater;

    // Setup - Testlerin öncesinde çalışır
    @BeforeEach
    public void setUp() {
        coffee = new Coffee("Test Coffee") {
        };

        espresso = new CoffeeIngredients() {
            @Override
            public String getName() {
                return "Espresso";
            }

            @Override
            public int getPrice() {
                return 10;
            }
        };

        hotWater = new CoffeeIngredients() {
            @Override
            public String getName() {
                return "Hot Water";
            }

            @Override
            public int getPrice() {
                return 2;
            }
        };
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

        coffee.writeContents(coffee.getPrice());

        String expectedOutput = "Test Coffee içerisinde ---> 2 doz Hot Water içermektedir. 1 doz Espresso içermektedir. Toplam Fiyat : 14";

        assertEquals(expectedOutput, outContent.toString().trim());
    }
}

