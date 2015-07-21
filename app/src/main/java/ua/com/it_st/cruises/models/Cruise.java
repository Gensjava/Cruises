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

    public boolean onCheckOriginCruise() {
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

    //делаем запись Origin круиза
    //Origin круиза - это Origin 1-го перехода
    //Location sOrigin координаты  Origin круиза.

    public Leg onSetOriginCruise(Location sOrigin) {

        Leg leg = null;
        if (mListLeg != null) {
            if (mListLeg.size() != 0) {
                leg = mListLeg.get(0);
                leg.setOrigin(sOrigin);
            }
        }
        return leg;
    }

    //проверка, показывать или нет Destination круиза
    //Показывается только если существует Leg без Destination.
    //boolean cDestination true - показываем false - не покакзываем.

    public boolean onCheckDestination () {
        boolean cDestination = false;

        if (mListLeg != null){
            if (mListLeg.size() != 0){
                for (byte x = 0; x < mListLeg.size(); x++){
                    final Leg leg = mListLeg.get(x);
                    if (leg != null){
                        cDestination = leg.getDestination() == null;
                        if (!cDestination){
                            break;
                        }
                    }
                }
            }
        }
        return cDestination;
    }

    //делаем запись Destination
    //Leg leg переход в котором Destination = null.
    //Location sDestination координаты

    public Leg onSetDestination(Leg leg, Location sDestination) {

        if (leg != null){
            leg.setDestination(sDestination);
        }
        return leg;
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

    //делаем новый Leg и его Destination
    //Location sDestination координаты

    public Leg onAddDestination (Location sDestination) {
        if (sDestination != null){
            return new Leg(sDestination);
        }

        return null;
    }
}
