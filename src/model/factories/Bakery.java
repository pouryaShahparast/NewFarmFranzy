package model.factories;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.commodities.Bread;
import model.commodities.Flour;

import java.util.Random;

public class Bakery extends SecondaryFactory{
    public static final int BAKERY_CONSTRUCTION_PRICE = 250;
    public static final int TIME_NEEDED_TO_MAKE_BREAD_WITHOUT_UPGRADE = 5;
    public static final int TIME_NEEDED_TO_MAKE_BREAD_WITH_UPGRADE = 3;
    public static final int BAKERY_UPGRADE_PRICE = 125;

    public static boolean buildBakery(Coin coin){
        if(coin.hasEnoughCoins(BAKERY_CONSTRUCTION_PRICE)){
            coin.reduceCoin(BAKERY_CONSTRUCTION_PRICE);
            GameFieldStorage.factoryHashSet.add(new Bakery());
            return true;
        }
        return false;
    }

    @Override
    public boolean upgrade(Coin coin) {
        if (!upgraded) {
            if (coin.hasEnoughCoins(BAKERY_UPGRADE_PRICE)) {
                coin.reduceCoin(BAKERY_UPGRADE_PRICE);
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
        Bread bread = new Bread(random.nextInt(6) , random.nextInt(6));
        GameFieldStorage.commodityHashSet.add(bread);
    }
    @Override
    public boolean startWorkingOneCommodity(Storeroom storeroom){
        if(!working){
            Flour flour = storeroom.takeFlour();
            if (flour != null) {
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
            if (storeroom.numberOfFlours() >= 2) {
                Flour flour1 = storeroom.takeFlour();
                Flour flour2 = storeroom.takeFlour();
                if (flour1 != null && flour2 != null) {
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
            return turns >= TIME_NEEDED_TO_MAKE_BREAD_WITH_UPGRADE;
        }
        return false;
    }
    @Override
    public boolean checkIfTurnsReachedNotUpgraded() {
        return turns >= TIME_NEEDED_TO_MAKE_BREAD_WITHOUT_UPGRADE;
    }

    public Bakery() {
        super();
        factoryName = "Bakery";
    }
}
