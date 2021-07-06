package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {

    private WordCount cut;

    @Before
    public void setUp() throws Exception {
        cut = new WordCount();
    }

    @Test
    public void getCountForArrayBaBaBlackSheep() {
        String[] input = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> actual = cut.getCount(input);

        assertThat("should be ba : 2", actual, hasEntry("ba", 2));
    }
}