package org.app;

import org.coffee.*;
import org.ingredients.Ingredients;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeOrderManager coffeeOrder = new CoffeeOrderManager();
        String selection;
        int selectionNumber;
        Beverage coffee;

        while (true) {
            String beverageList = coffeeOrder.getBeverageList();
            System.out.println(beverageList);
            System.out.println("Seçmek istediğiniz kahve türünün numarasını girin çıkmak için q'ya basın : ");
            selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("q")) {
                break;
            }

            selectionNumber = Integer.parseInt(selection);
            coffee = coffeeOrder.orderBeverage(selectionNumber);

            if (coffee instanceof TemplateCoffee) {
                handleTemplateCoffee(coffee, coffeeOrder, scanner);
                return;
            } else {
                handleRegularCoffee(coffee, coffeeOrder, scanner);
                return;
            }
        }
    }

    private static void handleTemplateCoffee(Beverage coffee, CoffeeOrderManager coffeeOrder, Scanner scanner) {
        String ingredientList = coffeeOrder.getIngredientList();
        System.out.println(ingredientList);
        System.out.println("Kahvenize Koymak istediğiniz içerikleri seçin : ");
        addIngredientsToCoffee(coffee, coffeeOrder, scanner);
    }

    private static void handleRegularCoffee(Beverage coffee, CoffeeOrderManager coffeeOrder, Scanner scanner) {
        System.out.println("Seçmiş olduğunuz " + coffee.getName() + " içeceğe ekstra içerik koymak ister misiniz? (e/h)");
        String selection = scanner.nextLine();

        if (selection.equalsIgnoreCase("e")) {
            addIngredientsToCoffee(coffee, coffeeOrder, scanner);
        } else {
            finalizeOrder(coffee);
        }
    }

    private static void addIngredientsToCoffee(Beverage coffee, CoffeeOrderManager coffeeOrder, Scanner scanner) {
        while (true) {
            System.out.println("Eklemeyi bitirmek istediğinizde q'ya basın : ");
            String ingredientList= coffeeOrder.getIngredientList();
            System.out.println(ingredientList);
            String selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("q")) {
                finalizeOrder(coffee);
                return;
            }

            int selectionNumber = Integer.parseInt(selection);
            Ingredients ingredients = coffeeOrder.getIngredient(selectionNumber);

            System.out.println("Eklemek istediğiniz doz sayısını girin : ");
            int dose = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            coffee.addIngredient(ingredients, dose);
        }
    }

    private static void finalizeOrder(Beverage coffee) {
        coffee.calculatePrice();
        int price = coffee.getPrice();
        coffee.getContents(price);
        System.out.println("Afiyet Olsun .... ");
    }

        }
