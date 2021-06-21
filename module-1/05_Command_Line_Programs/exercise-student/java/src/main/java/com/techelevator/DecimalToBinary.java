package com.techelevator;

import java.util.Scanner;

//Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321
//
//		460 in binary is 111001100
//		8218 in binary is 10000000011010
//		1 in binary is 1
//		31313 in binary is 111101001010001
//		987654321 in binary is 111010110111100110100010110001

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); //initializes our object - constructor
		System.out.println("Change a decimal to binary!");

		System.out.print("Please provide a series of numbers (space separated): ");
		String numbers = scanner.nextLine();
		String[] numbersArray = numbers.split(" ");


		// For each String in the array convert to number
		for(int i = 0; i < numbersArray.length; i++){
			int stringToNumber = Integer.parseInt(numbersArray[i]);
			String binaryNumber =	Integer.toBinaryString(stringToNumber);
			System.out.println(numbersArray[i] + " in binary is " + binaryNumber);
		}


	}

}
