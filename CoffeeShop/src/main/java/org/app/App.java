package org.app;

import org.coffee.*;

import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        CoffeeOrderOperation operation = new CoffeeOrderOperation();
        Scanner scanner = new Scanner(System.in);

        while(true){
            operation.listOfCoffee();

            System.out.print("Lütfen Seçmek istediğiniz kahvenin numarasını girin: ('Çıkmak için q'ya basın')");
            String selection = scanner.nextLine();
            if(selection.equalsIgnoreCase("q")){
                break;
            }else{
                int selectionNumber= Integer.parseInt(selection);
                CoffeeBase coffee = operation.selecetCoffee(selectionNumber);
                System.out.println("Kahve eklemek istermisiniz ?? (e/h)");
                String coffeeAdd = scanner.nextLine();
                if(coffeeAdd.equalsIgnoreCase("e")){
                    while(true){
                        System.out.println("Eklemek istediğiniz kahveyi listeden seçin : ('Çıkmak için q'ya basın')");
                        String selectionForAddCoffee= scanner.nextLine();
                        operation.listOfCoffee();
                        if(selectionForAddCoffee.equalsIgnoreCase("q")){
                            coffee.createDescription();
                            return;
                        }else{
                            int numberOfCoffee = Integer.parseInt(selectionForAddCoffee);
                            CoffeeBase coffeeBase = operation.selecetCoffee(numberOfCoffee);
                            coffeeBase.mixedCoffee(coffeeBase);
                        }
                    }
                }

            }

        }
    }
}
