package com.example.dobry.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dobry on 23.05.17.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    private int mColorResourceId;


    public PlaceAdapter(Activity context, ArrayList<Place> Place, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Place);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Get the current position
        final Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.name_place);
        assert currentPlace != null;


        // Find the TextView in the list_item.xml layout with the ID version_number (mapping)
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.place_type);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        TextView addressField = (TextView) listItemView.findViewById(R.id.place_address);
        TextView phoneField = (TextView) listItemView.findViewById(R.id.place_phone_number);


        defaultTextView.setText(currentPlace.getPlaceName());
        miwokTextView.setText(currentPlace.getItemType());


        // Show or hide ImageView
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Show or hide TextView with an address
        if (!currentPlace.getPlaceAddress().equals("")) {
            addressField.setText(currentPlace.getPlaceAddress());
            addressField.setVisibility(View.VISIBLE);
            // Otherwise hide the Address TextView (set visibility to GONE)
        } else {
            addressField.setVisibility(View.GONE);
        }

        // Show or hide TextView with phone number
        if (!currentPlace.getPhoneNumber().equals("")) {
            phoneField.setText(currentPlace.getPhoneNumber());
            phoneField.setVisibility(View.VISIBLE);
            // Otherwise hide the Phone TextView (set visibility to GONE)
        } else {
            phoneField.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }

}
