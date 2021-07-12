package inGamGraphics;

import model.*;
import model.animals.Cat;
import model.animals.Dog;
import model.animals.DomesticatedAnimal;
import model.animals.WildAnimal;
import model.commodities.Commodity;
import model.factories.Factory;

import java.awt.*;

public class GameState extends State{
    public static GameState gameState;
    Coin coin;
    Well well;
    PickUpTruck pickUpTruck;
    Storeroom storeroom;
    int turn = 0;


    public GameState() {
        this.coin = GameFieldStorage.coin;
        this.well = GameFieldStorage.well;
        this.pickUpTruck = GameFieldStorage.pickUpTruck;
        this.storeroom = GameFieldStorage.storeroom;
    }

    @Override
    public void tick() {
        turn++;
        shortTick();
        if(turn % 100 == 0){
            longTick();
            turn = 0;
        }
    }
    public void init(){
//     GameFieldStorage.domesticatedAnimalHashSet.add(new Buffalo());
//     GameFieldStorage.domesticatedAnimalHashSet.add(new Chicken());
//     GameFieldStorage.catHashSet.add(new Cat());
//     GameFieldStorage.wildAnimalHashSet.add(new Bear());
    }
    private void shortTick(){
        Cell.tickWorld();
        //cat
        for (Cat cat : GameFieldStorage.catHashSet) {
            cat.shortTick();
            cat.pickupCommodity(storeroom);
        }
        //dog
        for (Dog dog : GameFieldStorage.dogHashSet) {
            dog.shortTick();
        }
        GameFieldStorage.dogHashSet.removeIf(Dog::attackWildAnimal);
        //wild animal
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.shortTick();
        }
        //domesticated animal
        DomesticatedAnimal.domesticatedAnimalEat();
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.shortTick();
        }

    }

    private void longTick(){
        //cat
        for (Cat cat : GameFieldStorage.catHashSet) {
            cat.longTick();
            cat.pickupCommodity(storeroom);
        }
        //dog
        for (Dog dog : GameFieldStorage.dogHashSet) {
            dog.longTick();
        }

        //wild animal
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.longTick();
        }
        GameFieldStorage.wildAnimalHashSet.removeIf(WildAnimal::maxTurnsInfieldReached);
        //domesticated animal
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.longTick();
        }
        GameFieldStorage.domesticatedAnimalHashSet.removeIf(domesticatedAnimal -> domesticatedAnimal.getHealth() <= 0);
        //commodity
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            commodity.addTurnsInField();
        }

        GameFieldStorage.commodityHashSet.removeIf(Commodity::maxTurnsInfieldReached);
        //factory
        for (Factory factory : GameFieldStorage.factoryHashSet) {
            factory.makeOneCommodityWithTurn();
            factory.makeTwoCommodityWithTurn();
        }
        //truck
        pickUpTruck.sellWithTurns(coin);
        //well
        well.getWaterWithTurns();
    }

    @Override
    public void render(Graphics graphics) {
        Cell.renderWorld(graphics);
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.render(graphics);
        }
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.render(graphics);
        }
        for (Dog dog : GameFieldStorage.dogHashSet) {
            dog.render(graphics);
        }
        for (Cat cat : GameFieldStorage.catHashSet) {
            cat.render(graphics);
        }
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            commodity.render(graphics);
        }
    }
}
