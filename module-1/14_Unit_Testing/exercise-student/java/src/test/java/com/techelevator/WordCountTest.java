package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

// * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
// * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
// * getCount([]) → {}
// * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
public class WordCountTest {
private WordCount cut;

    @Before
    public void setUp() throws Exception {
        cut = new WordCount();
    }

    @Test
    public void checkIfNull() {
        Map<String, Integer> output = cut.getCount(new String[] { });
        assertThat("wordCount([])", output.size(), is(0));
    }

    @Test
    public void countsAllStringsCorrectly() {
        Map<String, Integer> output = cut.getCount(new String[] { "a", "b", "a", "c", "b" });

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 1);

        assertThat("wordCount([\"a\", \"b\", \"a\", \"c\", \"b\"])", output.size(), is(3));
        assertThat("wordCount([\"a\", \"b\", \"a\", \"c\", \"b\"])", output, is(expected));

        output = cut.getCount(new String[] { "ba", "ba", "black", "sheep" });
 expected.clear();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\"])", output.size(), equalTo(3));
        assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\"])", output, is(expected));

    }

}