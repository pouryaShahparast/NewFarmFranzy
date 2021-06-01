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
            System.out.println("IceCreamMaker was bought");
            return true;
        }else {
            System.err.println("you need " + (ICE_CREAM_MAKER_CONSTRUCTION_PRICE - coin.getCoin()) + " more coins to build IceCreamMaker");
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
                System.out.println(factoryName + " was upgraded");
                return true;
            }else {
                System.err.println("you need " + (ICE_CREAM_UPGRADE_PRICE - coin.getCoin()) + " more coins to upgrade " + factoryName);
            }
        }else {
            System.err.println(factoryName + "is already upgraded");
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
                System.out.println(factoryName + " started to work");
                return true;
            }else {
                System.err.println("there isn't any pocketMilk in storeroom");
            }
        }else {
            System.err.println(factoryName + " is already working");
        }
        return false;
    }
    @Override
    public boolean startWorkingTwoCommodities(Storeroom storeroom) {
        if(!upgraded){
            System.err.println("you can't make two IceCreams at the same time because " + factoryName + " is not upgraded");
            return false;
        }
        if (!working) {
            if (storeroom.numberOfPocketMilks() >= 2) {
                PocketMilk pocketMilk1 = storeroom.takePocketMilk();
                PocketMilk pocketMilk2 = storeroom.takePocketMilk();
                if (pocketMilk1 != null && pocketMilk2 != null) {
                    working = true;
                    workingTwoCommodity = true;
                    System.out.println(factoryName + " started to work with two pocketMilks");
                    return true;
                }
            }else {
                System.err.println("there aren't enough pocketMilks in storeroom");
            }
        }else {
            System.err.println(factoryName + " is already working");
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
