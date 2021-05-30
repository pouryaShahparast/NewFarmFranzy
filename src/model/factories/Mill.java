package model.factories;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.commodities.Egg;
import model.commodities.Flour;

import java.util.Random;

public class Mill extends PrimitiveFactory{
    public static final int MILL_CONSTRUCTION_PRICE = 150;
    public static final int TIME_NEEDED_TO_MAKE_FLOUR_WITHOUT_UPGRADE = 4;
    public static final int TIME_NEEDED_TO_MAKE_FLOUR_WITH_UPGRADE = 2;
    public static final int MILL_UPGRADE_PRICE = 75;

    public static boolean buildMill(Coin coin){
        if(coin.hasEnoughCoins(MILL_CONSTRUCTION_PRICE)){
            coin.reduceCoin(MILL_CONSTRUCTION_PRICE);
            GameFieldStorage.factoryHashSet.add(new Mill());
            return true;
        }
        return false;
    }

    @Override
    public boolean upgrade(Coin coin) {
        if (!upgraded) {
            if (coin.hasEnoughCoins(MILL_UPGRADE_PRICE)) {
                coin.reduceCoin(MILL_UPGRADE_PRICE);
                upgraded = true;
                if(working){
                    workingWhileUpgrade = true;
                }
                return true;
            }
        }
        return false;
    }
    @Override
    public void make() {
        Random random = new Random();
        Flour flour = new Flour(random.nextInt(6) , random.nextInt(6));
        GameFieldStorage.commodityHashSet.add(flour);
    }
    @Override
    public boolean startWorkingOneCommodity(Storeroom storeroom){
        if(!working){
            Egg egg = storeroom.takeEgg();
            if (egg != null) {
                working = true;
                workingOneCommodity = true;
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean startWorkingTwoCommodities(Storeroom storeroom) {
        if (!working && upgraded) {
            if (storeroom.numberOfEggs() >= 2) {
                Egg egg1 = storeroom.takeEgg();
                Egg egg2 = storeroom.takeEgg();
                if (egg1 != null && egg2 != null) {
                    working = true;
                    workingTwoCommodity = true;
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean checkIfTurnsReachedUpgraded() {
        if(upgraded){
            return turns >= TIME_NEEDED_TO_MAKE_FLOUR_WITH_UPGRADE;
        }
        return false;
    }
    @Override
    public boolean checkIfTurnsReachedNotUpgraded() {
        return turns >= TIME_NEEDED_TO_MAKE_FLOUR_WITHOUT_UPGRADE;
    }

    public Mill() {
         super();
         factoryName = "Mill";
    }
}
