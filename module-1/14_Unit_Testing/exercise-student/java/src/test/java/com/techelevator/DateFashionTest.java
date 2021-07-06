package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateFashionTest {
private DateFashion cut;
    @Before
    public void setUp() throws Exception {
        cut = new DateFashion();
    }

    @Test
    public void checkEdgeNoTable() {
        assertEquals(0, cut.getATable(2,2));
    }

    @Test
    public void checkBothEdgeYesTable8() {
        assertEquals(2, cut.getATable(8,8));
    }
    @Test
    public void checkBothEdgeYesTable10() {
        assertEquals(2, cut.getATable(10,10));
    }

    @Test
    public void checkYouEdgeNoTable2() {
        assertEquals(0, cut.getATable(10,2));
    }

    @Test
    public void checkDateEdgeNoTable2() {
        assertEquals(0, cut.getATable(2,10));
    }
}