package data_structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapChallengeTest {

    HashMapChallenge<String, Number> testMap = new HashMapChallenge<>();

    // run this before any tests get run, anw u add stuff so there's smth t find
    @Before
    public void setUp() throws Exception {
        testMap.add("Nami", 200);
        testMap.add("Satoshi", 204);
        testMap.add("Hana", 205);
    }

    // when you call mvn test it looks at this methof
    @Test
    public void add() {
        testMap.add("Lego", 1);
        assertNotNull(testMap.find("Lego"));
    }

    @Test
    public void remove() {
        testMap.remove("Hana");
        assertNull(testMap.find("Hana"));
    }

    @Test
    public void find() {
        assertEquals(204, testMap.find("Satoshi"));
    }
}