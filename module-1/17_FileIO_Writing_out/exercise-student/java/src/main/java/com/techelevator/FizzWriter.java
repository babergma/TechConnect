package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FizzWriter {

//	If the number is divisible by 3, or contains a 3, print Fizz.
//	If the number is divisible by 5, or contains a 5, print Buzz.
//	If the number is divisible by 3 and 5, print FizzBuzz.
//	Otherwise, print the number.
//	The program must prompt the user for the following values:
//
//	The destination file
//	If the file already exists, it must be overwritten. If the user enters an invalid destination file, the program indicates this and exits.

	public static void main(String[] args) {
		/* set a destination file to be written to */

		// Get the number from user
		Scanner userInput = new Scanner(System.in);
		System.out.println("Input file destination: ");
		String path = userInput.nextLine();
		File destinationFile = new File(path);
		if (!destinationFile.exists()) {
			//if it exists it need to be overritten
		}
		if (!destinationFile.isFile()) {
			System.out.println("Destination file is not a file");
			System.exit(1); // Ends the program
		}


		//PrintWriter allows you to write to a file
		try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(
				destinationFile, true /* This true sets the file to be appended */
		))) {
			IntStream.rangeClosed(1, 300).mapToObj(i -> i % 3 ==0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
					.forEach(dataOutput::println);
//			if(){
//
//			}
//			else if(){
//
//			}
			//dataOutput.println(updatedLine);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
