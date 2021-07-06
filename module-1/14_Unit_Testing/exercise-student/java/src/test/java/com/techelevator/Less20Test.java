package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Less20Test {
private Less20 cut;
    @Before
    public void setUp() throws Exception {
        cut = new Less20();
    }

    @Test
    public void checkLessThanMultipleOf20() {
        assertEquals(true, cut.isLessThanMultipleOf20(18));
        assertEquals(true, cut.isLessThanMultipleOf20(19));
    }

    @Test
    public void checkExclusion20() {
        assertEquals(false, cut.isLessThanMultipleOf20(20));
    }

    @Test
    public void checkExclusion21() {
        assertEquals(false, cut.isLessThanMultipleOf20(21));
    }

    @Test
    public void check40() {
        assertEquals(false, cut.isLessThanMultipleOf20(40));
    }

    @Test
    public void check1Or2LessThan40() {
        assertEquals(true, cut.isLessThanMultipleOf20(38));
        assertEquals(true, cut.isLessThanMultipleOf20(39));
    }

}