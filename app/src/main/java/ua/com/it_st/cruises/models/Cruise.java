package ua.com.it_st.cruises.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gens on 20.07.2015.
 */
public class Cruise {
    private List<Leg> mListLeg = new ArrayList();
    private boolean mModified;

    public Cruise(final List<Leg> listLeg, final boolean modified) {
        mListLeg = listLeg;
        mModified = modified;
    }

    public boolean isModified() {
        return mModified;
    }

    public void setModified(final boolean modified) {
        mModified = modified;
    }

    public List<Leg> getListLeg() {
        return mListLeg;
    }

    public void setListLeg(final List<Leg> listLeg) {
        if (!listLeg.equals(mListLeg)){
            mModified = true;
        }
        mListLeg = listLeg;
    }

    //проверка, показывать или нет Origin круиза
    //Origin круиза - это Origin 1-го перехода
    //boolean cOrigin true - показываем false - не покакзываем.

    public boolean onCheckSetOrigin() {
        boolean cOrigin = false;

        if (mListLeg != null){
            if (mListLeg.size() == 0){
                cOrigin = true;
            }else {
                final Leg leg = mListLeg.get(0);
                cOrigin = leg.getOrigin() == null;
            }
        }
        return cOrigin;
    }

    //проверка, показывать или нет Destination круиза
    //Показывается только если существует Leg без Destination.
    //boolean cDestination true - показываем false - не покакзываем.

    public boolean onCheckSetDestination () {
        boolean cDestination = false;

        if (mListLeg != null){
            if (mListLeg.size() == 0){
                cDestination = true;
            }else {
                final Leg leg = mListLeg.get(0);
                if (leg != null){
                    cDestination = leg.getDestination() == null;
                }
            }
        }
        return cDestination;
    }

    //проверка, показывать или нет AddDestination круиза
    //Показывается только если во всех Leg(s) Destination задан.
    //boolean cAddDestination true - показываем false - не покакзываем.

    public boolean onCheckAddDestination  () {
        boolean cAddDestination = false;

        if (mListLeg != null) {
            if (mListLeg.size() != 0){
                for (byte x = 0; x < mListLeg.size(); x++){
                    final Leg leg = mListLeg.get(x);
                    cAddDestination = leg.getDestination() != null;
                    if (!cAddDestination){
                        break;
                    }
                }
            }
        }
        return cAddDestination;
    }
}
