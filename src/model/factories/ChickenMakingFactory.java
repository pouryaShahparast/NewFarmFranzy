package model.factories;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.animals.Chicken;
import model.commodities.Egg;

import javax.swing.*;
import java.util.Random;

public class ChickenMakingFactory extends SecondaryFactory{
    public static final int CHICKEN_MAKING_CONSTRUCTION_PRICE = 700;
    public static final int TIME_NEEDED_TO_MAKE_CHICKEN_WITHOUT_UPGRADE = 8;
    public static final int TIME_NEEDED_TO_MAKE_CHICKEN_WITH_UPGRADE = 4;
    public static final int CHICKEN_MAKING_UPGRADE_PRICE = 350;
    public static boolean buildChickenMakingFactory(Coin coin){
        if(coin.hasEnoughCoins(CHICKEN_MAKING_CONSTRUCTION_PRICE)){
            coin.reduceCoin(CHICKEN_MAKING_CONSTRUCTION_PRICE);
            GameFieldStorage.factoryHashSet.add(new ChickenMakingFactory());
            System.out.println("Bakery was bought");
            return true;
        }else {
            JOptionPane.showMessageDialog(null,"you need " + (CHICKEN_MAKING_CONSTRUCTION_PRICE - coin.getCoin()) + " more coins to build Bakery","warning",JOptionPane.WARNING_MESSAGE);

        }
        return false;
    }
    @Override
    public boolean upgrade(Coin coin) {
        if (!upgraded) {
            if (coin.hasEnoughCoins(CHICKEN_MAKING_UPGRADE_PRICE)) {
                coin.reduceCoin(CHICKEN_MAKING_UPGRADE_PRICE);
                upgraded = true;
                if(working){
                    workingWhileUpgrade = true;
                }
                System.out.println("Bakery was upgraded");
                return true;
            }else {
                JOptionPane.showMessageDialog(null,"you need " + (CHICKEN_MAKING_UPGRADE_PRICE - coin.getCoin()) + " more coins to upgrade Bakery","warning",JOptionPane.WARNING_MESSAGE);
                     }
        }else {
            JOptionPane.showMessageDialog(null,factoryName + "is already upgraded","warning",JOptionPane.WARNING_MESSAGE);



        }
        return false;
    }

    @Override
    public void make() {
        Random random = new Random();
        Chicken chicken = new Chicken();
        GameFieldStorage.domesticatedAnimalHashSet.add(chicken);
    }

    @Override
    public boolean startWorkingOneCommodity(Storeroom storeroom) {
        if(!working){
            Egg egg = storeroom.takeEgg();
            if (egg != null) {
                working = true;
                workingOneCommodity = true;

                System.out.println(factoryName + " started to work");
                return true;
            }else {
                JOptionPane.showMessageDialog(null,"there isn't any eggs in storeroom","warning",JOptionPane.WARNING_MESSAGE);

            }
        }else {
            JOptionPane.showMessageDialog(null,factoryName + " is already working","warning",JOptionPane.WARNING_MESSAGE);

        }
        return false;
    }

    @Override
    public boolean startWorkingTwoCommodities(Storeroom storeroom) {
        if(!upgraded){
            JOptionPane.showMessageDialog(null,"you can't make two Breads at the same time because " + factoryName + " is not upgraded","warning",JOptionPane.WARNING_MESSAGE);

            return false;
        }
        if (!working) {
            if (storeroom.numberOfEggs() >= 2) {
                Egg egg1 = storeroom.takeEgg();
                Egg egg2 = storeroom.takeEgg();
                if (egg1 != null && egg2 != null) {
                    working = true;
                    workingTwoCommodity = true;
                    System.out.println(factoryName + " started to work with two eggs");
                    return true;
                }
            }else {
                JOptionPane.showMessageDialog(null,"there aren't enough eggs in storeroom","warning",JOptionPane.WARNING_MESSAGE);


            }
        }else {
            JOptionPane.showMessageDialog(null,factoryName + " is already working","warning",JOptionPane.WARNING_MESSAGE);

        }
        return false;
    }

    @Override
    public boolean checkIfTurnsReachedUpgraded() {
        if(upgraded){
            return turns >= TIME_NEEDED_TO_MAKE_CHICKEN_WITH_UPGRADE;
        }
        return false;
    }

    @Override
    public boolean checkIfTurnsReachedNotUpgraded() {
        return turns >= TIME_NEEDED_TO_MAKE_CHICKEN_WITHOUT_UPGRADE;
    }
    public ChickenMakingFactory() {
        super();
        factoryName = "ChickenMakingFactory";
    }
}
