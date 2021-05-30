package model.factories;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.commodities.IceCream;
import model.commodities.PocketMilk;

import java.util.Random;

public class IceCreamMaker extends SecondaryFactory{
    public static final int ICE_CREAM_MAKER_CONSTRUCTION_PRICE = 550;
    public static final int TIME_NEEDED_TO_MAKE_ICE_CREAM_WITHOUT_UPGRADE = 7;
    public static final int TIME_NEEDED_TO_MAKE_ICE_CREAM_WITH_UPGRADE = 4;
    public static final int ICE_CREAM_UPGRADE_PRICE = 275;

    public static boolean buildIceCreamMaker(Coin coin){
        if(coin.hasEnoughCoins(ICE_CREAM_MAKER_CONSTRUCTION_PRICE)){
            coin.reduceCoin(ICE_CREAM_MAKER_CONSTRUCTION_PRICE);
            GameFieldStorage.factoryHashSet.add(new IceCreamMaker());
            return true;
        }
        return false;
    }
    @Override
    public boolean upgrade(Coin coin) {
        if (!upgraded) {
            if (coin.hasEnoughCoins(ICE_CREAM_UPGRADE_PRICE)) {
                coin.reduceCoin(ICE_CREAM_UPGRADE_PRICE);
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
        IceCream iceCream = new IceCream(random.nextInt(6) , random.nextInt(6));
        GameFieldStorage.commodityHashSet.add(iceCream);
    }
    @Override
    public boolean startWorkingOneCommodity(Storeroom storeroom){
        if(!working){
            PocketMilk pocketMilk = storeroom.takePocketMilk();
            if (pocketMilk != null) {
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
            if (storeroom.numberOfPocketMilks() >= 2) {
                PocketMilk pocketMilk1 = storeroom.takePocketMilk();
                PocketMilk pocketMilk2 = storeroom.takePocketMilk();
                if (pocketMilk1 != null && pocketMilk2 != null) {
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
            return turns >= TIME_NEEDED_TO_MAKE_ICE_CREAM_WITH_UPGRADE;
        }
        return false;
    }
    @Override
    public boolean checkIfTurnsReachedNotUpgraded() {
        return turns >= TIME_NEEDED_TO_MAKE_ICE_CREAM_WITHOUT_UPGRADE;
    }

    public IceCreamMaker() {
        super();
        factoryName = "IceCreamMaker";
    }
}
