package org.app;

import org.coffee.CustomBeverage;
import org.coffee.NewBeverage;
import org.ingredients.Ingredient;

import java.util.Scanner;

public class CoffeeLabApplication {
    private final Scanner scanner;
    private final CoffeeOrderManager coffeeOrder;

    private final CustomBeverage customBeverage;
    public CoffeeLabApplication(Scanner scanner, CoffeeOrderManager coffeeOrder,CustomBeverage customBeverage) {
        this.scanner = scanner;
        this.coffeeOrder = coffeeOrder;
        this.customBeverage=customBeverage;
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
            try {
                coffee = coffeeOrder.orderBeverage(selectionNumber);
            }catch (IllegalArgumentException e){
                System.out.println("Listeye uygun kahve numarası girin ");
                continue;
            }

            if (coffee instanceof CustomBeverage) {
                try {
                    handleCustomCoffee(customBeverage, coffeeOrder, scanner);
                    return;
                }catch (IllegalArgumentException e){
                    System.out.println("Uygun bir deger giriniz  ");
                    continue;
                }
            } else {
                try
                {
                    handleRegularCoffee(coffee);
                    return;
                }catch (IllegalArgumentException e){
                    System.out.println("Uygun bir deger giriniz : ");
                    continue;
                }


            }
        }
    }

    private static void handleCustomCoffee(CustomBeverage coffee, CoffeeOrderManager coffeeOrder, Scanner scanner) throws IllegalArgumentException{
        String ingredientList = coffeeOrder.toStringIngredientList();
        System.out.println(ingredientList);
        System.out.println("Kahvenize Koymak istediğiniz içerikleri seçin : ");
        addIngredientsToCoffee(coffee, coffeeOrder, scanner);
    }

    private static void handleRegularCoffee(NewBeverage coffee) throws IllegalArgumentException {
        System.out.println(coffee);
    }

    public static void addIngredientsToCoffee(CustomBeverage coffee, CoffeeOrderManager coffeeOrder, Scanner scanner) {
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
            int selectionNumber=0;
            try{
                selectionNumber = Integer.parseInt(selection);
                Ingredient ingredients = coffeeOrder.getIngredient(selectionNumber);
                System.out.println("Eklemek istediğiniz doz sayısını girin : ");
                int dose = scanner.nextInt();
                scanner.nextLine();
                coffee.addIngredient(ingredients, dose);
            }catch(NumberFormatException e){
                System.out.println("Listeden uygun içerik numarasını girin . ");
                continue;
            }
        }
    }

    private static void finalizeOrder(CustomBeverage coffee) {
        coffee.calculatePrice();
        String contentsOfCoffee = coffee.toString();
        System.out.println(contentsOfCoffee);
        System.out.println("Afiyet Olsun .... ");
    }
}
