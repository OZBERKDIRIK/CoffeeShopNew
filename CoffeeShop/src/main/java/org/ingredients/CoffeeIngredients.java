package org.ingredients;

public class CoffeeIngredients implements Ingredients{

    private String name;

    private int price;


    public CoffeeIngredients (){
    }

    public CoffeeIngredients(String coffeeIngredientName , int coffeeIngredientPrice){
        this.name=coffeeIngredientName;
        this.price=coffeeIngredientPrice;
    }


    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getPrice()
    {
        return price;
    }

    @Override
    public void setPrice(int price) {
        if(price<0){
            System.out.println("Kahve Birim Fiyatı 0'dan düşük olamaz.");
        }else{
            this.price=price;
        }
    }
}
