package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Same;

import static org.junit.Assert.*;
/*
 Given an array of ints, return true if the array is length 1 or more, and the first element and
 the last element are equal.
 IsItTheSame([1, 2, 3]) → false
 IsItTheSame([1, 2, 3, 1]) → true
 IsItTheSame([1, 2, 1]) → true
 */

public class SameFirstLastTest {
private SameFirstLast cut;
    @Before
    public void setUp() throws Exception {
        cut = new SameFirstLast();
    }

    @Test
    public void checkWhenLengthZero() {
        assertEquals(false, cut.isItTheSame(new int[] {}));
    }

    @Test
    public void checkWhenNotEqual() {
        assertEquals(false, cut.isItTheSame(new int[] {2, 3}));
        assertEquals(false, cut.isItTheSame(new int[] {2, 2, 3}));
        assertEquals(false, cut.isItTheSame(new int[] {3, 2, 2}));
    }

    @Test
    public void checkWhenEqual() {
        assertEquals(true, cut.isItTheSame(new int[] {2, 2}));
        assertEquals(true, cut.isItTheSame(new int[] {2, 2, 2}));
        assertEquals(true, cut.isItTheSame(new int[] {3, 2, 3}));
    }

    @Test
    public void checkIfNull() {
        assertEquals(false, cut.isItTheSame(null));
    }
}