package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}


	/*
	 * In each subclass of FarmAnimal we override the eat method with it's specific concrete
	 * implementation. Now we can create an instance of Chicken ( new Chicken() )
	 */
	@Override
	public String eat() {
		return "I'm a chicken and this is how I eat...";
	}
}