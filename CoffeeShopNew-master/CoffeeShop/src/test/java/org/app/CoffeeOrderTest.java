package org.app;

import org.coffee.NewBeverage;
import org.factory.coffeefactory.AmericanoFactory;
import org.factory.coffeefactory.CoffeeFactoryService;
import org.factory.coffeefactory.CoffeeFactoryStrategy;
import org.factory.coffeefactory.CoffeeType;
import org.factory.ingredientfactory.IngredientType;
import org.ingredients.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoffeeOrderTest {

    private CoffeeOrderManager coffeeOrder;
    private static CoffeeFactoryService mockService;

    @BeforeEach
    public void setUp() {
        mockService = mock();
        coffeeOrder = new CoffeeOrderManager(mockService);
    }

    @Test
    public void testWriteBeverageList() {

        assertNotNull(coffeeOrder);
        assertFalse(coffeeOrder.coffeeList.isEmpty());
    }

    @Test
    public void testGetBeverageValidNumber() {
        HashMap coffeelist = new HashMap<CoffeeType, CoffeeFactoryStrategy>();
        coffeelist.put(CoffeeType.AMERICANO, new AmericanoFactory());
        when(mockService.getCoffeeList()).thenReturn(coffeelist);

        NewBeverage coffee = coffeeOrder.orderBeverage(1);
        verify(mockService, times(1)).getCoffeeList();
        assertNotNull(coffee);
        assertEquals(CoffeeType.AMERICANO.getCoffee().getName(), coffee.getName());
    }

    @Test
    public void testGetBeverageInvalidNumber() {
        try {
            NewBeverage coffee = coffeeOrder.orderBeverage(-1);
            assertNull(coffee);
        } catch (Exception e) {
            System.out.println("Geçersiz index numarası");
        }
    }

    @Test
    public void testWriteIngredientList() {

        assertNotNull(coffeeOrder);
        assertFalse(coffeeOrder.coffeeIngredientsList.isEmpty());
    }

    @Test
    public void testGetIngredientValidNumber() {

        Ingredient ingredient = coffeeOrder.getIngredient(1);
        assertNotNull(ingredient);
        assertEquals(IngredientType.ESPRESSO.getIngredient().getName(), ingredient.getName());
    }

    @Test
    public void testGetIngredientInvalidNumber() {
        try {
            Ingredient ingredient = coffeeOrder.getIngredient(-1);
            assertNull(ingredient);
        } catch (Exception e) {
            System.out.println("Geçersiz index numarası");
        }
    }

    @Test
    public void denemeTest() {
        NewBeverage beverage = coffeeOrder.orderBeverage(CoffeeType.CUSTOM_BEVERAGE.getIndex());

        beverage.addIngredient(IngredientType.HOT_CHOCOLATE.getIngredient(), 2);
        System.out.println(beverage);

        NewBeverage beverage2 = coffeeOrder.orderBeverage(CoffeeType.CUSTOM_BEVERAGE.getIndex());


        beverage2.addIngredient(IngredientType.ESPRESSO.getIngredient(), 2);
        System.out.println(beverage2);

        if (beverage2.equals(beverage)) {
            System.out.println("Aynı obje");
        } else {
            System.out.println("Farklı obje");
        }
    }


}
