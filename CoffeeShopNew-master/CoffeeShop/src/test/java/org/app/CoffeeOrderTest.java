package org.app;

import org.coffee.Beverage;
import org.factory.CoffeeEnum;
import org.factory.IngredeintEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeOrderTest {

    private CoffeeOrder coffeeOrder;

    @BeforeEach
    public void setUp() {
        coffeeOrder = new CoffeeOrder();
    }

//    @Test
//    public void testWriteBeverageList() {
//
//        assertNotNull(coffeeOrder);
//        assertFalse(coffeeOrder.coffeelist.isEmpty());
//    }
//
//    @Test
//    public void testGetBeverageValidNumber() {
//
//        Beverage coffee = coffeeOrder.getBeverage(1);
//        assertNotNull(coffee);
//        assertEquals(CoffeeEnum.ESPRESSO.getCoffee().getName(), coffee.getName());
//    }
//
//    @Test
//    public void testGetBeverageInvalidNumber() {
//
//        Beverage coffee = coffeeOrder.getBeverage(-1);
//        assertNull(coffee);
//    }
//
//    @Test
//    public void testWriteIngredientList() {
//
//        assertNotNull(coffeeOrder);
//        assertFalse(coffeeOrder.ingredientsList.isEmpty());
//    }
//
//    @Test
//    public void testGetIngredientValidNumber() {
//
//        Ingredients ingredient = coffeeOrder.getIngredient(1);
//        assertNotNull(ingredient);
//        assertEquals(IngredeintEnum.ESPRESSO.getIngredients().getName(), ingredient.getName());
//    }
//
//    @Test
//    public void testGetIngredientInvalidNumber() {
//
//        Ingredients ingredient = coffeeOrder.getIngredient(-1);
//        assertNull(ingredient);
//    }

    @Test
    public void denemeTest() {
        Beverage beverage = coffeeOrder.getBeverage(CoffeeEnum.DEFAULT.getIndex());
        beverage.addIngredient(IngredeintEnum.HOT_CHOCOLATE.getIngredients(), 2);
        beverage.getContents(beverage.getPrice());

        Beverage beverage2 = coffeeOrder.getBeverage(CoffeeEnum.DEFAULT.getIndex());
        beverage2.addIngredient(IngredeintEnum.ESPRESSO.getIngredients(), 2);
        beverage2.addIngredient(IngredeintEnum.STEAMED_MILK.getIngredients(), 1);
        beverage2.getContents(beverage2.getPrice());

        Beverage beverage3 = coffeeOrder.getBeverage(CoffeeEnum.DEFAULT.getIndex(), IngredeintEnum.ESPRESSO.getIngredients());


    }


}
