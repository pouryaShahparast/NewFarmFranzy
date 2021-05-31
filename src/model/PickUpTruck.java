package model;

import model.animals.Bear;
import model.animals.Loin;
import model.animals.Tiger;
import model.animals.WildAnimal;
import model.commodities.*;

import java.util.HashSet;

public class PickUpTruck {
    public static final int MAX_CAPACITY = 15;
    public static final int TIME_NEEDED_TO_SELL = 10;
    HashSet<Object> pickUpTruckHashset;
    boolean traveling;
    int truckSpaceTaken;
    int turns;
    public boolean startTraveling(){
        if(traveling){
            return false;
        }
        if(pickUpTruckHashset.isEmpty()){
            return false;
        }
        traveling = true;
        return true;
    }
    public PickUpTruck() {
        pickUpTruckHashset= new HashSet<>();
        truckSpaceTaken = 0;
        traveling = false;
        turns = 1;
    }
    public void addTurns(){
        turns++;
    }
    public boolean sellWithTurns(Coin coin){
        if(pickUpTruckHashset.isEmpty()) {
            return false;
        }
        if(traveling){
            if(checkIfTurnsReached()){
                sellTruckFurniture(coin);
                finishTravel();
                return true;
            }else {
                addTurns();
            }
        }
        return false;
    }
    void finishTravel() {
        traveling = false;
        turns = 1;
    }
    public boolean checkIfTurnsReached(){
        return turns >= TIME_NEEDED_TO_SELL;
    }
    public boolean pickUp(Object object) {
        if (!traveling) {
            if (object instanceof WildAnimal) {
                if (canPick(WildAnimal.WILD_ANIMAL_SIZE)) {
                    truckSpaceTaken += WildAnimal.WILD_ANIMAL_SIZE;
                    pickUpTruckHashset.add(object);
                    return true;
                }
            } else if (object instanceof PrimitiveCommodity) {
                if (canPick(PrimitiveCommodity.PRIMITIVE_COMMODITY_SIZE)) {
                    truckSpaceTaken += PrimitiveCommodity.PRIMITIVE_COMMODITY_SIZE;
                    pickUpTruckHashset.add(object);
                    return true;
                }
            } else if (object instanceof IntermediaryCommodity) {
                if (canPick(IntermediaryCommodity.INTERMEDIARY_COMMODITY_SIZE)) {
                    truckSpaceTaken += IntermediaryCommodity.INTERMEDIARY_COMMODITY_SIZE;
                    pickUpTruckHashset.add(object);
                    return true;
                }
            } else if (object instanceof FinalCommodity) {
                if (canPick(FinalCommodity.FINAL_COMMODITY_SIZE)) {
                    truckSpaceTaken += FinalCommodity.FINAL_COMMODITY_SIZE;
                    pickUpTruckHashset.add(object);
                    return true;
                }
            }
        }
        return false;
    }
    public void sellTruckFurniture(Coin coin){
        for (Object object : pickUpTruckHashset) {
            if (object instanceof WildAnimal) {
                sellWildAnimal((WildAnimal) object , coin);
            } else if (object instanceof PrimitiveCommodity) {
                sellPrimitiveCommodity((PrimitiveCommodity) object , coin);
            } else if (object instanceof IntermediaryCommodity) {
                sellIntermediaryCommodity((IntermediaryCommodity) object , coin);
            } else if (object instanceof FinalCommodity) {
                sellFinalCommodity((FinalCommodity) object , coin);
            }
        }
        pickUpTruckHashset.clear();
    }


    private boolean sellWildAnimal(WildAnimal wildAnimal , Coin coin){
        if(wildAnimal instanceof Tiger){
            coin.addCoin(Tiger.TIGER_SELL_PRICE);
            return true;
        }else if(wildAnimal instanceof Bear){
            coin.addCoin(Bear.BEAR_SELL_PRICE);
            return true;
        }else if (wildAnimal instanceof Loin){
            coin.addCoin(Loin.LOIN_SELL_PRICE);
            return true;
        }
        return false;
    }
    private boolean sellPrimitiveCommodity(PrimitiveCommodity primitiveCommodity , Coin coin){
        if(primitiveCommodity instanceof Egg){
            coin.addCoin(Egg.EGG_PRICE);
            return true;
        }else if(primitiveCommodity instanceof Feather){
            coin.addCoin(Feather.FEATHER_PRICE);
            return true;
        }else if(primitiveCommodity instanceof Milk){
            coin.addCoin(Milk.MILK_PRICE);
            return true;
        }
        return false;
    }
    private boolean sellIntermediaryCommodity(IntermediaryCommodity intermediaryCommodity , Coin coin){
        if(intermediaryCommodity instanceof Flour){
            coin.addCoin(Flour.FLOUR_PRICE);
            return true;
        }if(intermediaryCommodity instanceof Fabric){
            coin.addCoin(Fabric.FABRIC_PRICE);
            return true;
        }if(intermediaryCommodity instanceof PocketMilk){
            coin.addCoin(PocketMilk.POCKET_MILK_PRICE);
            return true;
        }
        return false;
    }
    private boolean sellFinalCommodity(FinalCommodity finalCommodity , Coin coin){
        if(finalCommodity instanceof Bread){
            coin.addCoin(Bread.BREAD_PRICE);
            return true;
        }else if(finalCommodity instanceof Cloth){
            coin.addCoin(Cloth.CLOTH_PRICE);
            return true;
        }else if(finalCommodity instanceof IceCream){
            coin.addCoin(IceCream.ICE_CREAM_PRICE);
            return true;
        }
        return false;
    }
    public boolean canPick(int a){
        return a + truckSpaceTaken <= MAX_CAPACITY;
    }


    public boolean reStoreEggFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Egg){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreBreadFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Bread){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreClothFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Cloth){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreFabricFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Fabric){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreFeatherFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Feather){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreFlourFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Flour){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreIceCreamFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof IceCream){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreMilkFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Milk){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStorePocketMilkFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof PocketMilk){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreBearFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Bear){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreLoinFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Loin){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
    public boolean reStoreTigerFromTruck(Storeroom storeroom){
        for (Object object : pickUpTruckHashset) {
            if(object instanceof Tiger){
                return storeroom.reStoreFromTruck(object , this);
            }
        }
        return false;
    }
}
