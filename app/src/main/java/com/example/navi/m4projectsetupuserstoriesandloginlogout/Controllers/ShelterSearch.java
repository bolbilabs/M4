package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.Shelter;

import java.util.List;

/**
 * Created by dodo on 3/5/18.
 */

public class ShelterSearch {

    // Filter Class
    public void filter(String charText, List<Shelter> mValues) {
        charText = charText.toLowerCase();
        if (charText.length() != 0) {
            mValues.clear();
            switch (charText) {
                case "male":
                    for (Shelter s : mValues) {
                        String res = s.getRestrictions();

                        String[] tokens = res.split("/");
                        String first = tokens[0].toLowerCase();

                        if (!(first.contains("women") || first.contains("female"))) {
                            mValues.add(s);
                        }
                    }
                case "men":
                    for (Shelter s : mValues) {
                        String res = s.getRestrictions();

                        String[] tokens = res.split("/");
                        String first = tokens[0].toLowerCase();

                        if (!(first.contains("women") || first.contains("female"))) {
                            mValues.add(s);
                        }
                    }
                case "female":
                    for (Shelter s : mValues) {
                        String res = s.getRestrictions();

                        String[] tokens = res.split("/");
                        String first = tokens[0].toLowerCase();

                        if (!(first.contains("men") || first.contains("male"))) {
                            mValues.add(s);
                        }
                    }
                case "women":
                    for (Shelter s : mValues) {
                        String res = s.getRestrictions();

                        String[] tokens = res.split("/");
                        String first = tokens[0].toLowerCase();

                        if (!(first.contains("men") || first.contains("male"))) {
                            mValues.add(s);
                        }
                    }
                case "families w/ newborns":
                    for (Shelter s : mValues) {
                        String res = s.getRestrictions().toLowerCase();

                        if (res.contains("families w/ newborns") || res.contains("families w/ children under 5")) {
                            mValues.add(s);
                        }
                    }
                case "families with newborns":
                    for (Shelter s : mValues) {
                        String res = s.getRestrictions().toLowerCase();

                        if (res.contains("families w/ newborns") || res.contains("families w/ children under 5")) {
                            mValues.add(s);
                        }
                    }
                case "families w/ children under 5":
                    for (Shelter s : mValues) {
                        String res = s.getRestrictions().toLowerCase();

                        if (res.contains("families w/ newborns") || res.contains("families w/ children under 5")) {
                            mValues.add(s);
                        }
                    }
            }
        }
    }
    
}
