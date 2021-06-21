package com.techelevator;
//Temperature conversion
//		The Fahrenheit to Celsius conversion formula is:
//
//		Tc = (Tf - 32) / 1.8
//		where 'Tc' is the temperature in Celsius, and 'Tf' is the temperature in Fahrenheit.
//
//		The Celsius to Fahrenheit conversion formula is:
//
//		Tf = Tc * 1.8 + 32
//		Write a command-line program which prompts a user to enter a temperature, and whether it's in degrees (C)elsius or (F)ahrenheit. Convert the temperature to the opposite degrees, and display the old and new temperatures to the console.
//
//		Please enter the temperature: 58
//		Is the temperature in (C)elsius, or (F)ahrenheit? F
//		58F is 14C.

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		int fTemp = 0;
		int cTemp = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the temperature: ");
		String stringTemp = scanner.nextLine();
		int intTemp = Integer.parseInt(stringTemp);

		System.out.println("Is the temperature in Celcius (C) or Fahrenheit? (F) ");
		String stringType = scanner.nextLine();
		System.out.println(stringType);
		if(stringType.equals("C") || stringType.equals("c")){
			fTemp = (int)(intTemp * 1.8) + 32;
			System.out.println(intTemp + " C is " + fTemp + " F");
		}
		else if(stringType.equals("F") || stringType.equals("f")){
			cTemp = (int)((intTemp - 32)/1.8);
			System.out.println(intTemp + " F is " + cTemp + " C");
		}
	}
}
