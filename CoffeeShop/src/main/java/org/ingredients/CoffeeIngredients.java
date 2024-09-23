package org.ingredients;

public class CoffeeIngredients {

    private String coffeeIngredientName;

    private int coffeeIngredientPrice;


    public CoffeeIngredients (){
    }

    public CoffeeIngredients(String coffeeIngredientName , int coffeeIngredientPrice){
        this.coffeeIngredientName=coffeeIngredientName;
        this.coffeeIngredientPrice=coffeeIngredientPrice;
    }

    public String getCoffeeIngredientName() {
        return coffeeIngredientName;
    }

    public void setCoffeeIngredientName(String coffeeIngredientName) {
        this.coffeeIngredientName = coffeeIngredientName;
    }

    public int getCoffeeIngredientPrice() {
        return coffeeIngredientPrice;
    }

    public void setCoffeeIngredientPrice(int coffeeIngredientPrice) {
        if(coffeeIngredientPrice<0){
            System.out.println("Fiyat Negatif Olamaz");
        }else{
        this.coffeeIngredientPrice = coffeeIngredientPrice;
        }
    }
}
