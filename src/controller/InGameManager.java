package controller;

import model.*;
import model.animals.Cat;
import model.animals.Dog;
import model.animals.DomesticatedAnimal;
import model.animals.WildAnimal;
import model.commodities.Commodity;
import model.factories.Factory;

import java.util.ArrayList;
import java.util.HashSet;

public class InGameManager {
    Storeroom storeroom;
    Coin coin;
    Well well;
    PickUpTruck pickUpTruck;
    //
    public int turnsPassed=0;
    //



    public InGameManager(Storeroom storeroom, Coin coin, Well well, PickUpTruck pickUpTruck) {
        this.storeroom = storeroom;
        this.coin = coin;
        this.well = well;
        this.pickUpTruck = pickUpTruck;
    }

    public void game(){
        moving();
        catWork();
        dogWorks();
        wildAnimalWorks();
        domesticatedAnimalWorks();
        commodityWorks();
        factoryWorks();
        pickUpTruckWorks();
        wellWorks();
       // show();
    }
    private void moving(){
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.move();
        }
        for (Cat cat : GameFieldStorage.catHashSet) {
            cat.move();
        }
        for (Dog dog : GameFieldStorage.dogHashSet) {
            dog.move();
        }
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.move();
        }
    }
    private void catWork(){
        for (Cat cat : GameFieldStorage.catHashSet) {
            cat.pickupCommodity(storeroom);
        }
    }
    private void dogWorks(){
        GameFieldStorage.dogHashSet.removeIf(Dog::attackWildAnimal);
    }
    private void wildAnimalWorks(){
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.attackDomesticatedAnimals();
        }
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.attackCommodities();
        }
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.removeCage();
        }
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.addTurnsAfterCaged();
        }

        GameFieldStorage.wildAnimalHashSet.removeIf(WildAnimal::maxTurnsInfieldReached);

        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.setIsCagedInThisRoundAtEndOfTheRound();
        }
    }
    private void domesticatedAnimalEat(){
        HashSet<Grass> eatenGrassHashSet = new HashSet<>();
        for (Grass grass : GameFieldStorage.grassHashSet) {
            DomesticatedAnimal domesticatedAnimal = whichAnimalEats(grass.getDomesticatedAnimals());
            if(domesticatedAnimal != null){
                if(domesticatedAnimal.eat(grass)){
                    eatenGrassHashSet.add(grass);
                }
            }
        }
        for (Grass grass : eatenGrassHashSet) {
            GameFieldStorage.grassHashSet.remove(grass);
        }
    }
    private void domesticatedAnimalWorks(){
        domesticatedAnimalEat();
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.reduceHealth();
        }

        GameFieldStorage.domesticatedAnimalHashSet.removeIf(domesticatedAnimal -> domesticatedAnimal.getHealth() <= 0);

        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.ProduceWithTurns();
        }
    }
    private void commodityWorks(){
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            commodity.addTurnsInField();
        }

        GameFieldStorage.commodityHashSet.removeIf(Commodity::maxTurnsInfieldReached);

    }
    private void factoryWorks(){
        for (Factory factory : GameFieldStorage.factoryHashSet) {
            factory.makeOneCommodityWithTurn();
            factory.makeTwoCommodityWithTurn();
        }
    }
    private void pickUpTruckWorks(){
        pickUpTruck.sellWithTurns(coin);
    }
    private void wellWorks(){
        well.getWaterWithTurns();
    }
    public void show(){
        int [][] grassArray = makeGrassArray();
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                System.out.print(grassArray[i][i1] + "\t");
            }
            System.out.println();
        }
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            System.out.println(domesticatedAnimal.toString());
        }
        System.out.println();
        for (Cat cat : GameFieldStorage.catHashSet) {
            System.out.println(cat.toString());
        }
        System.out.println();
        for (Dog dog : GameFieldStorage.dogHashSet) {
            System.out.println(dog.toString());
        }
        System.out.println();
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            System.out.println(wildAnimal.toString());
        }
        System.out.println();
        for (Factory factory : GameFieldStorage.factoryHashSet) {
            System.out.println(factory.toString());
        }
        System.out.println();
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            System.out.println(commodity.toString());
        }
        System.out.println();
        for (Commodity commodity : storeroom.commodityHashSet) {
            System.out.println(commodity.toString());
        }
    }
    private int[][] makeGrassArray(){
        int [][] grassArray = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                grassArray[i][i1] = 0;
            }
        }
        for (Grass grass : GameFieldStorage.grassHashSet) {
            grassArray[grass.getYCoordinate()][grass.getXCoordinate()]++;
        }
        return grassArray;
    }
    private DomesticatedAnimal whichAnimalEats(ArrayList<DomesticatedAnimal> domesticatedAnimalArrayList){
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
