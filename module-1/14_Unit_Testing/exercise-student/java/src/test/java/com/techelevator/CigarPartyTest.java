package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CigarPartyTest {
    private CigarParty cut;
    @Before
    public void setUp() throws Exception {
        cut = new CigarParty();
    }

//    haveParty(30, false) → false
//    haveParty(50, false) → true
//    haveParty(70, true) → true

    @Test
    public void checkIfBelow40Weekday() {
        boolean expected = false;
        boolean actual = cut.haveParty(30, false);
        assertEquals(expected, actual);
    }

    @Test
    public void checkIfBelow40Weekend() {
        boolean expected = false;
        boolean actual = cut.haveParty(30, true);
        assertEquals(expected, actual);
    }

    @Test
    public void checkEdgeCase40() {
        boolean expected = true;
        boolean actual = cut.haveParty(40, true);
        assertEquals(expected, actual);
    }

    @Test
    public void checkEdgeCase60() {
        boolean expected = true;
        boolean actual = cut.haveParty(60, true);
        assertEquals(expected, actual);
    }

    @Test
    public void checkOver60Weekend() {
        boolean expected = true;
        boolean actual = cut.haveParty(61, true);
        assertEquals(expected, actual);
    }

    @Test
    public void checkOver60NotWeekend() {
        boolean expected = false;
        boolean actual = cut.haveParty(61, false);
        assertEquals(expected, actual);
    }

}