package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

//    The program must prompt the user for the following values:
//
//    The search word
//    The word to replace the search word with
//    The source file
//    This must be an existing file. If the user enters an invalid source file, the program indicates this to the user and exits.
//    The destination file
//    The program creates a copy of the source file with the requested replacements at this location. If the file already exists, it must be overwritten. If the user enters an invalid destination file, the program indicates this to the user and exits.
//            Note: This is a case-sensitive search. If your search word is Bacon, then bacon shouldn't be replaced.
//
    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)) {

            // Get the path of the input file
            System.out.println("What is the path/file that should be searched?");
            String path = userInput.nextLine();
            File inputFile = inputFile = new File(path);
            if (!inputFile.exists()) {
                System.out.println(path + " does not exist");
                System.exit(1); // Ends the program
            }
            if (!inputFile.isFile()) {
                System.out.println(path + " is not a file");
                System.exit(1); // Ends the program
            }

            // Get the search word from the user
            System.out.println("What is the search word you are looking for?");
            String searchWord = userInput.nextLine();
            System.out.println("Search word is: " + searchWord);
            if ((searchWord == null) || (searchWord.isEmpty())) {
                System.out.println("The search word is empty");
                System.exit(1);
            }

            System.out.println("What word would you like to use to replace the search word?");
            String replaceWord = userInput.nextLine();
            System.out.println("Replacement word is: " + replaceWord);
            if ((replaceWord == null) || (replaceWord.isEmpty())) {
                System.out.println("The replacement word is empty");
                System.exit(1);
            }

            /* set a destination file to be written to */
            File destinationFile = new File("src/main/resources/bacon-emoji.txt");


            // Perform word search
                //scans each line of the file with inputScanner
            try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())){

                while (inputScanner.hasNextLine()) {
                    //creates a string for each line of the file
                    String line = inputScanner.nextLine();

                            //PrintWriter allows you to write to a file
                            try (PrintWriter dataOutput = new PrintWriter( new FileOutputStream(
                                    destinationFile, true /* This true sets the file to be appended */
                            ))) {
                                //checks the string from the file to see if the search word is present
                                if (line.contains(searchWord)) {
                                    //create a new string to hold the updated line
                                    String updatedLine = line.replaceAll(searchWord, replaceWord);

                                    //    System.out.println(line); //prints the line if it has the search word in it
                                    //     System.out.println(updatedLine); //prints the updated line (replaces search word with replacement word)

                                    //what is being written into the destination file
                                    dataOutput.println(updatedLine);
                                }
                            } catch (FileNotFoundException ex) {
                                System.err.println("Can not open the destination file for writing.");
                            }
//                            System.out.println(destinationFile);

                    }

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
