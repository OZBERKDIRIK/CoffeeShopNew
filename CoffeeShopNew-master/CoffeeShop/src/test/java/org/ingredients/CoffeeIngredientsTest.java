package org.ingredients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeIngredientsTest {

    private CoffeeIngredients coffeeIngredient;

    @BeforeEach
    public void setUp() {
        coffeeIngredient = new CoffeeIngredients("Espresso", 5);
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
        coffeeIngredient.setPrice(-5);
        assertEquals(5, coffeeIngredient.getPrice());
    }

    @Test
    public void testEqualsSameObject() {
        CoffeeIngredients sameIngredient = new CoffeeIngredients("Espresso", 5);
        assertTrue(coffeeIngredient.equals(sameIngredient));
    }

    @Test
    public void testEqualsDifferentName() {
        CoffeeIngredients differentIngredient = new CoffeeIngredients("Latte", 5);
        assertFalse(coffeeIngredient.equals(differentIngredient));
    }

    @Test
    public void testHashCodeSameName() {
        CoffeeIngredients sameIngredient = new CoffeeIngredients("Espresso", 10);
        assertEquals(coffeeIngredient.hashCode(), sameIngredient.hashCode());
    }

    @Test
    public void testHashCodeDifferentName() {
        CoffeeIngredients differentIngredient = new CoffeeIngredients("Latte", 10);
        assertNotEquals(coffeeIngredient.hashCode(), differentIngredient.hashCode());
    }
}
