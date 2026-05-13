package com.jogo.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player {
    private IntegerProperty health;
    private IntegerProperty nature;
    private IntegerProperty water;
    private IntegerProperty people;
    private IntegerProperty money;

    public int getHealth() { return health.get(); }
    public int getNature() { return nature.get(); }
    public int getPeople() { return people.get(); }
    public int getMoney()  { return money.get();  }
    public int getWater()  { return water.get();  }

    public IntegerProperty healthProperty(){ return health; }
    public IntegerProperty peopleProperty(){ return people; }
    public IntegerProperty natureProperty(){ return nature; }
    public IntegerProperty moneyProperty() { return money;  }
    public IntegerProperty waterProperty() { return water;  }

    /**
     * 
     * @param stats int[]{saúde, natureza, água, população, dinheiro}
     */
    public void addStats(int[] stats){
        health.set(newValue(health.get(), stats[0]));
        nature.set(newValue(nature.get(), stats[1]));
        water. set(newValue(water.get(),  stats[2]));
        people.set(newValue(people.get(), stats[3]));
        money. set(newValue(money.get(),  stats[4]));
    }
    
    private int newValue(int value, int add){
        value += add;
        return (value > 100) ? 100 : (value < 0) ? 0 : value;
    }

    public Player(){
        health = new SimpleIntegerProperty(100);
        nature = new SimpleIntegerProperty(100);
        water  = new SimpleIntegerProperty(100);
        people = new SimpleIntegerProperty(100);
        money  = new SimpleIntegerProperty(100);
    }
}
