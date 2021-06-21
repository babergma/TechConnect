package com.techelevator;

import java.util.Scanner;

//Linear conversion
//		Write a program that converts meters to feet and vice-versa.
//
//		The foot to meter conversion formula is:
//
//		m = f * 0.3048
//		The meter to foot conversion formula is:
//
//		f = m * 3.2808399
//		Write a command-line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet. Convert the length to the opposite measurement, and display the old and new measurements to the console.
//
//		Please enter the length: 58
//		Is the measurement in (m)eter, or (f)eet? f
//		58f is 17m.
public class LinearConvert {

	public static void main(String[] args) {

		int fLength = 0;
		int mLength = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the length: ");
		String stringLength = scanner.nextLine();
		int intLength = Integer.parseInt(stringLength);

		System.out.println("Is the length in Feet (F) or Meters (M)? ");
		String stringType = scanner.nextLine();
		System.out.println(stringType);
		if(stringType.equals("M") || stringType.equals("m")){
			fLength = (int)(intLength * 3.2808399);
			System.out.println(intLength + " M is " + fLength + " F");
		}
		else if(stringType.equals("F") || stringType.equals("f")){
			mLength = (int)(intLength * 0.3048);
			System.out.println(intLength + " F is " + mLength + " M");
		}
	}


	}
