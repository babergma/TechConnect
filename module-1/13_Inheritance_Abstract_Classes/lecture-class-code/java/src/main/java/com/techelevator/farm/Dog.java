package com.techelevator.farm;

public class Dog extends FarmAnimal {


    public Dog() {
        super("Dog", "Arf");
    }


    @Override
    public String eat() {
        return "I'm a Dog and I eat bones!";
    }
}
