package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.Shelter;


/**
 * Created by Kristen on 4/6/18.
 *
 * Unit test for filterShelter()
 */
public class ShelterSearchTest {

    private Shelter s;

    /**
     * test search men
     * @throws Exception throws an exception
     */
    @Test
    public void SearchMenShouldBeTrue() throws Exception {
        String searchTerm = "Men";
        s = new Shelter("33", "TestShelter", "100", "Men","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests search men
     * @throws Exception an exception
     */
    @Test
    public void SearchMenShouldBeFalse() throws Exception {
        String searchTerm = "Men";
        s = new Shelter("33", "TestShelter", "100", "Women","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests search male
     * @throws Exception an exception
     */
    @Test
    public void SearchMaleShouldBeTrue() throws Exception {
        String searchTerm = "Male";
        s = new Shelter("33", "TestShelter", "100", "Male","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests search male
     * @throws Exception an exception
     */
    @Test
    public void SearchMaleShouldBeFalse() throws Exception {
        String searchTerm = "Male";
        s = new Shelter("33", "TestShelter", "100", "Female","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests search women
     * @throws Exception exception
     */
    @Test
    public void SearchWomenShouldBeTrue() throws Exception {
        String searchTerm = "Women";
        s = new Shelter("33", "TestShelter", "100", "Women","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests search women
     * @throws Exception an exception
     */
    @Test
    public void SearchWomenShouldBeFalse() throws Exception {
        String searchTerm = "Women";
        s = new Shelter("33", "TestShelter", "100", "Men","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests search female
     * @throws Exception an exception
     */
    @Test
    public void SearchFemaleShouldBeTrue() throws Exception {
        String searchTerm = "Female";
        s = new Shelter("33", "TestShelter", "100", "Female","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests search female
     * @throws Exception an exception
     */
    @Test
    public void SearchFemaleShouldBeFalse() throws Exception {
        String searchTerm = "female";
        s = new Shelter("33", "TestShelter", "100", "Male","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests families with newborns
     * @throws Exception an exception
     */
    @Test
    public void SearchFamiliesWithNewbornsShouldBeTrue() throws Exception {
        String searchTerm = "families with newborns";
        s = new Shelter("33", "TestShelter", "100", "families with newborns","1","2", "address",
                "notes", "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests families with newborns
     * @throws Exception  an exception
     */
    @Test
    public void SearchFamiliesWithNewbornsShouldBeFalse() throws Exception {
        String searchTerm = "families with newborns";
        s = new Shelter("33", "TestShelter", "100", "Women","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests children under 5
     * @throws Exception an exception
     */
    @Test
    public void SearchFamiliesWChildrenUnder5ShouldBeTrue() throws Exception {
        String searchTerm = "families w/ children under 5";
        s = new Shelter("33", "TestShelter", "100", "families w/ children under 5","1","2",
                "address", "notes", "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests children under 5
     * @throws Exception an exception
     */
    @Test
    public void SearchFamiliesWChildrenUnder5ShouldBeFalse() throws Exception {
        String searchTerm = "families w/ children under 5";
        s = new Shelter("33", "TestShelter", "100", "Women","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests newborns
     * @throws Exception an exception
     */
    @Test
    public void SearchFamiliesWNewbornsShouldBeTrue() throws Exception {
        String searchTerm = "families w/ newborns";
        s = new Shelter("33", "TestShelter", "100", "families w/ newborns","1",
                "2", "address", "notes", "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests newborns
     * @throws Exception an exception
     */
    @Test
    public void SearchFamiliesWNewbornsShouldBeFalse() throws Exception {
        String searchTerm = "families w/ newborns";
        s = new Shelter("33", "TestShelter", "100", "Women","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests search child
     * @throws Exception an exception
     */
    @Test
    public void SearchChildShouldBeTrue() throws Exception {
        String searchTerm = "child";
        s = new Shelter("33", "TestShelter", "100", "Children","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests search child
     * @throws Exception an exception
     */
    @Test
    public void SearchChildShouldBeFalse() throws Exception {
        String searchTerm = "child";
        s = new Shelter("33", "TestShelter", "100", "women","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests children
     * @throws Exception an exception
     */
    @Test
    public void SearchChildrenShouldBeTrue() throws Exception {
        String searchTerm = "children";
        s = new Shelter("33", "TestShelter", "100", "Children","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests children
     * @throws Exception an exception
     */
    @Test
    public void SearchChildrenShouldBeFalse() throws Exception {
        String searchTerm = "children";
        s = new Shelter("33", "TestShelter", "100", "men","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests young adult
     * @throws Exception an exception
     */
    @Test
    public void SearchYoungAdultShouldBeTrue() throws Exception {
        String searchTerm = "young adult";
        s = new Shelter("33", "TestShelter", "100", "young adults","1","2", "address",
                "notes", "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests young adult
     * @throws Exception an exception
     */
    @Test
    public void SearchYoungAdultShouldBeFalse() throws Exception {
        String searchTerm = "young adult";
        s = new Shelter("33", "TestShelter", "100", "men","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests young adult
     * @throws Exception an exception
     */
    @Test
    public void SearchYoungAdultsShouldBeTrue() throws Exception {
        String searchTerm = "young adults";
        s = new Shelter("33", "TestShelter", "100", "young adults","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests young adult
     * @throws Exception an exception
     */
    @Test
    public void SearchYoungAdultsShouldBeFalse() throws Exception {
        String searchTerm = "young adults";
        s = new Shelter("33", "TestShelter", "100", "men","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

    /**
     * tests anyone
     * @throws Exception an exception
     */
    @Test
    public void SearchAnyoneShouldBeTrue() throws Exception {
        String searchTerm = "anyone";
        s = new Shelter("33", "TestShelter", "100", "young adults","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests shelter name search
     * @throws Exception an exception
     */
    @Test
    public void SearchShelterNameShouldBeTrue() throws Exception {
        String searchTerm = "testshelter";
        s = new Shelter("33", "TestShelter", "100", "young adults","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertTrue("Result should be true", result);
    }

    /**
     * tests search shelter name
     * @throws Exception an exception
     */
    @Test
    public void SearchShelterNameShouldBeFalse() throws Exception {
        String searchTerm = "randomName";
        s = new Shelter("33", "TestShelter", "100", "young adults","1","2", "address", "notes",
                "phoneNumber");
        boolean result = ShelterSearch.filterShelter(searchTerm, s);
        assertFalse("Result should be false", result);
    }

}