package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/*
 * Given a string, return a new string made of every other char starting with
 * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
 * → "H" GetBits("Heeololeo") → "Hello"
 */
public class StringBitsTest {
private StringBits cut;
    @Before
    public void setUp() throws Exception {
        cut = new StringBits();
    }

    @Test
    public void checkIfNull() {
        assertEquals("", cut.getBits(null));
    }

    @Test
    public void checkLengthOne() {
        assertEquals("H", cut.getBits("H"));
    }

    @Test
    public void checkLengthTwo() {
        assertEquals("H", cut.getBits("Hi"));
    }

    @Test
    public void checkIndexLast() {
        assertEquals("Hello", cut.getBits("Hlo"));
    }
}