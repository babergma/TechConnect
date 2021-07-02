package com.techelevator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Matchers.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalGroupNameTest {

    private AnimalGroupName cut;


    @Before
    public void setUp() throws Exception {
    }

    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {"rhino", "Crash"},
                {"giraffe", "Tower"},
                {"elephant", "Herd"},
                {"lion", "Pride"},
                {"crow", "Murder"},
                {"pigeon", "Kit"},
                {"flamingo", "Pat"},
                {"dog", "Pack"},
                {"crocodile", "Float"}
        });
    }
    private String animalName;
    private String animalGroup;

    public AnimalGroupNameTest(String animalName, String animalGroup){
        cut = new AnimalGroupName();
        this.animalName = animalName;
        this.animalGroup = animalGroup;
    }

    @Test
    public void getHerdTest() {
        assertEquals("Animal " + animalName + " should be " + animalGroup, animalGroup, cut.getHerd(animalName));
    }

//    @Test
//    public void getHerdForRhino() {
//        assertEquals("Crash", cut.getHerd("Rhino"));
//    }
//
//    @Test
//    public void getHerdForUnknown() {
//        assertEquals("unknown", cut.getHerd("NotThere"));
//    }
}