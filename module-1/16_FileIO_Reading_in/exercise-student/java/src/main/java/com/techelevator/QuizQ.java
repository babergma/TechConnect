package com.techelevator;

public class QuizQ {

    private String correctA;
    private String question;
    private String[] answers;

    public QuizQ(String line) {
        if ((line != null) && (!line.isEmpty())) {	// Skip null or empty lines
            String[] parts = line.split("\\|");
            this.question = parts[0];
            answers = new String[parts.length-1];
            for(int i = 1; i < parts.length; i++) {
                String answer = parts[i].trim();
                if (answer.endsWith("*")) {
                    answer = answer.substring(0, answer.length()-1);
                    this.correctA = Integer.toString(i);
                }

                answers[i-1] = answer;


            }
        }
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getAnswers() {
        return this.answers.clone(); // Return a copy, preserving the original
    }

    public boolean isCorrect(String chooseString) {
        return this.correctA.equals(chooseString);
    }
}
