package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

import java.util.ArrayList;

/**
 * Returns the default shelters given to us by the .csv file.
 *
 * created by Thomas Brownlow on 2/24/18
 */
public final class PreRegisteredShelters {

    /** Singleton instance */
    private static final PreRegisteredShelters _instance = new PreRegisteredShelters();

    /**
     * @return _instance the instance
     */
    public static PreRegisteredShelters getInstance() { return _instance; }

    private ArrayList<Shelter> shelters;
    private Shelter currentShelter;
    //private static final int SIZE = 13;

    private PreRegisteredShelters() {
        shelters = new ArrayList<>();
    }

    /**
     * @return shelters the shelter
     */
    public ArrayList<Shelter> getShelters() {
        return shelters;
    }

    /**
     * @return currentShelter the current shelter
     */
    public Shelter getCurrentShelter() { return currentShelter; }

    /**
     * @param course setting to new variable
     */
    public void setCurrentShelter(Shelter course) { currentShelter = course; }

    /**
     * @param shelter add shelter
     */
    public void addShelter(Shelter shelter) { shelters.add(shelter);}

    /**
     * Clear shelters from the array list.
     */
    public void clearAllShelters() { shelters.clear();}

}
