package com.techelevator.farm.demo;

import com.techelevator.farm.Chicken;
import com.techelevator.farm.FarmAnimal;

public class ScopeDemoClass extends FarmAnimal {

    public ScopeDemoClass(String name, String sound) {
        super(name, sound);
    }

    public void showScope(){
        FarmAnimal myChicken = new Chicken();
        this.demoScopeMethod();
    }

    @Override
    public String eat() {
        return null;
    }
}
