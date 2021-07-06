package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {
    private NonStart cut;
//    GetPartialString("Hello", "There") → "ellohere"
//    GetPartialString("java", "code") → "avaode"
//    GetPartialString("shotl", "java") → "hotlava"

    @Before
    public void setUp() throws Exception {
        cut = new NonStart();
    }

    @Test
    public void checkStrings() {
        String firstActual = "Hello";
        String secondActual = "There";
        assertEquals("ellohere", cut.getPartialString(firstActual, secondActual));
    }

    @Test
    public void checkFirstLengthZero() {
        String firstActual = "";
        String secondActual = "hi";
        assertEquals("i", cut.getPartialString(firstActual, secondActual));
    }

    @Test
    public void checkSecondLengthZero() {
        String firstActual = "hi";
        String secondActual = "";
        assertEquals("i", cut.getPartialString(firstActual, secondActual));
    }
}