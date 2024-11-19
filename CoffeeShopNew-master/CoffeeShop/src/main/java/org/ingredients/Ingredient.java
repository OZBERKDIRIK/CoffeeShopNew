package org.ingredients;

public class Ingredient {
    protected String name;
    protected float  price;

    protected Ingredient(String name, int price) {
        this.name= name;
        this.price= price;

    }
    public String getName(){
        return name;
    }
    public  float getPrice(){
        return price;
    }
    public void setPrice(int price){
        if(price >=0){
         this.price=price;
        }else{
            throw new IllegalArgumentException("Fiyat Negatif olamaz . ");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ingredient)) return false;
        Ingredient other = (Ingredient) obj;
        return this.getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
