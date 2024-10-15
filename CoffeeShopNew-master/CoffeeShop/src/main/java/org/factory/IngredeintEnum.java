package org.factory;
import org.ingredients.*;

public enum IngredeintEnum {
    ESPRESSO("Espresso" ,1),
    HOT_CHOCOLATE("Sıcak Çikolata",2),
    HOT_WATER("Sıcak Su",3),
    MILK_FOAM("Süt Köpüğü",4),
    STEAMED_MILK("Sıcak Süt",5);


    private final String  name ;
    private final int index;
    IngredeintEnum(String name ,int index )
    {
        this.name=name;
        this.index=index;

    }
    public String getName()
    {
        return name;
    }

    public int getIndex(){
        return index;
    }
}
