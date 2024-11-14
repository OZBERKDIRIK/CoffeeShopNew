package org.app;

import org.factory.coffeefactory.CoffeeFactory;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeFactory factoryService = new CoffeeFactory();
        CoffeeOrderManager orderManager = new CoffeeOrderManager(factoryService);
        CoffeeLabApplication coffeeApp = new CoffeeLabApplication(sc, orderManager);
        coffeeApp.run();
    }
}
