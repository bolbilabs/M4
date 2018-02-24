package com.example.navi.m4projectsetupuserstoriesandloginlogout.Models;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
/**
 * created by Thomas Brownlow on 2/24/18
 */
public class preRegisteredShelters {

    private List<Shelter> shelters;
    private static final int SIZE = 13;

    public preRegisteredShelters() {
        shelters = new ArrayList<Shelter>();
        readFile();
    }
    private void readFile() {
        File file = new File("homeless_shelter_database.csv");
        try {
            Scanner scan = new Scanner(file);
            String line;
            Shelter temp;
            scan.nextLine(); //throw out first line
            while (scan.hasNext()) {
                line = scan.nextLine();
                String[] tokens = line.split(",");
                temp = new Shelter(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4],
                                    tokens[5], tokens[6], tokens[7], tokens[8]);
                shelters.add(temp);
            }
        } catch (IOException e) {

        }
    }
    public List<Shelter> getShelters() {
        return shelters;
    }
}