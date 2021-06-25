package com.techelevator;

public class HomeworkAssignment {
    //instance variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    //constructor: HomeworkAssignment that has possiblemarks and earnedmarks as arguments
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    //getter and setter for earnedmarks
    //getters and setters allow you to access private variables in other classes

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        double score = (1.0 * earnedMarks / possibleMarks) * 100;
        if (score >= 90) {
            return "A";
        } else if ((double)score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
