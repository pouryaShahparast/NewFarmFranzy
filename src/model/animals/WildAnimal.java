package model.animals;

import model.GameFieldStorage;
import model.commodities.Commodity;

import java.util.HashSet;

public abstract class WildAnimal extends Animal {
    public static final int WILD_ANIMAL_SIZE = 15;
    public static final int MAX_TURNS_AFTER_CAGED = 5;
    boolean isCaged;
    boolean isCagedInThisRound;
    int currentCageNumber;
    int turnsAfterCaged;

    public void storeWildAnimalChanges(){
        xCoordinate = -1;
        yCoordinate = -1;
        currentCageNumber = -1;
    }
    public void attackDomesticatedAnimals(){
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
    public void attackCommodities(){
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
    public boolean maxTurnsInfieldReached() {
        return turnsAfterCaged >= MAX_TURNS_AFTER_CAGED;
    }
    public boolean removeFromGameFieldIfTurnsReached(){
        if(maxTurnsInfieldReached()){
            return GameFieldStorage.wildAnimalHashSet.remove(this);
        }
        return false;
    }
    public WildAnimal() {
        super();
        this.isCaged = false;
        this.isCagedInThisRound = false;
        this.currentCageNumber =0;
        this.turnsAfterCaged = 0;
    }
    public abstract boolean addCage();
    public boolean removeCage(){
        if(!isCaged && !isCagedInThisRound) {
            if (currentCageNumber > 0) {
                currentCageNumber--;
                return true;
            }
        }
        return false;
    }
    public void setIsCagedInThisRoundAtEndOfTheRound() {
        isCagedInThisRound = false;
    }
    abstract public void move();
    public boolean addTurnsAfterCaged(){
        if(isCaged && turnsAfterCaged >= 0 ){
            turnsAfterCaged++;
            return turnsAfterCaged >= MAX_TURNS_AFTER_CAGED;
        }
        return false;
    }

}
