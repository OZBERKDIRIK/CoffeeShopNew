package org.ingredients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeIngredientsTest {

    private Ingredient coffeeIngredient;

    @BeforeEach
    public void setUp() {
        coffeeIngredient=new Ingredient("Espresso", 5);
    }

    @Test
    public void testGetName() {
        assertEquals("Espresso", coffeeIngredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(5, coffeeIngredient.getPrice());
    }

    @Test
    public void testSetValidPrice() {
        coffeeIngredient.setPrice(10);
        assertEquals(10, coffeeIngredient.getPrice());
    }

    @Test
    public void testSetInvalidPrice() {
        assertThrows(IllegalArgumentException.class, ()->coffeeIngredient.setPrice(-5));
    }

    @Test
    public void testEqualsSameObject() {
        Ingredient sameIngredient = new Ingredient("Espresso", 5);
        assertTrue(coffeeIngredient.equals(sameIngredient));
    }

    @Test
    public void testEqualsDifferentName() {
        Ingredient differentIngredient = new Ingredient("Latte", 5);
        assertFalse(coffeeIngredient.equals(differentIngredient));
    }

    @Test
    public void testHashCodeSameName() {
        Ingredient sameIngredient = new Ingredient("Espresso", 10);
        assertEquals(coffeeIngredient.hashCode(), sameIngredient.hashCode());
    }

    @Test
    public void testHashCodeDifferentName() {
        Ingredient differentIngredient = new Ingredient("Latte", 10);
        assertNotEquals(coffeeIngredient.hashCode(), differentIngredient.hashCode());
    }
}
