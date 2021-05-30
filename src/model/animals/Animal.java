package model.animals;

import java.util.Random;

abstract class Animal {
    String animalName;
    enum MOVE_DIRECTIONS{
        LEFT,RIGHT,UP,DOWN;
    }
     int xCoordinate;
     int yCoordinate;
    public Animal() {
        Random random = new Random();
        xCoordinate = random.nextInt(6);
        yCoordinate = random.nextInt(6);
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    abstract public void move();

    @Override
    public abstract String toString();
}
