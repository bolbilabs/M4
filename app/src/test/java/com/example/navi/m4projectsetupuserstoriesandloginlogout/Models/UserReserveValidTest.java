package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by dfriedman32 on 4/7/18.
 */
public class UserReserveValidTest {
    private User user;

    @Test
    public void isReserveValid() throws Exception {
        user = new User("Homer",1,0,1);
        assertFalse("Comparision Failed for 0", user.isReserveValid());
        user = new User("Bart",1,7,1);
        assertFalse("Comparision Failed for 7", user.isReserveValid());
        user = new User("Marge",1,6,1);
        assertTrue("Comparision Failed for 6", user.isReserveValid());
        user = new User("Lisa",1,1,1);
        assertTrue("Comparision Failed for 1", user.isReserveValid());
    }
}