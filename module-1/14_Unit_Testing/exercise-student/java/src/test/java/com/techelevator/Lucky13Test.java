package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lucky13Test {
    /*
     * Given an array of ints, return true if the array contains no 1's and no 3's.
     * GetLucky([0, 2, 4]) → true
     * GetLucky([1, 2, 3]) → false
     * GetLucky([1, 2, 4]) → false
     */
    private Lucky13 cut;
    @Before
    public void setUp() throws Exception {
        cut = new Lucky13();
    }

    @Test
    public void checkIfContainsAOne() {
        assertEquals(false, cut.getLucky(new int[] { 1, 2, 4}));
        assertEquals(false, cut.getLucky(new int[] { 4, 1, 2}));
        assertEquals(false, cut.getLucky(new int[] { 4, 2, 1}));
    }

    @Test
    public void checkIfContainsAThree() {
        assertEquals(false, cut.getLucky(new int[] { 0, 3, 4}));
        assertEquals(false, cut.getLucky(new int[] { 3, 0, 4}));
        assertEquals(false, cut.getLucky(new int[] { 4, 0, 3}));
    }

    @Test
    public void checkTrueCase() {
        assertEquals(true, cut.getLucky(new int[] { 0, 2, 4}));
    }
}