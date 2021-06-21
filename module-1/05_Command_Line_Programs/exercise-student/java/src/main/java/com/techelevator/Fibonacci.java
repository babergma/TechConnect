package com.techelevator;
//		The Fibonacci numbers are the integers in the following sequence:
//
//		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
//		By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two:
//
//		0 + 1 = 1
//		1 + 1 = 2
//		1 + 2 = 3
//		2 + 3 = 5
//		3 + 5 = 8
//		...
//		Write a command-line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number:
//
//		Please enter a number: 17
//
//		0, 1, 1, 2, 3, 5, 8, 13
//		If the input is a number that appears in the Fibonacci sequence, print the sequence up to and including that number:
//
//		Please enter a number: 34
//
//		0, 1, 1, 2, 3, 5, 8, 13, 21, 34
//		The Fibonacci sequence always starts with 0 and 1. If the input is 0 or a negative number, print "0, 1":
//
//		Please enter a number: 0
//
//		0, 1
//		If the input is 1, print "0, 1, 1":
//
//		Please enter a number: 1
//
//		0, 1, 1

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the a number: ");
		String stringFib = scanner.nextLine();
		int intFib = Integer.parseInt(stringFib); //intFIb is the number type

		if (intFib > 1) {
			int fibTwo = 1;
			int fibOne = 1;
			System.out.print("1, 1, ");
			for(int i=1; i+fibTwo < intFib;){
				fibOne = i + fibTwo;
				i = fibTwo;
				fibTwo = fibOne;
				System.out.print(fibOne + " ,");
			}
		}
		else if(intFib == 0){
			System.out.println(intFib + ", 1");
		}
		else if(intFib == 1){
			System.out.println("0 , 1, "+ intFib);
		}
		else{
			System.out.println(intFib + " is not a Fib number");
		}
	}






}
