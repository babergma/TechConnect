package com.techelevator.farm;

/*
 * FarmAnimal contains the abstract method eat, so we declare the class abstract
 * FarmAnimal is an abstract class (not concrete) therefore we can NOT use new keyword.
 * We can NO longer say new FarmAnimal(...)
 */
abstract public class FarmAnimal implements Singable {
	private String name;
	private String sound;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	/*
	 * All FarmAnimals need to eat so we place the eat method into the FarmAnimal class
	 * All FarmAnimals eat differently, so we make the eat method abstract
	 * Now FarmAnimal class contains the abstract method eat so we need to declare FarmAnimal as abstract
	 */
	abstract public String eat();

	/*
	 * public - any class in any package regardless of it's relationship (does not have to be a subclass) can
	 *          call the method or directly access the field
	 *
	 * protected - methods outside package where in the context of a subclass are accessible
	 *
	 * default (no keyword) - methods inside the same package can call methods or access fields
	 *
	 * private - only methods inside the same class can call methods or access fields
	 */

	protected String demoScopeMethod() {
		return "Inside demoScopeMethod";
	}

	public String getName( ) {
		return name;
	}

	/*
	 * I do NOT want my subclass to override this method
	 * It's written in a way that could invalid the way my class works if overriden
	 */
	final public String getSound( ) {
		return sound;
	}

}