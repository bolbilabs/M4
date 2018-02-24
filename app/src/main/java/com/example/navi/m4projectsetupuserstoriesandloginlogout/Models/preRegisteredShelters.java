package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
public class preRegisteredShelters {

    private String[] allData;
    private List<Shelter> shelters;
    private static final int SIZE = 13;
    private static final int NUM_FIELDS = 9;

    public preRegisteredShelters() {
        allData = new String[SIZE * NUM_FIELDS + 1];
        readFile();
    }
    public void readFile() {
        File file = new File("homeless_shelter_database.csv");
        try {
            Scanner scanner = new Scanner(file);
        } catch (IOException e) {

        }
    }
}