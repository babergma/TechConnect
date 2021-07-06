package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//         MakeArray([1, 2, 3]) → [3, 3, 3]
//         MakeArray([11, 5, 9]) → [11, 11, 11]
//         MakeArray([2, 11, 3]) → [3, 3, 3]

public class MaxEnd3Test {
private MaxEnd3 cut;
    @Before
    public void setUp() throws Exception {
        cut = new MaxEnd3();
    }

    @Test
    public void checkLargestChosen() {
        assertArrayEquals(new int[] {3, 3, 3}, cut.makeArray(new int[] {2, 2, 3}));
        assertArrayEquals(new int[] {3, 3, 3}, cut.makeArray(new int[] {3, 2, 2}));
    }

    @Test
    public void checkMiddleNotChosen() {
        assertArrayEquals(new int[] {3, 3, 3}, cut.makeArray(new int[] {2, 11, 3}));
        assertArrayEquals(new int[] {3, 3, 3}, cut.makeArray(new int[] {3, 11, 2}));
    }
}