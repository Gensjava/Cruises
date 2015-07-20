package ua.com.it_st.cruises.models;

/**
 * Created by Gens on 20.07.2015.
 */
public class Leg {
    private Location mOrigin;
    private Location mDestination;
    private Route mRoute;
    private boolean mModified;

    public Leg(final Location origin, final Location destination, final Route route, final boolean modified) {
        mOrigin = origin;
        mDestination = destination;
        mRoute = route;
        mModified = modified;
    }

    public Leg(final Route route) {
        mRoute = route;
    }

    public Location getOrigin() {
        return mOrigin;
    }

    public void setOrigin(final Location origin) {
        if (!origin.equals(mOrigin)){
            mModified = !origin.equals(mOrigin);
        }
        mOrigin = origin;

    }

    public Location getDestination() {
        return mDestination;
    }

    public void setDestination(final Location destination) {
        if (!destination.equals(mDestination)){
            mModified = true;
        }
        mDestination = destination;

    }

    public Route getRoute() {
        return mRoute;
    }

    public void setRoute(final Route route) {
        if (!route.equals(mRoute)){
            mModified = true;
        }
        mRoute = route;
    }

    public boolean isModified() {
        return mModified;
    }

    public void setModified(final boolean modified) {
        mModified = modified;
    }
}
