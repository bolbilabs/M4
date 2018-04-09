package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

/**
 * Created by dfriedman32 on 3/18/18.
 */

public class User {

    private static String username;
    private static int admin;
    private static int reservedBeds;
    private static int reservedShelterID;


    public User (String u, int a, int rb, int sid) {
        username = u;
        admin = a;
        reservedBeds = rb;
        reservedShelterID = sid;
    }

    public static String getUsername() {return username;}
    public static int getAdmin() {return admin;}
    public static int getReservedBeds() {return reservedBeds;}
    public static int getReservedShelterID() { return reservedShelterID; }

    public static void setReservedBeds(int bedNum) {
        reservedBeds = bedNum;
    }
    public static void setReservedShelterID(int shelterID) {
        reservedShelterID = shelterID;
    }

    public boolean isReserveValid() {
        return ((reservedBeds > 0) && (reservedBeds < 7));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return this.username.equals(((User) o).username);
    }

}
