package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

/**
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
    public String toString() {
        return key + ", " + name;
    }
    public String getKey() {return key;}
    public String getName() {return name;}
    public String getCapacity() {return capacity;}
    public String getRestrictions() {return restrictions;}
    public String getLongitude() {return longitude;}
    public String getLatitude() {return latitude;}
    public String getAddress() {return address;}
    public String getNotes() {return notes;}
    public String getPhoneNumber() {return phoneNumber;}

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return o instanceof Shelter && this.name.equals(((Shelter) o).name);
    }
}