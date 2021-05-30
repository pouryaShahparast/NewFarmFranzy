package model.factories;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.commodities.Milk;
import model.commodities.PocketMilk;

import java.util.Random;

public class MilkPocketingProduction extends PrimitiveFactory{
    public static final int MILK_POCKETING_PRODUCTION_CONSTRUCTION_PRICE = 400;
    public static final int TIME_NEEDED_TO_MAKE_POCKET_MILK_WITHOUT_UPGRADE = 6;
    public static final int TIME_NEEDED_TO_MAKE_POCKET_MILK_WITH_UPGRADE = 3;
    public static final int MILK_POCKETING_PRODUCTION_UPGRADE_PRICE = 200;

    public static boolean buildMilkPocketingProduction(Coin coin){
        if(coin.hasEnoughCoins(MILK_POCKETING_PRODUCTION_CONSTRUCTION_PRICE)){
            coin.reduceCoin(MILK_POCKETING_PRODUCTION_CONSTRUCTION_PRICE);
            GameFieldStorage.factoryHashSet.add(new MilkPocketingProduction());
            return true;
        }
        return false;
    }

    @Override
    public boolean upgrade(Coin coin) {
        if (!upgraded) {
            if (coin.hasEnoughCoins(MILK_POCKETING_PRODUCTION_UPGRADE_PRICE)) {
                coin.reduceCoin(MILK_POCKETING_PRODUCTION_UPGRADE_PRICE);
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
        PocketMilk pocketMilk = new PocketMilk(random.nextInt(6) , random.nextInt(6));
        GameFieldStorage.commodityHashSet.add(pocketMilk);
    }
    @Override
    public boolean startWorkingOneCommodity(Storeroom storeroom){
        if(!working){
            Milk milk = storeroom.takeMilk();
            if (milk != null) {
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
            if (storeroom.numberOfMilks() >= 2) {
                Milk milk1 = storeroom.takeMilk();
                Milk milk2 = storeroom.takeMilk();
                if (milk1 != null && milk2 != null) {
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
            return turns >= TIME_NEEDED_TO_MAKE_POCKET_MILK_WITH_UPGRADE;
        }
        return false;
    }
    @Override
    public boolean checkIfTurnsReachedNotUpgraded() {
        return turns >= TIME_NEEDED_TO_MAKE_POCKET_MILK_WITHOUT_UPGRADE;
    }

    public MilkPocketingProduction() {
        super();
        factoryName = "MilkPocketingProduction";
    }
}
