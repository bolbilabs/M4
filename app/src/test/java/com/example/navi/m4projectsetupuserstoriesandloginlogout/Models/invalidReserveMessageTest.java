package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * created by Thomas Brownlow
 *
 * Junit test for invalidReserveMessage()
 */
public class invalidReserveMessageTest {
    private User user;

    @Test
    public void invalidReserveMessage() throws Exception {
        user = new User("name", 0, -1, 1);
        assertEquals("There was a problem with our server, please try again",
            user.invalidReserveMessage());
        assertEquals(0, user.getReservedBeds());
        user.setReservedBeds(8);
        assertEquals( "You have already reserved the maximum amount of beds "
                + "possible, please release your beds before reserving"
                + " more.", user.invalidReserveMessage());
        user.setReservedBeds(6);
        assertEquals("You may only reserve beds from 1 shelter at a time, "
                + "please release your beds before reserving more.",
                user.invalidReserveMessage());
        user.setReservedShelterID(0);
        assertEquals("You should have been able to reserve a bed, this "
                + "message should never be shown.",
                user.invalidReserveMessage());
    }
}