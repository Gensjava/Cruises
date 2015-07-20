package ua.com.it_st.cruises.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gens on 20.07.2015.
 */
public class Route {
    private List<WayPoints> mListWayPoints = new ArrayList();

    public Route(final List<WayPoints> listWayPoints) {
        mListWayPoints = listWayPoints;
    }

    public List<WayPoints> getListWayPoints() {
        return mListWayPoints;
    }

    public void setListWayPoints(final List<WayPoints> listWayPoints) {
        mListWayPoints = listWayPoints;
    }
}
