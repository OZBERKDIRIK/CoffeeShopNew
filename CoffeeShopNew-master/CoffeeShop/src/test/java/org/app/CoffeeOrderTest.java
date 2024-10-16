package org.app;

import org.coffee.Beverage;
import org.factory.CoffeeEnum;
import org.factory.IngredeintEnum;
import org.factory.IngredientFactory;
import org.ingredients.Ingredients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderTest {

    private CoffeeOrderManager coffeeOrder;

    @BeforeEach
    public void setUp() {
        coffeeOrder = new CoffeeOrderManager();
    }

    @Test
    public void testWriteBeverageList() {

        assertNotNull(coffeeOrder);
        assertFalse(coffeeOrder.coffeeEnumList.isEmpty());
    }

    @Test
    public void testGetBeverageValidNumber() {

        Beverage coffee = coffeeOrder.orderBeverage(2);
        assertNotNull(coffee);
        assertEquals(CoffeeEnum.ESPRESSO.getName(), coffee.getName());
    }

    @Test
    public void testGetBeverageInvalidNumber() {

        Beverage coffee = coffeeOrder.orderBeverage(-1);
        assertNull(coffee);
    }

    @Test
    public void testWriteIngredientList() {

        assertNotNull(coffeeOrder);
        assertFalse(coffeeOrder.coffeeIngredientsEnumList.isEmpty());
    }

    @Test
    public void testGetIngredientValidNumber() {

        Ingredients ingredient = coffeeOrder.getIngredient(1);
        assertNotNull(ingredient);
        assertEquals(IngredeintEnum.ESPRESSO.getName(), ingredient.getName());
    }

    @Test
    public void testGetIngredientInvalidNumber() {

        Ingredients ingredient = coffeeOrder.getIngredient(-1);
        assertNull(ingredient);
    }

    @Test
    public void denemeTest() {
        Beverage beverage = coffeeOrder.orderBeverage(CoffeeEnum.DEFAULT.getIndex());
        IngredientFactory ingredientFactory = new IngredientFactory();
        beverage.addIngredient(ingredientFactory.createCoffeeIngredient(IngredeintEnum.HOT_CHOCOLATE), 2);
        beverage.getContents(beverage.getPrice());

        Beverage beverage2 = coffeeOrder.orderBeverage(CoffeeEnum.DEFAULT.getIndex());
        beverage2.addIngredient(ingredientFactory.createCoffeeIngredient(IngredeintEnum.ESPRESSO), 2);
        beverage2.addIngredient(ingredientFactory.createCoffeeIngredient(IngredeintEnum.STEAMED_MILK), 1);
        beverage2.getContents(beverage2.getPrice());

    }


}
