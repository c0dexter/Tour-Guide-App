package com.example.dobry.tourguideapp;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * {@link Fragment} that displays a list of parks
 */
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);


        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_planty), 50.059899, 19.942220, R.drawable.planty_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_jordan_park), 50.063407, 19.916266, R.drawable.jordans_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_bednarski), 50.041744, 19.948039, R.drawable.bednarski_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_enchanted_cab), 50.086772, 19.966235, R.drawable.enchanted_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_shooting), 50.065870, 19.950161, R.drawable.shooting_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_polish_aviators), 50.070254, 19.993347, R.drawable.polish_aviators_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_debnicki), 50.049718, 19.917060, R.drawable.debnicki_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_plaszow_garden_river), 50.048889, 19.993295, R.drawable.river_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_lilli_wenedy), 50.020567, 20.00270, R.drawable.lilii_wenedy_park));
        places.add(new Place(getString(R.string.city_park), getString(R.string.city_park_nh_meadow), 50.067355, 20.035850,R.drawable.nowa_huta_meadow));


        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_parks);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to open google maps when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                double longitude = places.get(position).getmPalceLongitude();
                double latitude = places.get(position).getmPlaceLatitude();


                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                try {
                    getContext().startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    try {
                        Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        startActivity(unrestrictedIntent);
                    } catch (ActivityNotFoundException innerEx) {
                        Toast.makeText(getContext(), R.string.no_map_app_message, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        return rootView;
    }

}