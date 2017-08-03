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
 * {@link Fragment} that displays a list of monuments
 */
public class MonumentsFragment extends Fragment {


    public MonumentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);


        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.castle), getString(R.string.wawel_royal_castle), getString(R.string.wewel_royal_castle_address_monument), getString(R.string.wewel_royal_castle_phone_monument), 50.054041, 19.935420, R.drawable.wawel_castle_monument));
        places.add(new Place(getString(R.string.main_square), getString(R.string.main_square_in_cracow_monument), 50.053032, 19.33574, R.drawable.main_square_monument));
        places.add(new Place(getString(R.string.historical_museum), getString(R.string.underground_of_main_square_museum_monument), getString(R.string.underground_of_main_square_museum_address_monument), getString(R.string.underground_of_main_square_museum_phone_monument), 50.061596, 19.937331, R.drawable.underground_of_mainsquare_monument));
        places.add(new Place(getString(R.string.church), getString(R.string.st_marys_church_monument), getString(R.string.st_marys_church_address_monument), getString(R.string.st_marys_church_phone_monument), 50.061586, 19.939422, R.drawable.st_marys_church_monument));
        places.add(new Place(getString(R.string.historical_street), getString(R.string.grodzka_street_monument), 50.057681, 19.938096, R.drawable.grodzka_street_monument));
        places.add(new Place(getString(R.string.church), getString(R.string.church_peter_and_paul), getString(R.string.church_peter_and_paul_address_monument), getString(R.string.church_peter_and_paul_phone_monument), 50.056924, 19.939167, R.drawable.church_perer_paul_monument));
        places.add(new Place(getString(R.string.historical_building), getString(R.string.barbican_monument), 50.065437, 19.941672, R.drawable.babrbican_monument));
        places.add(new Place(getString(R.string.historical_building), getString(R.string.town_hall_tower_monument), getString(R.string.town_hall_tower_address_monument), getString(R.string.town_hall_tower_phone_monument), 50.061412, 19.936543, R.drawable.town_hall_tower_monument));
        places.add(new Place(getString(R.string.historical_building), getString(R.string.schindler_factory_monument), getString(R.string.schindler_factory_address_monument), getString(R.string.schindler_factory_phone_monument), 50.047388, 19.961835, R.drawable.schindler_factory_monument));
        places.add(new Place(getString(R.string.church), getString(R.string.old_synagogue_monument), getString(R.string.old_synagogue_address_monument), getString(R.string.old_synagogue_phone_monument), 50.051446, 19.948583, R.drawable.old_synagogue_monument));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_monuments);
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