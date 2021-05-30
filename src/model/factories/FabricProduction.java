package model.factories;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.commodities.Fabric;
import model.commodities.Feather;

import java.util.Random;

public class FabricProduction extends PrimitiveFactory{
    public static final int FABRIC_PRODUCTION_CONSTRUCTION_PRICE = 250;
    public static final int TIME_NEEDED_TO_MAKE_FABRIC_WITHOUT_UPGRADE = 5;
    public static final int TIME_NEEDED_TO_MAKE_FABRIC_WITH_UPGRADE = 3;
    public static final int FABRIC_PRODUCTION_UPGRADE_PRICE = 125;

    public static boolean buildFabricProduction(Coin coin){
        if(coin.hasEnoughCoins(FABRIC_PRODUCTION_CONSTRUCTION_PRICE)){
            coin.reduceCoin(FABRIC_PRODUCTION_CONSTRUCTION_PRICE);
            GameFieldStorage.factoryHashSet.add(new FabricProduction());
            return true;
        }
        return false;
    }

    @Override
    public boolean upgrade(Coin coin) {
        if (!upgraded) {
            if (coin.hasEnoughCoins(FABRIC_PRODUCTION_UPGRADE_PRICE)) {
                coin.reduceCoin(FABRIC_PRODUCTION_UPGRADE_PRICE);
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
        Fabric fabric = new Fabric(random.nextInt(6) , random.nextInt(6));
        GameFieldStorage.commodityHashSet.add(fabric);
    }
    @Override
    public boolean startWorkingOneCommodity(Storeroom storeroom){
        if(!working){
            Feather feather = storeroom.takeFeather();
            if (feather != null) {
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
            if (storeroom.numberOfFeathers() >= 2) {
                Feather feather1 = storeroom.takeFeather();
                Feather feather2 = storeroom.takeFeather();
                if (feather1 != null && feather2 != null) {
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
            return turns >= TIME_NEEDED_TO_MAKE_FABRIC_WITH_UPGRADE;
        }
        return false;
    }
    @Override
    public boolean checkIfTurnsReachedNotUpgraded() {
        return turns >= TIME_NEEDED_TO_MAKE_FABRIC_WITHOUT_UPGRADE;
    }

    public FabricProduction() {
        super();
        factoryName = "FabricProduction";
    }
}
