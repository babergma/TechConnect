package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {



		System.out.println("####################");
		System.out.println("        LIST recap");
		System.out.println("####################");
		System.out.println();

		//List review, use a list to iterate over a collection of shakes to output the ingredients of product code SK3;

		List<Shake> shakeList = new ArrayList<>();
		shakeList.add(new Shake("SK1","Truman Trouble","Vanilla,Ripple,Blueberries,Banana,Turmeric,Yogurt,Peanut Butter"));
		shakeList.add(new Shake("SK2","Mean Green","Spinach,Avocado,Goat Milk,Yogurt"));
		shakeList.add(new Shake("SK3","Pancake","Vanilla,Goat Milk,Banana,Cinnamon,Honey"));
		shakeList.add(new Shake("SK4","ML Surprise","Goat Milk,Banana,Peanut Butter,Honey,Flax Seed,Greens"));
		for (Shake shake: shakeList){
			System.out.println(	"Looking at :" + shake.getProductCode());
			if (shake.getProductCode().equalsIgnoreCase("SK3")) {
				System.out.println(	"Used productCode as a comparison in a loop to find:" + shake);
			}
		}
		// the above iterates over the whole list 4 times, *not optimal* especially if we had thousands of recipes
		// for shakes (smoothies)


		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Map<K,V>

		// declare a local variable of datatype Map with
		// a String datatype for the key, and a Shake datatype for the value
		Map<String,Shake> shakes;
		//instantiate a new HashMap (which is a class that implements the Map interface)
		shakes = new HashMap<String,Shake>();

		// use the method "put" to add a new map entry to the Map instead of the "add" used by a list
		// the put method uses a "key" and a "value" as opposed to just the "value" in a List
		// we are going to use the barcode or "productCode" as the key because that is what
		// we will get from the barcode reader on the point of sale machine
		shakes.put("SK1",new Shake("SK1","Truman Trouble","Vanilla,Ripple,Blueberries,Banana,Turmeric,Yogurt,Peanut Butter"));
		shakes.put("SK2",new Shake("SK2","Mean Green","Spinach,Avocado,Goat Milk,Yogurt"));
		shakes.put("SK3",new Shake("SK3","Pancake","Vanilla,Goat Milk,Banana,Cinnamon,Honey"));
		shakes.put("SK4",new Shake("SK4","ML Surprise","Goat Milk,Banana,Peanut Butter,Honey,Flax Seed,Greens"));

		//get the same productCode as we did in the list example, now it does not iterate but
		//goes directly to that shake when we give it the "productCode"
		//the "get" method in a HashMap is much more efficient than a loop in a List
		System.out.println();
		System.out.println(	"Used productCode as the key to find:" + shakes.get("SK3"));
		System.out.println();

		//if we add "Vanilla" as an ingredient multiple times, we still don't want to show it
		//more than once... also we don't want to find a shake multiple times
		//because it has it in the list of ingredients more than once
		shakes.get("SK3").getIngredients().add("Vanilla");
		shakes.get("SK3").getIngredients().add("Vanilla");
		shakes.get("SK3").getIngredients().add("Vanilla");
		System.out.println(	"We still only show 'Vanilla' once because we used a HashSet which has only unique values" + shakes.get("SK3"));

		// if we add Vanilla multiple times to a "Set" we don't get duplicates
		// if we expect all unique values, this helps us not have to do an expensive check

		System.out.println("####################");
		System.out.println("      MAP Iteration");
		System.out.println("####################");
		System.out.println();

		//if we do want to loop through then to print out all of the Shakes with Vanilla as an ingredient
		//we use the "entrySet" method to return each Map.Entry of our HashMap collection
		for (Map.Entry<String,Shake> shakeMapEntry : shakes.entrySet()) {
			//System.out.println(shake.getValue().getIngredients());
			System.out.println("Looking at product with the productCode of:" + shakeMapEntry.getKey());
			Shake shake = shakeMapEntry.getValue();
			Set<String> ingredientsOfShake = shake.getIngredients();
			for (String ingredient : ingredientsOfShake){
				if (ingredient.equals("Vanilla")) {
					System.out.println(shake.getShakeName() + " has Vanilla!");
					System.out.println("------------------------");
				}
			}
		}

		//Code written during lecture
		//we started out with a List and change to a Set so we could have unique values
//		List<String> ingredients = new ArrayList<>();
//		ingredients.add("Blueberries");
////		ingredients.add("Ripple");
////		ingredients.add("Vanilla");
////		ingredients.add("Vanilla");
////		ingredients.add("Vanilla");
//
//		//shakes.put("SR1",new Shake(ingredients,"TrumanTrouble"));
//		Set<String> ingredients2 = new HashSet<>();
//		ingredients2.add("Spinach");
//		ingredients2.add("Avocado");
//
//		//shakes.put("SR7",new Shake(ingredients2,"MeanGreen"));
//
//		shakes.get("SR1").getIngredients().add("Turmeric");
//		System.out.println(	shakes.get("SR1").getIngredients());
////		System.out.println(	shakes.get("SR7").getIngredients());
//		//Map<String,List<Stamp>>
//		for (Map.Entry<String,Shake> shakeMapEntry : shakes.entrySet()) {
//			//System.out.println(shake.getValue().getIngredients());
//			//System.out.println(shakeMapEntry.getKey());
//			Shake shake = shakeMapEntry.getValue();
//			Set<String> ingredientsOfShake = shake.getIngredients();
//			for (String ingredient : ingredientsOfShake){
//				if (ingredient.equals("Vanilla")) {
//					System.out.println(shake.getShakeName());
//				}
//			}
//		}


//		for (Shake shake: shakes){
//			if (shake.getShakeName().equalsIgnoreCase("meangreen")) {
//				System.out.println(shake);
//			}
//		}
//
//		List<String> ingredients = new ArrayList<>();
//		ingredients.add("Blueberries");
//		ingredients.add("Ripple");
//		ingredients.add("Vanilla");
//		ingredients.remove("Vanilla");
//
//		for (String ingredient : ingredients) {
//			System.out.println(ingredient);
//		}
//		for (int i=0;i<ingredients.size();i++){
//			System.out.println(ingredients.get(i));
//		}

	}

}
