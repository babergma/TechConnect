package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> animalGroupName = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

		animalGroupName.put("Rhino", "Crash");
		animalGroupName.put("Giraffe", "Tower");
		animalGroupName.put("Elephant", "Herd");
		animalGroupName.put("Lion", "Pride");
		animalGroupName.put("Crow", "Murder");
		animalGroupName.put("Pigeon", "Kit");
		animalGroupName.put("Flamingo", "Pat");
		animalGroupName.put("Deer", "Herd");
		animalGroupName.put("Dog", "Pack");
		animalGroupName.put("Crocodile", "Float");

		String name = "unknown";
		if (animalName == null) {
			return name;
		}
		if (animalGroupName.containsKey(animalName)) {
			return animalGroupName.get(animalName);
		} else {
			return name;
		}
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		Map<String, Double> isItOnSale = new HashMap<>();

		isItOnSale.put("KITCHEN4001", 0.20);
		isItOnSale.put("GARAGE1070", 0.15);
		isItOnSale.put("LIVINGROOM", 0.10);
		isItOnSale.put("KITCHEN6073", 0.40);
		isItOnSale.put("BEDROOM3434", 0.60);
		isItOnSale.put("BATH0073", 0.15);

		if (itemNumber == null) {
			return 0.00;
		}
		if (isItOnSale.containsKey(itemNumber.toUpperCase())) {
			return isItOnSale.get(itemNumber.toUpperCase());
		}
		return 0.00;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		int peterMoney = peterPaul.get("Peter");
		int paulMoney = peterPaul.get("Paul");
//if peter has more than 0 and paul has less than 1000
		//then transfer half of it to paul
		if (peterMoney > 0 && paulMoney < 1000) {
			if (peterMoney % 2 != 0) {
				peterMoney = peterMoney / 2;
				paulMoney = peterMoney + paulMoney;
				peterMoney++;
			} else if (peterMoney > 0 && paulMoney < 1000) {
				peterMoney = peterMoney / 2;
				paulMoney = peterMoney + paulMoney;
			} else {
				return peterPaul;
			}
		}
		peterPaul.put("Peter", peterMoney);
		peterPaul.put("Paul", paulMoney);

		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		int peterMoney = peterPaul.get("Peter");
		int paulMoney = peterPaul.get("Paul");
//if peter has 5000 or more, and paul has 10000 or more
		if (peterMoney >= 5000 && paulMoney >= 10000) {

			int partnershipPeter = peterMoney / 4;
			peterMoney = peterMoney - partnershipPeter;
			int partnershipPaul = paulMoney / 4;
			paulMoney = paulMoney - partnershipPaul;
			int total = partnershipPaul + partnershipPeter;

			peterPaul.put("Peter", peterMoney);
			peterPaul.put("Paul", paulMoney);
			peterPaul.put("PeterPaulPartnership", total);
			return peterPaul;
		} else {
			return peterPaul;
		}
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	//array of non-empty strings
	public Map<String, String> beginningAndEnding(String[] words) {

		//creation of a map called keyValue
		Map<String, String> keyValue = new HashMap<>();

		//for loop that goes through all the strings of beginningAndEnding array
		for (String strings : words) {
//puts the first and last letter of each string into the keyValue map
			keyValue.put(strings.substring(0, 1), strings.substring(strings.length() - 1));
		}
		return keyValue;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	//given array of Strings called words
	public Map<String, Integer> wordCount(String[] words) {
		//creation of map called counts
		Map<String, Integer> counts = new HashMap<>();
//loops through every string in the words array
		for (String word : words) {
			//checks if the map has the specified string in it
			if (counts.containsKey(word)) {
				//counts how many times a particular string are in an array
				int currentCount = counts.get(word);
				currentCount++;
				//puts the word count into the map
				counts.put(word, currentCount);
			} else {
				counts.put(word, 1);
			}
		}
		return counts;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	//array of int values called ints
	public Map<Integer, Integer> integerCount(int[] ints) {
//map called counts
		Map<Integer, Integer> counts = new HashMap<>();
//loops through all of the ints
		for (int integerCheck : ints) {
			//checks if the map has the int in its key
			if (counts.containsKey(integerCheck)) {
				//when the key matches the int in the array
				//then get the key and set it to the count/ inc the count
				int currentCount = counts.get(integerCheck);
				currentCount++;
				//put the count in the map
				counts.put(integerCheck, currentCount);
			} else {
				counts.put(integerCheck, 1);
			}
		}
		return counts;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true} */
	//array of strings called words
	public Map<String, Boolean> wordMultiple(String[] words) {
//creation of 2 maps w the name wordMultiple and trueTwoOrMore
		Map<String, Boolean> wordMultiple = new HashMap<>();//return this map after feeding in Integer count results
		Map<String, Integer> trueTwoOrMore = new HashMap<>();//use this map to run count
//loops through all of the array
		for (String multipleTimes : words) {
//checks if the map has the same key as in the array
			if (trueTwoOrMore.containsKey(multipleTimes)) {
				int currentCount = trueTwoOrMore.get(multipleTimes);
				//increments
				currentCount++;
				//checks that increment is more than one
				if (currentCount > 1) {
					//puts it into the map
					wordMultiple.put(multipleTimes, true);
				} else {
					wordMultiple.put(multipleTimes, false);
				}
			} else {
				trueTwoOrMore.put(multipleTimes, 1);
				wordMultiple.put(multipleTimes, false);
			}
		}
		return wordMultiple;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
													 Map<String, Integer> remoteWarehouse) {
		Map<String, Integer> newMap = new HashMap<>();

		for (String name : mainWarehouse.keySet()) {
			if (remoteWarehouse.containsKey(name)) {
				newMap.put(name, (mainWarehouse.get(name) + remoteWarehouse.get(name)));
			} else {
				newMap.put(name, mainWarehouse.get(name));
			}
		}
		for (String name : remoteWarehouse.keySet()) {
			if (!(mainWarehouse.containsKey(name))) {
				newMap.put(name, remoteWarehouse.get(name));
			}
		}
		return newMap;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 */
//	//array of strings called stringArray
	public Map<String, Integer> last2Revisited(String[] stringArray) {
		Map<String, Integer> keyAndCount = new HashMap<>();

		for (String key : stringArray) {
			if (key.length() <= 2) {
				keyAndCount.put(key, 0);
				keyAndCount.put(key + 2, 0);
			}
			String lastTwo = key.substring(key.length() - 2);
//
	int count = 0;
	for (int i = 0; i < key.length() - 2; i++) {
		if(key.substring(i, i+2).equals(lastTwo)) {
			count++;

		}

	}
			keyAndCount.put(key, count);
		}

		return keyAndCount;
	}
}