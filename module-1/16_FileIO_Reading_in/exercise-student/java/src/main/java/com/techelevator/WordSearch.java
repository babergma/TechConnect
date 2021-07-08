package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {


	public static void main(String[] args) {
		Scanner scanUserInput = new Scanner(System.in); //takes in what user types
		File file = null;
		do{
			System.out.println("Enter file name :");
			try {
				String fileName = scanUserInput.nextLine();
				 file = new File(fileName);
				System.out.println("File exists");

//START: word search - get the word from the user that will be searched
				System.out.println("What word would you like to search:");
				String word = scanUserInput.nextLine(); //get the user input

//START: case sensitive
				System.out.println("Would you like the search to be case sensitive? Y or N");
				boolean caseSensitive = scanUserInput.nextLine().toLowerCase().equals("y");

				if(word != null || !word.isEmpty()) {
					System.out.println("Success: the word is... " + word);

//BEGIN: search for the word
					int lineNumber = 1;
					Scanner scan = new Scanner(file.getAbsoluteFile());
//		System.out.println("In wordSearch: the word is... " + word);
					try {
						while (scan.hasNextLine()) {
							String lineFromTxt = scan.nextLine();

							if(caseSensitive) {

								if (lineFromTxt.contains(word)) {
									System.out.println(lineNumber + ") " + lineFromTxt);
								}
							}
							else{
								if (lineFromTxt.toLowerCase().contains(word.toLowerCase())) { // lower-case strings to make case-insensitive
									System.out.println(lineNumber + ") " + lineFromTxt);
								}
							}
	//END: case sensitive
								lineNumber++;

						}
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				else{
					System.out.println("The search word is empty");
					System.exit(1);
				}

//	END: search for the word


			} catch (FileNotFoundException e) {
				System.out.println("Error - file not found!");
			}
		}
		while(!file.exists());
	}

}
