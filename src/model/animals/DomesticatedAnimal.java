package model.animals;

import model.GameFieldStorage;
import model.Grass;
import model.commodities.PrimitiveCommodity;

import java.util.HashSet;
import java.util.Random;

public abstract class DomesticatedAnimal extends Animal {
    int turns;
    int health;

    public DomesticatedAnimal() {
        super();
        health = 100;
        turns = 1;
    }

    abstract PrimitiveCommodity produce();
    public void addTurns(){
        turns++;
    }
    public abstract boolean resetTurns();
    public abstract boolean checkIfTurnsReached();
    public void ProduceWithTurns() {
        if(checkIfTurnsReached()){
            GameFieldStorage.commodityHashSet.add(produce());
            resetTurns();
        }else {
            addTurns();
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    public boolean removeIfIsDead(){
        if(getHealth() <= 0){
            GameFieldStorage.domesticatedAnimalHashSet.remove(this);
            return true;
        }
        return false;
    }
    public void reduceHealth(){
        health-= 10;
    }

    public boolean eat(Grass grass){
        if(health < 50) {
                health = 100;
                return true;
        }
        return false;
    }
    void normalMove(){
        Random random = new Random();
        boolean canMove = false;
        while (!canMove){
            int a = random.nextInt(4);
            switch (a){
                case 0:
                    if(xCoordinate - 1 >= 0){
                        xCoordinate -= 1;
                        canMove = true;
                    }
                    break;
                case 1:
                    if(xCoordinate + 1 < 6){
                        xCoordinate += 1;
                        canMove = true;
                    }
                    break;
                case 2:
                    if (yCoordinate - 1 >= 0){
                        yCoordinate -= 1;
                        canMove = true;
                    }
                    break;
                case 3:
                    if (yCoordinate + 1 < 6){
                        yCoordinate += 1;
                        canMove = true;
                    }
                    break;
            }
        }
    }
    public void move() {
        Grass grass = findNearestGrass(GameFieldStorage.grassHashSet);
        if((grass == null) || (health >50)){
            normalMove();
        }else {
            if ((grass.getXCoordinate() == xCoordinate) && (grass.getYCoordinate() != yCoordinate)) {
                if (grass.getYCoordinate() > yCoordinate) {
                    yCoordinate++;
                } else {
                    yCoordinate--;
                }
            } else if ((grass.getXCoordinate() != xCoordinate) && (grass.getYCoordinate() == yCoordinate)) {
                if (grass.getXCoordinate() > xCoordinate) {
                    xCoordinate++;
                } else {
                    xCoordinate--;
                }
            } else if ((grass.getXCoordinate() != xCoordinate) && (grass.getYCoordinate() != yCoordinate)) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    if (grass.getYCoordinate() > yCoordinate) {
                        yCoordinate++;
                    } else {
                        yCoordinate--;
                    }
                } else {
                    if (grass.getXCoordinate() > xCoordinate) {
                        xCoordinate++;
                    } else {
                        xCoordinate--;
                    }
                }
            }
        }
    }
     Grass findNearestGrass(HashSet<Grass> grassHashSet) {
        double minDistance = -1;
        Grass grass = null;
        if(grassHashSet.isEmpty()){
            return null;
        }
        for (Grass grass1 : grassHashSet) {
            if((grass1.getYCoordinate()>=0)&&(grass1.getYCoordinate()<6)&&(grass1.getXCoordinate()>=0)&&(grass1.getXCoordinate()<6)) {
                double distance = Math.sqrt(Math.pow(xCoordinate - grass1.getXCoordinate(), 2) + Math.pow(yCoordinate - grass1.getYCoordinate(), 2));
                if ((minDistance == -1) || (minDistance > distance)) {
                    minDistance = distance;
                    grass = grass1;
                }
            }
        }
        return grass;
    }

    @Override
    public String toString() {
        return animalName + " " + health + " " + "[" + (xCoordinate + 1) + " " + (yCoordinate + 1) +"]";
    }
}
