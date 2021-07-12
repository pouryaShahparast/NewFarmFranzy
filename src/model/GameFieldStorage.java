package model;

import model.animals.Cat;
import model.animals.Dog;
import model.animals.DomesticatedAnimal;
import model.animals.WildAnimal;
import model.commodities.Commodity;
import model.factories.Factory;

import java.util.HashSet;

public class GameFieldStorage {
    public static HashSet<DomesticatedAnimal> domesticatedAnimalHashSet;
    public static HashSet<Dog> dogHashSet;
    public static HashSet<Cat> catHashSet;
    public static HashSet<WildAnimal> wildAnimalHashSet;
    public static HashSet<Factory> factoryHashSet;
    public static HashSet<Commodity> commodityHashSet;
    public static HashSet<Grass> grassHashSet;
    public static Coin coin;
    public static Well well;
    public static PickUpTruck pickUpTruck;
    public static Storeroom storeroom;
    public static void init(int coins){
        domesticatedAnimalHashSet = new HashSet<>();
        dogHashSet = new HashSet<>();
        catHashSet = new HashSet<>();
        wildAnimalHashSet = new HashSet<>();
        factoryHashSet = new HashSet<>();
        commodityHashSet = new HashSet<>();
        grassHashSet = new HashSet<>();
        coin = new Coin(coins);
        well = new Well();
        pickUpTruck = new PickUpTruck();
        storeroom = new Storeroom();
    }
    public GameFieldStorage() {
    }
}
