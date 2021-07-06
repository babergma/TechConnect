package com.techelevator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Given a string and a non-negative int n, we'll say that the front of the
 * string is the first 3 chars, or whatever is there if the string is less than
 * length 3. Return n copies of the front; frontTimes("Chocolate", 2) →
 * "ChoCho" frontTimes("Chocolate", 3) → "ChoChoCho" frontTimes("Abc", 3) →
 * "AbcAbcAbc"
 */
public class FrontTimesTest {
private FrontTimes cut; //create space in heap for obj
    //and to make sure there is nothing left over from previous test

    @Before
    public void setUp() throws Exception {
        cut = new FrontTimes(); //instantiate obj in the program before the test runs
    }

//            frontTimes("Chocolate", 2) → "ChoCho"
//            frontTimes("Chocolate", 3) → "ChoChoCho"
//            frontTimes("Abc", 3) → "AbcAbcAbc"
    @Test
    public void checkIfRepeatTwice(){

        //bc program takes in a string and an int
        String actualString = "ABC";
        int actualInt = 2;
       String actual = cut.generateString(actualString, actualInt);

       String expected = "ABCABC";
        //create a string to display message that program failed


       String programFailMsg = "Program error: didnt repeat twice";

assertEquals(programFailMsg, expected, actual);
    }

    @Test
    public void checkIfRepeatThreeTimes(){

        //bc program takes in a string and an int
        String actualString = "Cho";
        int actualInt = 3;
        String actual = cut.generateString(actualString, actualInt);

        String expected = "ChoChoCho";
        //create a string to display message that program failed

        String programFailMsg = "Program error: didnt reapeat 3 times";

        assertEquals(programFailMsg, expected, actual);
    }

    @Test
    public void checkIfEmpty(){

        //bc program takes in a string and an int
        String actualString = "";
        int actualInt = 0;
        String actual = cut.generateString(actualString, actualInt);

        String expected = "";
        //create a string to display message that program failed

        String programFailMsg = "Program error: empty";

        assertEquals(programFailMsg, expected, actual);
    }
}