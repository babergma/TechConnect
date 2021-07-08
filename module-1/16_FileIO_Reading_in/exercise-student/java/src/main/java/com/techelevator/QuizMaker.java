package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
		try (Scanner scan = new Scanner(System.in)) {

			while (true) {
				System.out.println("Insert name of quiz file: ");
				String quizName = scan.nextLine();
				File quizFile = new File(quizName);
				if (quizFile.exists() == false) {
					System.out.println("Error: " + quizName + "doesn't exist");
				}
				if (quizFile.isFile() == false) {
					System.out.println("Error: " + quizName + "isnt a file");
				}
				Quiz(quizFile);
			}
		}

	}

	public static void Quiz(File quizFile) throws FileNotFoundException {
		List<QuizQ> quizQ = new ArrayList<QuizQ>();
		//scan file to get questions
		Scanner fileScan = new Scanner(quizFile.getAbsoluteFile());

		try {

//					System.out.println("inside try");
			while (fileScan.hasNextLine()) {

				String lineFromTxt = fileScan.nextLine();
				quizQ.add(new QuizQ(lineFromTxt));
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}


		int numQ = 0;
		int numCorrectA = 0;

		for(QuizQ quiz : quizQ) {

			while(true) {

				System.out.println("\n" + quiz.getQuestion());

				for (int i = 0; i < quiz.getAnswers().length; i++) {
					System.out.println((i + 1) + ") " + quiz.getAnswers()[i]);
				}

				System.out.println("\nYour answer?");
				String userAnswer = fileScan.nextLine();

				if ((userAnswer.isEmpty() == false) && (userAnswer.matches("[1-4]")) ) {
					if (quiz.isCorrect(userAnswer)) {
						System.out.println("Correct!");
						numCorrectA += 1;
					}
					else {
						System.out.println("Not correct!");
					}
					break;
				}
				System.out.println("Invalid answer!");
			}
			numQ += 1;
		}
		System.out.println("You got " + numCorrectA + " answers correct out of " + numQ);
	}
}
