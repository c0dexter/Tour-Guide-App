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
 * {@link Fragment} that displays a list of number memorials places
 */
public class MemorialsFragment extends Fragment {


    public MemorialsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);


        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.historical_person), getString(R.string.adam_mickiewicz_memorial), 50.061431, 19.937986, R.drawable.mickiewicz_memorial));
        places.add(new Place(getString(R.string.legendary_figure), getString(R.string.wawel_dragon_memorial), 50.053032, 19.33574, R.drawable.dragon_wawelski));
        places.add(new Place(getString(R.string.historical_scene), getString(R.string.monument_of_runwald_memorial), 50.066391, 19.942156, R.drawable.grunwald_memorial));
        places.add(new Place(getString(R.string.historical_person), getString(R.string.fryderyk_chopin_monument_memorial), 50.059326, 19.934028, R.drawable.chopin_memorial));
        places.add(new Place(getString(R.string.historical_person), getString(R.string.ignacy_paderewski_monument), 50.066264, 19.950209, R.drawable.paderewski_memorial));
        places.add(new Place(getString(R.string.memorial_place), getString(R.string.monument_victim_of_nazism_memorial), 50.029137, 19.961349, R.drawable.victims_of_nazist_memorial));
        places.add(new Place(getString(R.string.historical_monument), getString(R.string.monument_armed_action_memorial), 50.055003, 19.954022, R.drawable.armed_action_memorial));
        places.add(new Place(getString(R.string.historical_monument), getString(R.string.monument_solidarity_memorial), 50.071220, 20.037065, R.drawable.solidarity_memorial));
        places.add(new Place(getString(R.string.historical_vehicle), getString(R.string.tank_nh_memorial), 50.081527, 20.036280, R.drawable.tank_memorial));
        places.add(new Place(getString(R.string.memorial_place), getString(R.string.kosciuszko_mound_memorial), 50.054930, 19.893226, R.drawable.kosciuszko_mound));


        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_memorials);
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