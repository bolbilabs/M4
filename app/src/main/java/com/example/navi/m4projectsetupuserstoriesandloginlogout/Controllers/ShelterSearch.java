package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.Shelter;


/**
 * Created by dodo on 3/5/18.
 */

public final class ShelterSearch {

    private ShelterSearch() {
        //do not use
    }

    // see if shelter should be included in filtered list or
    public static boolean filterShelter(String charText, Shelter s) {
        charText = charText.toLowerCase();
        String res = s.getRestrictions();

        //modify charText
        if (charText.equals("men"))
            charText = "male";
        if (charText.equals("women"))
            charText = "female";
        if (charText.equals("families with newborns") || charText.equals("families w/ children under 5"))
            charText = "families w/ newborns";
        if (charText.equals("child"))
            charText = "children";
        if (charText.equals("young adult"))
            charText = "young adults";

        switch (charText) {
            case "male":
                return res.contains("men") || res.contains("male") || res.contains("anyone");
            case "female":
                return res.contains("women") || res.contains("female") || res.contains("anyone");
            case "families w/ newborns":
                return res.contains("families w/ newborns") || res.contains("families w/ children under 5")
                        || res.contains("families") || res.contains("anyone");
            case "children":
                return ((res.contains("children") || res.contains("families")) && !(res.contains("families w/ newborns")
                        || res.contains("families w/ children under 5"))) || res.contains("anyone");
            case "young adults":
                return res.contains("anyone") || res.contains("young adults");
            case "anyone":
                return true;
            default:
                return s.getName().equals(charText);
        }
    }
    
}
