package ua.com.it_st.cruises.models;


import java.util.Date;

/**
 * Created by Gens on 20.07.2015.
 */
public class WayPoints {
    private Location mLocation;
    private Date mDate;

    public WayPoints(final Location location, final Date date) {
        mLocation = location;
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(final Date date) {
        mDate = date;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(final Location location) {
        mLocation = location;
    }
}
