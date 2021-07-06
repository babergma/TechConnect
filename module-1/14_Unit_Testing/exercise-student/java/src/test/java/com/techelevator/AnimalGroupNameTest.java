package com.techelevator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//test should fail for lion so check

public class AnimalGroupNameTest {
private AnimalGroupName cut;

    @Before
    public void setUp() throws Exception {
        cut = new AnimalGroupName();
    }
//    * Rhino -> Crash
//     * Giraffe -> Tower
//     * Elephant -> Herd
//     * Lion -> Pride
//     * Crow -> Murder
//     * Pigeon -> Kit
//     * Flamingo -> Pat
//     * Deer -> Herd
//     * Dog -> Pack
//     * Crocodile -> Float
//     *
    @Test
    public void getHerdForRhino() { //checks the name of the animal returns the correct herd name
        assertEquals("Crash", cut.getHerd("Rhino"));
    }
    @Test
    public void getHerdForGiraffe() { //checks the name of the animal returns the correct herd name
        assertEquals("Tower", cut.getHerd("Giraffe"));
    }
    @Test
    public void getHerdForElephant() { //checks the name of the animal returns the correct herd name
        assertEquals("Herd", cut.getHerd("Elephant"));
    }
    @Test
    public void getHerdForLion() { //checks the name of the animal returns the correct herd name
        assertEquals("Herd", cut.getHerd("Lion"));
    }
    @Test
    public void getHerdForCrow() { //checks the name of the animal returns the correct herd name
        assertEquals("Murder", cut.getHerd("Crow"));
    }
    @Test
    public void getHerdForPigeon() { //checks the name of the animal returns the correct herd name
        assertEquals("Kit", cut.getHerd("Pigeon"));
    }
    @Test
    public void getHerdForFlamingo() { //checks the name of the animal returns the correct herd name
        assertEquals("Pat", cut.getHerd("Flamingo"));
    }
    @Test
    public void getHerdForDeer() { //checks the name of the animal returns the correct herd name
        assertEquals("Herd", cut.getHerd("Deer"));
    }
    @Test
    public void getHerdForDog() { //checks the name of the animal returns the correct herd name
        assertEquals("Pack", cut.getHerd("Dog"));
    }
    @Test
    public void getHerdForCrocodile() { //checks the name of the animal returns the correct herd name
        assertEquals("Float", cut.getHerd("Crocodile"));
    }

    //testing for edge cases
    @Test
    public void getHerdForEmpty() { //checks for edge cases
        assertEquals("unknown", cut.getHerd(""));
    }
    @Test
    public void getHerdForNotContainedAnimal() { //checks for edge cases
        assertEquals("unknown", cut.getHerd("NotThere"));
    }
    @Test
    public void checkNull() { //checks for edge cases
        assertEquals("unknown", cut.getHerd(null));
    }
}