package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.Shelter;

final class ShelterSearch {

    private ShelterSearch() {
        //do not use
    }

    // see if shelter should be included in filtered list
    static boolean filterShelter(String text, Shelter s) {
        String charText = text.toLowerCase();
        String res = s.getRestrictions().toLowerCase();

        //modify charText
        if ("men".equals(charText)) {
            charText = "male";
        }
        if ("women".equals(charText)) {
            charText = "female";
        }
        if ("families with newborns".equals(charText)
                || "families w/ children under 5".equals(charText)) {
            charText = "families w/ newborns";
        }
        if ("child".equals(charText)) {
            charText = "children";
        }
        if ("young adult".equals(charText)) {
            charText = "young adults";
        }

        switch (charText) {
            case "male":
                return ((res.contains("men") && !res.contains("women"))
                        || (res.contains("male") && !res.contains("female"))
                        || res.contains("anyone"));
            case "female":
                return res.contains("women") || res.contains("female") || res.contains("anyone");
            case "families w/ newborns":
                return res.contains("families w/ newborns")
                        || res.contains("families w/ children under 5")
                        || res.contains("families") || res.contains("anyone");
            case "children":
                return ((res.contains("children") || res.contains("families"))
                        && !(res.contains("families w/ newborns")
                        || res.contains("families w/ children under 5"))) || res.contains("anyone");
            case "young adults":
                return res.contains("anyone") || res.contains("young adults");
            case "anyone":
                return true;
            default:
                return s.getName().toLowerCase().contains(charText);
        }
    }
    
}
