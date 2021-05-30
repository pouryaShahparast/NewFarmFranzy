package model.animals;


import model.GameFieldStorage;
import model.commodities.Commodity;

import java.util.HashSet;
import java.util.Random;

public class Tiger extends WildAnimal{
    public static final int TIGER_CAGES_NEEDED = 4;
    public static final int TIGER_SELL_PRICE = 500;
    public MOVE_DIRECTIONS lastMoveDirection;
    public Tiger() {
        super();
        animalName = "Tiger";
    }

    @Override
    public boolean addCage() {
        if(!isCaged){
            currentCageNumber++;
            if(currentCageNumber >= TIGER_CAGES_NEEDED){
                isCaged = true;
            }
            isCagedInThisRound = true;
            return true;
        }
        return false;
    }
    @Override
    public void move() {
        Random random = new Random();
        boolean canMove = false;
        while (!canMove){
            int a = random.nextInt(4);
            switch (a){
                case 0:
                    if(xCoordinate - 2 >= 0){
                        xCoordinate -= 2;
                        lastMoveDirection = MOVE_DIRECTIONS.LEFT;
                        canMove = true;
                    }
                    break;
                case 1:
                    if(xCoordinate + 2 < 6){
                        xCoordinate += 2;
                        lastMoveDirection = MOVE_DIRECTIONS.RIGHT;
                        canMove = true;
                    }
                    break;
                case 2:
                    if (yCoordinate - 2 >= 0){
                        yCoordinate -= 2;
                        lastMoveDirection = MOVE_DIRECTIONS.UP;
                        canMove = true;
                    }
                    break;
                case 3:
                    if (yCoordinate + 2 < 6){
                        yCoordinate += 2;
                        lastMoveDirection = MOVE_DIRECTIONS.DOWN;
                        canMove = true;
                    }
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return animalName + " " + (TIGER_CAGES_NEEDED - currentCageNumber) + " " +"[" + (xCoordinate + 1) + " " + (yCoordinate + 1) + "]";
    }

    public void attackDomesticatedAnimals(){
        normalAttackDomesticatedAnimals();
        switch (lastMoveDirection) {
            case UP -> normalAttackDomesticatedAnimalsUp();
            case DOWN -> normalAttackDomesticatedAnimalsDown();
            case LEFT -> normalAttackDomesticatedAnimalsLeft();
            case RIGHT -> normalAttackDomesticatedAnimalsRight();
        }
    }

    private void normalAttackDomesticatedAnimals(){
        HashSet<DomesticatedAnimal> removedDomesticatedAnimals = new HashSet<>();
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            if((xCoordinate == domesticatedAnimal.getXCoordinate()) && (yCoordinate == domesticatedAnimal.getYCoordinate())){
                removedDomesticatedAnimals.add(domesticatedAnimal);
            }
        }
        for (DomesticatedAnimal removedDomesticatedAnimal : removedDomesticatedAnimals) {
            GameFieldStorage.domesticatedAnimalHashSet.remove(removedDomesticatedAnimal);
        }
    }
    private void normalAttackDomesticatedAnimalsLeft(){
        HashSet<DomesticatedAnimal> removedDomesticatedAnimals = new HashSet<>();
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            if((xCoordinate + 1 == domesticatedAnimal.getXCoordinate()) && (yCoordinate == domesticatedAnimal.getYCoordinate())){
                removedDomesticatedAnimals.add(domesticatedAnimal);
            }
        }
        for (DomesticatedAnimal removedDomesticatedAnimal : removedDomesticatedAnimals) {
            GameFieldStorage.domesticatedAnimalHashSet.remove(removedDomesticatedAnimal);
        }
    }
    private void normalAttackDomesticatedAnimalsRight(){
        HashSet<DomesticatedAnimal> removedDomesticatedAnimals = new HashSet<>();
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            if((xCoordinate - 1 == domesticatedAnimal.getXCoordinate()) && (yCoordinate == domesticatedAnimal.getYCoordinate())){
                removedDomesticatedAnimals.add(domesticatedAnimal);
            }
        }
        for (DomesticatedAnimal removedDomesticatedAnimal : removedDomesticatedAnimals) {
            GameFieldStorage.domesticatedAnimalHashSet.remove(removedDomesticatedAnimal);
        }
    }
    private void normalAttackDomesticatedAnimalsDown(){
        HashSet<DomesticatedAnimal> removedDomesticatedAnimals = new HashSet<>();
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            if((xCoordinate == domesticatedAnimal.getXCoordinate()) && (yCoordinate - 1 == domesticatedAnimal.getYCoordinate())){
                removedDomesticatedAnimals.add(domesticatedAnimal);
            }
        }
        for (DomesticatedAnimal removedDomesticatedAnimal : removedDomesticatedAnimals) {
            GameFieldStorage.domesticatedAnimalHashSet.remove(removedDomesticatedAnimal);
        }
    }
    private void normalAttackDomesticatedAnimalsUp(){
        HashSet<DomesticatedAnimal> removedDomesticatedAnimals = new HashSet<>();
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            if((xCoordinate == domesticatedAnimal.getXCoordinate()) && (yCoordinate + 1 == domesticatedAnimal.getYCoordinate())){
                removedDomesticatedAnimals.add(domesticatedAnimal);
            }
        }
        for (DomesticatedAnimal removedDomesticatedAnimal : removedDomesticatedAnimals) {
            GameFieldStorage.domesticatedAnimalHashSet.remove(removedDomesticatedAnimal);
        }
    }

    public void attackCommodities(){
        normalAttackCommodities();
        switch (lastMoveDirection) {
            case RIGHT -> normalAttackCommoditiesRight();
            case LEFT -> normalAttackCommoditiesLeft();
            case DOWN -> normalAttackCommoditiesDown();
            case UP -> normalAttackCommoditiesUp();
        }
    }

    private void normalAttackCommodities(){
        HashSet<Commodity> removedCommodities = new HashSet<>();
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            if((xCoordinate == commodity.getXCoordinate()) && (yCoordinate == commodity.getYCoordinate())){
                removedCommodities.add(commodity);
            }
        }
        for (Commodity removedCommodity : removedCommodities) {
            GameFieldStorage.commodityHashSet.remove(removedCommodity);
        }
    }
    private void normalAttackCommoditiesLeft(){
        HashSet<Commodity> removedCommodities = new HashSet<>();
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            if((xCoordinate + 1 == commodity.getXCoordinate()) && (yCoordinate == commodity.getYCoordinate())){
                removedCommodities.add(commodity);
            }
        }
        for (Commodity removedCommodity : removedCommodities) {
            GameFieldStorage.commodityHashSet.remove(removedCommodity);
        }
    }
    private void normalAttackCommoditiesRight(){
        HashSet<Commodity> removedCommodities = new HashSet<>();
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            if((xCoordinate - 1 == commodity.getXCoordinate()) && (yCoordinate == commodity.getYCoordinate())){
                removedCommodities.add(commodity);
            }
        }
        for (Commodity removedCommodity : removedCommodities) {
            GameFieldStorage.commodityHashSet.remove(removedCommodity);
        }
    }
    private void normalAttackCommoditiesDown(){
        HashSet<Commodity> removedCommodities = new HashSet<>();
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            if((xCoordinate == commodity.getXCoordinate()) && (yCoordinate - 1 == commodity.getYCoordinate())){
                removedCommodities.add(commodity);
            }
        }
        for (Commodity removedCommodity : removedCommodities) {
            GameFieldStorage.commodityHashSet.remove(removedCommodity);
        }
    }
    private void normalAttackCommoditiesUp(){
        HashSet<Commodity> removedCommodities = new HashSet<>();
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            if((xCoordinate == commodity.getXCoordinate()) && (yCoordinate + 1 == commodity.getYCoordinate())){
                removedCommodities.add(commodity);
            }
        }
        for (Commodity removedCommodity : removedCommodities) {
            GameFieldStorage.commodityHashSet.remove(removedCommodity);
        }
    }

}
