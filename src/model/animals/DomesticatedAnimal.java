package model.animals;

import model.Cell;
import model.GameFieldStorage;
import model.Grass;
import model.commodities.PrimitiveCommodity;

import java.util.ArrayList;
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
    @Override
    public void shortTick() {
        getCurrentAnimation().tick();
        move();
    }

    @Override
    public void longTick() {
        reduceHealth();
//    GameFieldStorage.domesticatedAnimalHashSet.removeIf(domesticatedAnimal -> domesticatedAnimal.getHealth() <= 0);
        ProduceWithTurns();
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

    public boolean eat(){
        if(health < 50) {
            health = 100;
            return true;
        }
        return false;
    }
    void normalMove(){
        randomMove();
    }

    protected void findDirection(Grass grass){
        if ((xInRang(grass.getXCoordinate()))&& (!yInRang(grass.getYCoordinate()))) {
            if (grass.getYCoordinate() > yCoordinate) {
                direction = MOVE_DIRECTIONS.DOWN;
            } else {
                direction = MOVE_DIRECTIONS.UP;
            }
        } else if ((!xInRang(grass.getXCoordinate())) && (yInRang(grass.getYCoordinate()))) {
            if (grass.getXCoordinate() > xCoordinate) {
                direction = MOVE_DIRECTIONS.RIGHT;
            } else {
                direction = MOVE_DIRECTIONS.LEFT;
            }
        } else if ((!xInRang(grass.getXCoordinate())) && (!yInRang(grass.getYCoordinate()))) {
            Random random = new Random();
            int a = random.nextInt(100);
            if (a > 50) {
                if (grass.getYCoordinate() > yCoordinate) {
                    direction = MOVE_DIRECTIONS.DOWN;
                } else {
                    direction = MOVE_DIRECTIONS.UP;
                }
            } else {
                if (grass.getXCoordinate() > xCoordinate) {
                    direction = MOVE_DIRECTIONS.RIGHT;
                } else {
                    direction = MOVE_DIRECTIONS.LEFT;
                }
            }
        }
    }
    public void move() {
        Grass grass = findNearestGrass(GameFieldStorage.grassHashSet);
        if((grass == null) || (health >50)){
            normalMove();
        }else {
            findDirection(grass);
            moving();
        }
    }
    Grass findNearestGrass(HashSet<Grass> grassHashSet) {
        double minDistance = -1;
        Grass grass = null;
        if(grassHashSet.isEmpty()){
            return null;
        }
        for (Grass grass1 : grassHashSet) {
            double distance = Math.sqrt(Math.pow(xCoordinate - grass1.getXCoordinate(), 2) + Math.pow(yCoordinate - grass1.getYCoordinate(), 2));
            if ((minDistance == -1) || (minDistance > distance)) {
                minDistance = distance;
                grass = grass1;
            }
        }
        return grass;
    }

    @Override
    public String toString() {
        return animalName + " " + health + " " + "[" + (xCoordinate + 1) + " " + (yCoordinate + 1) +"]";
    }

    //statics

    public static void domesticatedAnimalEat(){
        for (int i = 0; i < Cell.worldCells.length; i++) {
            for (int i1 = 0; i1 < Cell.worldCells[i].length; i1++) {
                DomesticatedAnimal domesticatedAnimal = whichAnimalEats(Cell.worldCells[i][i1].getDomesticatedAnimals());
                if(domesticatedAnimal != null){
                    if(domesticatedAnimal.eat()){
                        Cell.worldCells[i][i1].removeGrass();
                    }
                }
            }
        }

    }
    private static DomesticatedAnimal whichAnimalEats(ArrayList<DomesticatedAnimal> domesticatedAnimalArrayList){
        if(!domesticatedAnimalArrayList.isEmpty()){
            int tern = 0;
            int health = domesticatedAnimalArrayList.get(0).getHealth();
            for (int i = 0; i < domesticatedAnimalArrayList.size(); i++) {
                if(domesticatedAnimalArrayList.get(i).getHealth() < health){
                    tern = i;
                    health = domesticatedAnimalArrayList.get(i).getHealth();
                }
            }
            if(health < 50) {
                return domesticatedAnimalArrayList.get(tern);
            }
        }
        return null;
    }
}
