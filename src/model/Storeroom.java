package model;

import model.animals.Bear;
import model.animals.Loin;
import model.animals.Tiger;
import model.animals.WildAnimal;
import model.commodities.*;

import java.util.HashSet;

public class Storeroom {
    public static final int MAX_STORAGE = 30;
    public Storeroom() {
        commodityHashSet = new HashSet<>();
        wildAnimalHashSet = new HashSet<>();
        spaceTaken = 0;
    }
    int spaceTaken;
    public HashSet<Commodity> commodityHashSet;
    public HashSet<WildAnimal> wildAnimalHashSet;

    public boolean store(Object object){
        if(object instanceof WildAnimal){
            return storeWildAnimal((WildAnimal) object);
        }else if(object instanceof PrimitiveCommodity){
            return storePrimitiveCommodity((PrimitiveCommodity) object);
        }else if(object instanceof IntermediaryCommodity){
            return storeIntermediaryCommodity((IntermediaryCommodity) object);
        }else if(object instanceof FinalCommodity){
            return storeFinalCommodity((FinalCommodity) object);
        }
        return false;
    }

    private boolean storeWildAnimal(WildAnimal wildAnimal){
        if(spaceTaken + WildAnimal.WILD_ANIMAL_SIZE <= MAX_STORAGE){
            if(GameFieldStorage.wildAnimalHashSet.remove(wildAnimal)) {
                spaceTaken += WildAnimal.WILD_ANIMAL_SIZE;
                wildAnimal.storeWildAnimalChanges();
                wildAnimalHashSet.add(wildAnimal);
                return true;
            }
        }
        return false;
    }
    private boolean storeFinalCommodity(FinalCommodity finalCommodity){
        if(spaceTaken + FinalCommodity.FINAL_COMMODITY_SIZE <= MAX_STORAGE){
            if( GameFieldStorage.commodityHashSet.remove(finalCommodity)){
                spaceTaken += FinalCommodity.FINAL_COMMODITY_SIZE;
                finalCommodity.storeCommodityChanges();
                commodityHashSet.add(finalCommodity);
                return true;
            }
        }
        return false;
    }
    private boolean storeIntermediaryCommodity(IntermediaryCommodity intermediaryCommodity){
        if(spaceTaken + IntermediaryCommodity.INTERMEDIARY_COMMODITY_SIZE <= MAX_STORAGE){
            if(GameFieldStorage.commodityHashSet.remove(intermediaryCommodity)){
                spaceTaken += IntermediaryCommodity.INTERMEDIARY_COMMODITY_SIZE;
                intermediaryCommodity.storeCommodityChanges();
                commodityHashSet.add(intermediaryCommodity);
                return true;
            }
        }
        return false;
    }
    private boolean storePrimitiveCommodity(PrimitiveCommodity primitiveCommodity){
        if(spaceTaken + PrimitiveCommodity.PRIMITIVE_COMMODITY_SIZE <= MAX_STORAGE ){
            if(GameFieldStorage.commodityHashSet.remove(primitiveCommodity)){
                spaceTaken += PrimitiveCommodity.PRIMITIVE_COMMODITY_SIZE;
                primitiveCommodity.storeCommodityChanges();
                commodityHashSet.add(primitiveCommodity);
                return true;
            }
        }
        return false;
    }

    public Bear takeBear(){
        for (WildAnimal wildAnimal : wildAnimalHashSet) {
            if(wildAnimal instanceof Bear){
                spaceTaken -= WildAnimal.WILD_ANIMAL_SIZE;
                wildAnimalHashSet.remove(wildAnimal);
                return (Bear) wildAnimal;
            }
        }
        return null;
    }
    public Tiger takeTiger(){
        for (WildAnimal wildAnimal : wildAnimalHashSet) {
            if(wildAnimal instanceof Tiger){
                spaceTaken -= WildAnimal.WILD_ANIMAL_SIZE;
                wildAnimalHashSet.remove(wildAnimal);
                return (Tiger) wildAnimal;
            }
        }
        return null;
    }
    public Loin takeLoin(){
        for (WildAnimal wildAnimal : wildAnimalHashSet) {
            if(wildAnimal instanceof Loin){
                spaceTaken -= WildAnimal.WILD_ANIMAL_SIZE;
                wildAnimalHashSet.remove(wildAnimal);
                return (Loin) wildAnimal;
            }
        }
        return null;
    }
    public Bread takeBread(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Bread){
                spaceTaken -= Bread.FINAL_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (Bread) commodity;
            }
        }
        return null;
    }
    public Cloth takeCloth(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Cloth){
                spaceTaken -= Cloth.FINAL_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (Cloth) commodity;
            }
        }
        return null;
    }
    public Egg takeEgg(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Egg){
                spaceTaken -= Egg.PRIMITIVE_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (Egg) commodity;
            }
        }
        return null;
    }
    public Fabric takeFabric(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Fabric){
                spaceTaken -= Fabric.INTERMEDIARY_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (Fabric) commodity;
            }
        }
        return null;
    }
    public Feather takeFeather(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Feather){
                spaceTaken -= Feather.PRIMITIVE_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (Feather) commodity;
            }
        }
        return null;
    }
    public IceCream takeIceCream(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof IceCream){
                spaceTaken -= IceCream.FINAL_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (IceCream) commodity;
            }
        }
        return null;
    }
    public Flour takeFlour(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Flour){
                spaceTaken -= Flour.INTERMEDIARY_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (Flour) commodity;
            }
        }
        return null;
    }
    public Milk takeMilk(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Milk){
                spaceTaken -= Milk.PRIMITIVE_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (Milk) commodity;
            }
        }
        return null;
    }
    public PocketMilk takePocketMilk(){
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof PocketMilk){
                spaceTaken -= PocketMilk.INTERMEDIARY_COMMODITY_SIZE;
                commodityHashSet.remove(commodity);
                return (PocketMilk) commodity;
            }
        }
        return null;
    }

    public int numberOfBears(){
        int a = 0;
        for (WildAnimal wildAnimal : wildAnimalHashSet) {
            if(wildAnimal instanceof Bear){
                a++;
            }
        }
        return a;
    }
    public int numberOfTigers(){
        int a = 0;
        for (WildAnimal wildAnimal : wildAnimalHashSet) {

            if(wildAnimal instanceof Tiger){
                a++;
            }
        }
        return a;
    }
    public int numberOfLoins(){
        int a = 0;
        for (WildAnimal wildAnimal : wildAnimalHashSet) {
            if(wildAnimal instanceof Loin){
                a++;
            }
        }
        return a;
    }
    public int numberOfBreads(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Bread){
                a++;
            }
        }
        return a;
    }
    public int numberOfCloths(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Cloth){
                a++;
            }
        }
        return a;
    }
    public int numberOfEggs(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Egg){
                a++;
            }
        }
        return a;
    }
    public int numberOfFabrics(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Fabric){
                a++;
            }
        }
        return a;
    }
    public int numberOfFeathers(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Feather){
                a++;
            }
        }
        return a;
    }
    public int numberOfIceCreams(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof IceCream){
                a++;
            }
        }
        return a;
    }
    public int numberOfFlours(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Flour){
                a++;
            }
        }
        return a;
    }
    public int numberOfMilks(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof Milk){
                a++;
            }
        }
        return a;
    }
    public int numberOfPocketMilks(){
        int a = 0;
        for (Commodity commodity : commodityHashSet) {
            if(commodity instanceof PocketMilk){
                a++;
            }
        }
        return a;
    }
}
