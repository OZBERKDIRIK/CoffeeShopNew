package org.app;

import org.coffee.CustomBeverage;
import org.coffee.Beverage;
import org.ingredients.Ingredient;

import java.util.Scanner;

public class CoffeeLabApplication {
    private final Scanner scanner;
    private final Menu coffeeOrder;
   private  String selection;
    private int selectionNumber;
    private Beverage coffee;
    public CoffeeLabApplication(Scanner scanner, Menu coffeeOrder) {
        this.scanner = scanner;
        this.coffeeOrder = coffeeOrder;
        this.selection="";
        this.selectionNumber=0;
        Beverage coffee=null;
    }

    public void run() {


        while (true) {
            coffeeOrder.printMenu();
            selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("q")) {
                break;
            }
            try {
                selectionNumber = Integer.parseInt(selection);
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz tuşa bastınız!");
            }
            try {
                coffee = coffeeOrder.orderBeverage(selectionNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("Uygun bir deger giriniz! ");
                continue;
            }
            boolean userPreferenceAmountIngredient = isAddIngredient();
            if (userPreferenceAmountIngredient) {
                try {
                    handleCustomCoffee(coffee);
                    return;
                } catch (IllegalArgumentException exception) {
                    System.out.println("Uygun bir deger giriniz! ");
                }
            } else {
                try {
                    handleRegularCoffee(coffee);
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Uygun bir deger giriniz! ");
                }

            }
        }
    }

    private void handleCustomCoffee(Beverage coffee) {
        CustomBeverage customBeverage = new CustomBeverage(coffee);
        addIngredientsToCoffee(customBeverage);
    }

    private void handleRegularCoffee(Beverage coffee){
        System.out.println(coffee);
    }

    public void addIngredientsToCoffee(CustomBeverage coffee) {
        while (true) {
            coffeeOrder.printIngredientMenu();
            String selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("q")) {
                finalizeOrder(coffee);
                return;
            }
            try {
                selectionNumber = Integer.parseInt(selection);
                Ingredient ingredients = coffeeOrder.getIngredient(selectionNumber);
                int dose=0;
                System.out.println("Eklemek istediğiniz doz sayısını girin : ");
                try{
                    dose = scanner.nextInt();
                }catch (IllegalArgumentException e){
                    System.out.println("Uygun bir deger giriniz !!");
                }
                scanner.nextLine();
                coffee.addIngredient(ingredients, dose);
            } catch (NumberFormatException e) {
                System.out.println("Listeden uygun içerik numarasını girin . ");
            }
        }

    }

    private boolean isAddIngredient(){
        System.out.println("Seçtiğiniz Kahveye Ekstra İçerik Eklemek İster Misiniz ? (e/h)");
        String input = scanner.nextLine();
        try{
            if(input.equalsIgnoreCase("e")){
             return true;
            }
        }catch (IllegalArgumentException e){
            System.out.println("Uygun bir deger giriniz !!");
        }finally {
            return false;
        }

    }
    private void finalizeOrder(CustomBeverage coffee) {
        coffee.calculatePrice();
        System.out.println(coffee);
        System.out.println("Afiyet Olsun .... ");
    }
}
