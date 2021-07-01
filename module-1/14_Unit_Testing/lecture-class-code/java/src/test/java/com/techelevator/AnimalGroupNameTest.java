package com.techelevator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

public class AnimalGroupNameTest {

    private AnimalGroupName cut;

    @Before
    public void setUp() throws Exception {
        cut = new AnimalGroupName();
    }

    @Test
    public void getHerdForRhino() {
        assertEquals("Crash", cut.getHerd("Rhino"));
    }

    @Test
    public void getHerdForUnknown() {
        assertEquals("unknown", cut.getHerd("NotThere"));
    }
}