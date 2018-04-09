package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

/**
 * returns the attributes of a shelter.
 *
 * created by Thomas Brownlow on 2/24/18
 */
public class Shelter {


    private String key;
    private String name;
    private String capacity;
    private String restrictions;
    private String longitude;
    private String latitude;
    private String address;
    private String notes;
    private String phoneNumber;

    /**
     * Sets understandable variables to the attributes of a shelter.
     * @param i shelter's key
     * @param na shelter's name
     * @param c shelter's capacity
     * @param r shelter's restrictions
     * @param lo shelter's longitude
     * @param la shelter's latitude
     * @param a shelter's address
     * @param no shelter's notes
     * @param p shelter's phone number
     */
    public Shelter (String i, String na, String c, String r, String lo, String la,
                    String a, String no, String p) {
        key = i;
        name = na;
        capacity = c;
        restrictions = r;
        longitude = lo;
        latitude = la;
        address = a;
        notes = no;
        phoneNumber = p;
    }

    /**
     * @return key and name of shelter as a String
     */
    public String toString() {
        return key + ", " + name;
    }

    /**
     * @return the shelter's key
     */
    public String getKey() {return key;}

    /**
     * @return the shelter's name
     */
    public String getName() {return name;}

    /**
     * @return the shelter's capacity
     */
    public String getCapacity() {return capacity;}

    /**
     * @return the shelter's restrictions (i.e. gender, family, sexual orientation)
     */
    public String getRestrictions() {return restrictions;}

    /**
     * @return the longitude coordinates of a shelter
     */
    public String getLongitude() {return longitude;}

    /**
     * @return the latitude coordinates of a shelter
     */
    public String getLatitude() {return latitude;}

    /**
     * @return shelter's address
     */
    public String getAddress() {return address;}

    /**
     * @return notes on a shelter
     */
    public String getNotes() {return notes;}

    /**
     * @return shelter phone number
     */
    public String getPhoneNumber() {return phoneNumber;}

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return o instanceof Shelter && this.name.equals(((Shelter) o).name);
    }
}