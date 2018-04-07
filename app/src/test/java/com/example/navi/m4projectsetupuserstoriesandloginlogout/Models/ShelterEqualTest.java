package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by dodo on 4/4/18.
 */
public class ShelterEqualTest {

    private Shelter shelterName;
    private Shelter testName;

    @Before
    public void setUp() throws Exception {
        shelterName = new Shelter("1", "Shelter Bob", "2", "3", "4", "5",
                "6", "7", "8");
    }

    @Test
    public void equals() throws Exception {
        testName = new Shelter("1", null, "2", "3", "4", "5",
                "6", "7", "8");
        assertFalse("Comparison fails for null", shelterName.equals(testName));
        testName = new Shelter("1", "", "2", "3", "4", "5",
                "6", "7", "8");
        assertFalse("It's not a shelter", shelterName.equals(testName));
        testName = new Shelter("1", "Shelter Bob", "2", "3", "4", "5",
                "6", "7", "8");
        assertTrue("It does have the same shelter name", shelterName.equals(testName));
        testName = new Shelter("1", "Shelter Sally", "2", "3", "4", "5",
                "6", "7", "8");
        assertFalse("The shelter name is different from the actual one", shelterName.equals(testName));
        // Need to make sure it's true if it's the same shelter shelterName.equals(shelterName)
        // Need to make sure if it's a shelter with a different name, it's false. Make up something new
        //with this one.
    }

}