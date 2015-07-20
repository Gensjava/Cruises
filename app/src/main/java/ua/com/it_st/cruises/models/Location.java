package ua.com.it_st.cruises.models;

/**
 * Created by Gens on 20.07.2015.
 */
public class Location {
    private int mLongitude;
    private int mLatitude;

    public Location(final int longitude, final int latitude) {
        mLongitude = longitude;
        mLatitude = latitude;
    }

    public int getLongitude() {
        return mLongitude;
    }

    public void setLongitude(final int longitude) {
        mLongitude = longitude;
    }

    public int getLatitude() {
        return mLatitude;
    }

    public void setLatitude(final int latitude) {
        mLatitude = latitude;
    }
}
