package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;


import java.util.ArrayList;

/**
 * created by Thomas Brownlow on 2/24/18
 */
public class PreRegisteredShelters {

    /** Singleton instance */
    private static final PreRegisteredShelters _instance = new PreRegisteredShelters();
    public static PreRegisteredShelters getInstance() { return _instance; }

    private ArrayList<Shelter> shelters;
    private Shelter currentShelter;
    private static final int SIZE = 13;

    public PreRegisteredShelters() {
        shelters = new ArrayList<Shelter>();
    }


    public ArrayList<Shelter> getShelters() {
        return shelters;
    }

    public Shelter getCurrentShelter() { return currentShelter; }

    public void setCurrentShelter(Shelter course) { currentShelter = course; }

    public void addShelter(Shelter shelter) { shelters.add(shelter);}

    public void clearAllShelters() { shelters.clear();}

}
