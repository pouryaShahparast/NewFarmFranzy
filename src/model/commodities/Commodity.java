package model.commodities;

import model.GameFieldStorage;

import java.awt.*;

public abstract class Commodity {
    public static final int WIDTH = 25;
    public static final int HEIGHT = 25;
    int turnsInField;
    int xCoordinate;
    int yCoordinate;
    Rectangle bounds;
    String commodityName;
    public void addTurnsInField(){
        if(turnsInField >= 0) {
            turnsInField++;
        }
    }
    public abstract void render(Graphics graphics);
    public abstract void tick();
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
        bounds = new Rectangle(xCoordinate , yCoordinate ,WIDTH , HEIGHT );
    }

    @Override
    public String toString() {
        return commodityName + " [" + (xCoordinate + 1) + " " + (yCoordinate + 1) + "]";
    }

    //getters

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public String getCommodityName() {
        return commodityName;
    }
}
