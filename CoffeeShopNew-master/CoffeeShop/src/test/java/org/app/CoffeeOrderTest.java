package org.app;

import org.coffee.Beverage;
import org.factory.coffeefactory.CoffeeEnum;
import org.factory.ingredientfactory.IngredeintEnum;
import org.factory.ingredientfactory.IngredientFactoryService;
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
        try {
            Beverage coffee = coffeeOrder.orderBeverage(-1);
            assertNull(coffee);
        } catch (Exception e) {
            System.out.println("Geçersiz index numarası");
        }
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
        try {
            Ingredients ingredient = coffeeOrder.getIngredient(-1);
            assertNull(ingredient);
        } catch (Exception e) {
            System.out.println("Geçersiz index numarası");
        }
    }

    @Test
    public void denemeTest() {
        Beverage beverage = coffeeOrder.orderBeverage(CoffeeEnum.DEFAULT.getIndex());
        IngredientFactoryService ingredientFactory = new IngredientFactoryService();
        beverage.addIngredient(ingredientFactory.createCoffeeIngredient(IngredeintEnum.HOT_CHOCOLATE), 2);
        beverage.getContents(beverage.getPrice());

        Beverage beverage2 = coffeeOrder.orderBeverage(CoffeeEnum.DEFAULT.getIndex());
        beverage2.addIngredient(ingredientFactory.createCoffeeIngredient(IngredeintEnum.ESPRESSO), 2);
        beverage2.addIngredient(ingredientFactory.createCoffeeIngredient(IngredeintEnum.STEAMED_MILK), 1);
        beverage2.getContents(beverage2.getPrice());

        if (beverage2.equals(beverage)) {
            System.out.println("Aynı obje");
        } else {
            System.out.println("Farklı obje");
        }
    }


}
