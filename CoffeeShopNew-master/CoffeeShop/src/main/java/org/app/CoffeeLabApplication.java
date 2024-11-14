package org.app;

import org.coffee.CustomBeverage;
import org.coffee.NewBeverage;
import org.ingredients.Ingredient;

import java.util.Scanner;

public class CoffeeLabApplication {
    private final Scanner scanner;
    private final CoffeeOrderManager coffeeOrder;

    public CoffeeLabApplication(Scanner scanner, CoffeeOrderManager coffeeOrder) {
        this.scanner = scanner;
        this.coffeeOrder = coffeeOrder;
    }
    public void run() {
        String selection;
        int selectionNumber;
        NewBeverage coffee;

        while (true) {
            String coffeeList = coffeeOrder.toStringCoffeeList();
            System.out.println(coffeeList);
            System.out.println("Seçmek istediğiniz kahve türünün numarasını girin çıkmak için q'ya basın : ");
            selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("q")) {
                break;
            }

            try {
                selectionNumber = Integer.parseInt(selection);
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz tuşa bastınız!");
                continue;
            }

            coffee = coffeeOrder.orderBeverage(selectionNumber);

            if (coffee instanceof CustomBeverage) {
                handleCustomCoffee(coffee, coffeeOrder, scanner);
                return;
            } else {
                handleRegularCoffee(coffee, coffeeOrder, scanner);
                return;
            }
        }
    }

    private static void handleCustomCoffee(NewBeverage coffee, CoffeeOrderManager coffeeOrder, Scanner scanner) {
        String ingredientList = coffeeOrder.toStringIngredientList();
        System.out.println(ingredientList);
        System.out.println("Kahvenize Koymak istediğiniz içerikleri seçin : ");
        addIngredientsToCoffee(coffee, coffeeOrder, scanner);
    }

    private static void handleRegularCoffee(NewBeverage coffee, CoffeeOrderManager coffeeOrder, Scanner scanner) {
        System.out.println("Seçmiş olduğunuz " + coffee.getName() + " içeceğe ekstra içerik koymak ister misiniz? (e/h)");
        String selection = scanner.nextLine();

        if (selection.equalsIgnoreCase("e")) {
            addIngredientsToCoffee(coffee, coffeeOrder, scanner);
        } else {
            finalizeOrder(coffee);
        }
    }

    private static void addIngredientsToCoffee(NewBeverage coffee, CoffeeOrderManager coffeeOrder, Scanner scanner) {
        while (true) {
            System.out.println("Eklemeyi bitirmek istediğinizde q'ya basın : ");
            String ingredientList= coffeeOrder.toStringIngredientList();
            System.out.println(ingredientList);
            System.out.println("Seçmek istediğiniz ek malzemenin listeden numarasını girin: ");
            String selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("q")) {
                finalizeOrder(coffee);
                return;
            }

            int selectionNumber = Integer.parseInt(selection);
            Ingredient ingredients = coffeeOrder.getIngredient(selectionNumber);

            System.out.println("Eklemek istediğiniz doz sayısını girin : ");
            int dose = scanner.nextInt();
            scanner.nextLine();
            coffee.addIngredient(ingredients, dose);
        }
    }

    private static void finalizeOrder(NewBeverage coffee) {
        coffee.calculatePrice();
        float price = coffee.getPrice();
        String contentsOfCoffee = coffee.toString();
        System.out.println(contentsOfCoffee);
        System.out.println("Afiyet Olsun .... ");
    }
}
