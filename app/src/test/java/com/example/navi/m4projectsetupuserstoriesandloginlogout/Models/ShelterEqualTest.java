package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dodo on 4/4/18.
 */
public class ShelterEqualTest {

    private Shelter shelterName;

    @Before
    public void setUp() throws Exception {
        shelterName = new Shelter("1", "Shelter Bob", "2", "3", "4", "5",
                "6", "7", "8");
    }

    @Test
    public void equals() throws Exception {
        assertFalse("Comparison failed for null", shelterName.equals(null));
        assertFalse("If it's not a shelter", shelterName.equals(""));
        // Need to make sure it's true if it's the same shelter shelterName.equals(shelterName)
        // Need to make sure if it's a shelter with a different name, it's false. Make up something new
        //with this one.
    }

}