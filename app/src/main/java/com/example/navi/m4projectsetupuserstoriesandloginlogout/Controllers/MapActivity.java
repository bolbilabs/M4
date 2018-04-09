package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.PreRegisteredShelters;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.Shelter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        // Associate searchable configuration with the SearchView
        SearchView searchView = (SearchView) findViewById(R.id.map_filter);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                filtering(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                filtering(query);
                return false;
            }
        });


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        final PreRegisteredShelters preRegisteredShelters = PreRegisteredShelters.getInstance();


        //iterate through the list and add a pin for each element in the model
        for (Shelter s : preRegisteredShelters.getShelters()) {
            LatLng loc = new LatLng(Double.parseDouble(s.getLatitude()), Double.parseDouble(s.getLongitude()));
            mMap.addMarker(new MarkerOptions().position(loc).title(s.getName()).snippet(s.getPhoneNumber()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc,10.0f));
        }
    }



    public void filtering(CharSequence charSequence) {
        String charString = charSequence.toString();
        PreRegisteredShelters preRegisteredShelters = PreRegisteredShelters.getInstance();
        List<Shelter> shelter_list;
        if (charString.isEmpty()) {
            shelter_list = preRegisteredShelters.getShelters();
        } else {
            List<Shelter> filteredList = new ArrayList<>();
            for (Shelter row : preRegisteredShelters.getShelters()) {
                //filter by key for testing
                            /*if (Integer.parseInt(row.getKey()) > Integer.parseInt(charString)) {
                                filteredList.add(row);
                            }*/
                if (ShelterSearch.filterShelter(charString, row)) {
                    filteredList.add(row);
                }
            }
            shelter_list = filteredList;
        }


        mMap.clear();

        for (Shelter s : shelter_list) {
            LatLng loc = new LatLng(Double.parseDouble(s.getLatitude()), Double.parseDouble(s.getLongitude()));
            mMap.addMarker(new MarkerOptions().position(loc).title(s.getName()).snippet(s.getPhoneNumber()));
        }
    }
}
