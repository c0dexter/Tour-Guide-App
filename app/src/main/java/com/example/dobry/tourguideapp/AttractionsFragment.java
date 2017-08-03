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
 * {@link Fragment} that displays a list of attractions
 */
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);


        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.legendary_area), getString(R.string.dragon_crow_attraction), 50.053122, 19.933759, R.drawable.dragon_crow_attraction)); //OK
        places.add(new Place(getString(R.string.amusement_park), getString(R.string.garden_of_experiences_attraction), 50.068647, 19.997357)); //OK
        places.add(new Place(getString(R.string.view_point), getString(R.string.viewing_platform_balloon_attraction), getString(R.string.viewing_platform_balloon_address_attraction), getString(R.string.viewing_platform_balloon_phone_number_attraction), 50.047929, 19.934001, R.drawable.balloon_view_platform_attraction)); //OK
        places.add(new Place(getString(R.string.historical_place), getString(R.string.popes_tram_attraction), 50.012803, 19.927481)); //OK
        places.add(new Place(getString(R.string.historical_place), getString(R.string.popes_window_attraction), getString(R.string.popes_window_address_attraction), getString(R.string.popes_window_phone_attraction), 50.059422, 19.935217, R.drawable.popes_window_attraction)); //OK
        places.add(new Place(getString(R.string.water_attraction), getString(R.string.cruises_vistula_attraction), getString(R.string.cruises_vistula_address_attraction), getString(R.string.cruises_vistula_phone_number_attraction), 50.050793, 19.934286, R.drawable.cruises_on_the_vistula_river_attraction)); //OK
        places.add(new Place(getString(R.string.water_attraction), getString(R.string.water_park_attraction), getString(R.string.water_park_address_attraction), getString(R.string.water_park_phone_number_attraction), 50.088929, 19.982970, R.drawable.water_park_attraction)); //OK
        places.add(new Place(getString(R.string.leisure_zone), getString(R.string.cracovian_beach_attraction), getString(R.string.cracovian_beach_attraction_address), getString(R.string.cracovian_beach_phone_number_attraction), 50.046350, 19.935282, R.drawable.cracovian_beach_attraction)); //OK
        places.add(new Place(getString(R.string.leisure_zone), getString(R.string.forum_attraction), getString(R.string.forum_address_attraction), getString(R.string.forum_phone_number_attraction), 50.045213, 19.935660, R.drawable.balloon_view_platform_attraction)); //OK
        places.add(new Place(getString(R.string.food_and_drink_zone), getString(R.string.new_square_attraction), 50.051863, 19.944866)); //OK


        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_attractions);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
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