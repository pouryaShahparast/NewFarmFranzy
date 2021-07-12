package model;

import model.animals.DomesticatedAnimal;

import java.util.ArrayList;

public class Grass {
    private int xCoordinate;
    private int yCoordinate;

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
    public Grass(int xLocation, int yLocation) {
        this.xCoordinate = xLocation;
        this.yCoordinate = yLocation;
        GameFieldStorage.grassHashSet.add(this);
    }
}
