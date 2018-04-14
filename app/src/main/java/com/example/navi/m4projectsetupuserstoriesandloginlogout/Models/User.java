package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

/**
 * Created by dfriedman32 on 3/18/18.
 *
 * class representing a User
 */

public class User {

    private static String username;
    private static int admin;
    private static int reservedBeds;
    private static int reservedShelterID;

    /**
     * sets variables to more understandable names
     * @param u for username
     * @param a for admin
     * @param rb for reservedBeds
     * @param sid for reservedShelterID
     */
    public User (String u, int a, int rb, int sid) {
        username = u;
        admin = a;
        reservedBeds = rb;
        reservedShelterID = sid;
    }

    /**
     * @return username
     */
    public static String getUsername() {return username;}

    /**
     * @return admin
     */
    public static int getAdmin() {return admin;}

    /**
     * @return reservedBeds
     */
    public static int getReservedBeds() {return reservedBeds;}

    /**
     * @return reservedShelterID
     */
    public static int getReservedShelterID() { return reservedShelterID; }

    /**
     *
     * @param bedNum number of beds
     */
    public static void setReservedBeds(int bedNum) {
        reservedBeds = bedNum;
    }

    /**
     *
     * @param shelterID the shelter ID
     */
    public static void setReservedShelterID(int shelterID) {
        reservedShelterID = shelterID;
    }

    /**
     *
     * @return if the reserved beds requested is logistically possible
     */
    public boolean isReserveValid() {
        return ((reservedBeds > 0) && (reservedBeds < 7));
    }
    /**
     * returns a message to use for the invalid reserve
     * @return the message
     */
    public String invalidReserveMessage() {
        if (reservedBeds < 0) {
            reservedBeds = 0;
            return "There was a problem with our server, please try again";
        } else if (reservedBeds > 7) {
            return "You have already reserved the maximum amount of beds "
                + "possible, please release your beds before reserving"
                + " more.";
        } else if (reservedShelterID != 0) {
            return "You may only reserve beds from 1 shelter at a time, "
                + "please release your beds before reserving more.";
        } else {
            return "You should have been able to reserve a bed, this "
                + "message should never be shown.";
        }

    }

}
