package model.commodities;

import model.GameFieldStorage;

public abstract class Commodity {
    int turnsInField;
    int xCoordinate;
    int yCoordinate;
    String commodityName;
    public void addTurnsInField(){
        if(turnsInField >= 0) {
            turnsInField++;
        }
    }
    public int getTurnsInField() {
        return turnsInField;
    }

    public void setTurnsInField(int turnsInField) {
        this.turnsInField = turnsInField;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void storeCommodityChanges(){
        xCoordinate = -1;
        yCoordinate = -1;
        turnsInField = -1;
    }

    public abstract boolean maxTurnsInfieldReached();
    public boolean removeFromGameFieldIfTurnsReached(){
        if(maxTurnsInfieldReached()){
            return GameFieldStorage.commodityHashSet.remove(this);
        }
        return false;
    }

    public Commodity(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.turnsInField = 0;
    }

    @Override
    public String toString() {
        return commodityName + " [" + (xCoordinate + 1) + " " + (yCoordinate + 1) + "]";
    }
}
