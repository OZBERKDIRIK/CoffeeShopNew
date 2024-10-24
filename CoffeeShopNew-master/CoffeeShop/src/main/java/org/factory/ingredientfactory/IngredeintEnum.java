package org.factory.ingredientfactory;
import org.ingredients.*;

public enum IngredeintEnum {
    ESPRESSO("Espresso" ,1,10),
    HOT_CHOCOLATE("Sıcak Çikolata",2,10) ,
    HOT_WATER("Sıcak Su",3,2) ,
    MILK_FOAM("Süt Köpüğü",4,4) ,
    STEAMED_MILK("Sıcak Süt",5,7);
    private final String  name ;
    private final int index;

    private final int price;
    IngredeintEnum(String name ,int index , int price)
    {
        this.name=name;
        this.index=index;
        this.price=price;
    }
    public String getName()
    {
        return name;
    }

    public int getIndex(){
        return index;
    }

    public int getPrice(){
        return price;
    }
}
