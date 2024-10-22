package org.factory;
import org.ingredients.*;

public enum IngredeintEnum {
    ESPRESSO("Espresso" ,1) {
        @Override
        CoffeeIngredients getNewInstance() {
            return new Espresso();
        }
    },
    HOT_CHOCOLATE("Sıcak Çikolata",2) {
        @Override
        CoffeeIngredients getNewInstance() {
            return new HotChocolate();
        }
    },
    HOT_WATER("Sıcak Su",3) {
        @Override
        CoffeeIngredients getNewInstance() {
            return new HotWater();
        }
    },
    MILK_FOAM("Süt Köpüğü",4) {
        @Override
        CoffeeIngredients getNewInstance() {
            return new MilkFoam();
        }
    },
    STEAMED_MILK("Sıcak Süt",5) {
        @Override
        CoffeeIngredients getNewInstance() {
            return new SteamedMilk();
        }
    };
    private final String  name ;
    private final int index;
    IngredeintEnum(String name ,int index )
    {
        this.name=name;
        this.index=index;
    }
    abstract CoffeeIngredients getNewInstance();
    public String getName()
    {
        return name;
    }

    public int getIndex(){
        return index;
    }
}
