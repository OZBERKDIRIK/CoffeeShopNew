package org.app;

import org.coffee.*;
import org.factory.coffeefactory.CoffeeFactoryService;
import org.ingredients.Ingredient;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeFactoryService factoryService = new CoffeeFactoryService();
        CoffeeOrderManager orderManager = new CoffeeOrderManager(factoryService);
        CoffeeLabApplication coffeeApp = new CoffeeLabApplication(sc, factoryService, orderManager);
        coffeeApp.run();
    }
}
