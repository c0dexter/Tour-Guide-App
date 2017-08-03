package com.example.dobry.tourguideapp;

/**
 * Created by dobry on 08.06.17.
 */

public class Place {

    /**
     * This is type of place, i.e.: monument, restaurant, museum, park, other...
     */
    private String mItemType = "";

    /**
     * Name of place
     */
    private String mPlaceName = "";

    /**
     * Address of specific place
     */
    private String mPlaceAddress = "";

    /**
     * This is phone number for a specific place
     */
    private String mPhoneNumber = "";


    /**
     * This is longitude of specific place, can be used to displaying point on the maps
     */
    private double mPalceLongitude;


    /**
     * This is latitude of specific place, can be used to displaying point on the maps
     */
    private double mPlaceLatitude;


    /**
     * Image resource ID for the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Get place type
     *
     * @return type of specific place
     */
    String getItemType() {
        return mItemType;
    }

    /**
     * Get name of specific place
     *
     * @return name of specific place
     */
    String getPlaceName() {
        return mPlaceName;
    }

    /**
     * Get address of specific place
     *
     * @return address of specific place
     */
    String getPlaceAddress() {
        return mPlaceAddress;
    }

    /**
     * Get phone number of specific place
     *
     * @return nuber for specific place
     */
    String getPhoneNumber() {
        return mPhoneNumber;
    }

    /**
     * This coordinate value can be used for indicating point on the map
     *
     * @return longitude of specific plays
     */
    double getmPalceLongitude() {
        return mPalceLongitude;
    }

    /**
     * This coordinate value can be used for indicating point on the map
     *
     * @return latitude of specific place
     */
    double getmPlaceLatitude() {
        return mPlaceLatitude;
    }

    /**
     * @return the image resource ID of the place
     */
    int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * @return TRUE if exist an image for specify polace
     */
    boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


    Place(String itemType, String placeName, String placeAddress, String phoneNumber, double placeLatitude, double palceLongitude) {
        mItemType = itemType;
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mPhoneNumber = phoneNumber;
        mPalceLongitude = palceLongitude;
        mPlaceLatitude = placeLatitude;

    }

    Place(String itemType, String placeName, String placeAddress, String phoneNumber, double placeLatitude, double palceLongitude, int imageResourceId) {
        mItemType = itemType;
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mPhoneNumber = phoneNumber;
        mPalceLongitude = palceLongitude;
        mPlaceLatitude = placeLatitude;
        mImageResourceId = imageResourceId;

    }

    Place(String placeType, String placeName, double placeLatitude, double palceLongitude) {
        mItemType = placeType;
        mPlaceName = placeName;
        mPalceLongitude = palceLongitude;
        mPlaceLatitude = placeLatitude;

    }

    Place(String placeType, String placeName, double placeLatitude, double palceLongitude, int imageResourceId) {
        mItemType = placeType;
        mPlaceName = placeName;
        mPalceLongitude = palceLongitude;
        mPlaceLatitude = placeLatitude;
        mImageResourceId = imageResourceId;

    }
}
