package org.factory;

import org.coffee.*;

public enum CoffeeEnum
{
    AMERICANO("Americano",1) {
        @Override
        Coffee getNewInstance() {
            return new Americano();
        }
    },
    ESPRESSO("Espresso",2) {
        @Override
        Coffee getNewInstance() {
            return new Espresso();
        }
    },
    DOUBLE_ESPRESSO("Double Espresso" ,3) {
        @Override
        Coffee getNewInstance() {
            return new DoubleEspresso();
        }
    },
    CAFFEE_LATE("Caffee Late" ,4) {
        @Override
        Coffee getNewInstance() {
            return new CaffeeLate();
        }
    },
    CAPPUCINO("Cappucino",5) {
        @Override
        Coffee getNewInstance() {
            return new Cappuccino();
        }
    },
    MOCHA("Mocha",6) {
        @Override
        Coffee getNewInstance() {
            return new Mocha();
        }
    },
    DEFAULT("Yaratmak istediğiniz kahve türü ",7) {
        @Override
        Coffee getNewInstance() {
            return new TemplateCoffee();
        }
    };

    private final String name;
    private final int index;
    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    abstract Coffee getNewInstance();


    CoffeeEnum(String name, int index) {
        this.name=name;
        this.index=index;
    }
}
