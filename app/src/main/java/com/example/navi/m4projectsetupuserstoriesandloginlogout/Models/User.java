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

}
