package org.app;

import org.coffee.*;
import org.ingredients.Ingredients;

import java.sql.SQLOutput;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        Ingredients ingredients;
        Beverage coffee;

        Scanner scanner = new Scanner(System.in);
        String selection = "";
        int selectionNumber = 0;
        int price = 0;

        while (true) {
            coffeeOrder.writeBeverageList();
            System.out.println("Seçmek istediğiniz kahve türünün numarasını girin çıkmak için q'ya basın : ");
            selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("q")) {
                break;
            } else {
                selectionNumber = Integer.parseInt(selection);
                coffee = coffeeOrder.getBeverage(selectionNumber);
                if (coffee instanceof TemplateCoffee) {
                    coffeeOrder.writeIngredientList();
                    System.out.println("Kahvenize Koymak istediğiniz içerikleri seçin : ");
                    while (true) {
                        System.out.println("Eklemeyi bitirmek istediğinizde q'ya basın : ");
                        coffeeOrder.writeIngredientList();
                        selection = scanner.nextLine();
                        if (selection.equalsIgnoreCase("q")) {
                            coffee.setPrice();
                            price = coffee.getPrice();
                            coffee.writeContents(price);
                            System.out.println("Afiyet Olsun .... ");
                            return;
                        } else {
                            selectionNumber = Integer.parseInt(selection);
                            ingredients = coffeeOrder.getIngredient(selectionNumber);
                            System.out.println("Eklemek istediğiniz doz sayısını girin : ");
                            int dose = scanner.nextInt();
                            scanner.nextLine();
                            coffee.addIngredient(ingredients, dose);
                        }
                    }
                        } else {

                            System.out.println("Seçmiş olduğunuz " + coffee.getName() + " içeceğe ekstra içerik koymak ister misiniz ? (e/h");
                            selection = scanner.nextLine();
                            if (selection.equalsIgnoreCase("e")) {
                                while (true) {
                                    System.out.println("Eklemeyi bitirmek istediğinizde q'ya basın : ");
                                    coffeeOrder.writeIngredientList();
                                    selection = scanner.nextLine();
                                    if (selection.equalsIgnoreCase("q")) {
                                        coffee.setPrice();
                                        price = coffee.getPrice();
                                        coffee.writeContents(price);
                                        System.out.println("Afiyet Olsun .... ");
                                        return;
                                    } else {
                                        selectionNumber = Integer.parseInt(selection);
                                        ingredients = coffeeOrder.getIngredient(selectionNumber);
                                        System.out.println("Eklemek istediğiniz doz sayısını girin : ");
                                        int dose = scanner.nextInt();
                                        scanner.nextLine();
                                        coffee.addIngredient(ingredients, dose);
                                    }
                                }
                            } else {
                                coffee.setPrice();
                                price = coffee.getPrice();
                                coffee.writeContents(price);
                                System.out.println("Afiyet Olsun .... ");
                                return;
                            }
                        }
                    }
                }
            }
        }
