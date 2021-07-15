package model.factories;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.commodities.Cloth;
import model.commodities.Fabric;

import javax.swing.*;
import java.util.Random;

public class Tailoring extends SecondaryFactory{
    public static final int TAILORING_CONSTRUCTION_PRICE = 400;
    public static final int TIME_NEEDED_TO_MAKE_CLOTH_WITHOUT_UPGRADE = 6;
    public static final int TIME_NEEDED_TO_MAKE_CLOTH_WITH_UPGRADE = 3;
    public static final int TAILORING_UPGRADE_PRICE = 200;

    public static boolean buildTailoring(Coin coin){
        if(coin.hasEnoughCoins(TAILORING_CONSTRUCTION_PRICE)){
            coin.reduceCoin(TAILORING_CONSTRUCTION_PRICE);
            GameFieldStorage.factoryHashSet.add(new Tailoring());
            System.out.println("Tailoring was bought");
            return true;
        }else {
            JOptionPane.showMessageDialog(null,"you need " + (TAILORING_CONSTRUCTION_PRICE - coin.getCoin()) + " more coins to build Tailoring","warning", JOptionPane.WARNING_MESSAGE);

        }
        return false;
    }

    @Override
    public boolean upgrade(Coin coin) {
        if (!upgraded) {
            if (coin.hasEnoughCoins(TAILORING_UPGRADE_PRICE)) {
                coin.reduceCoin(TAILORING_UPGRADE_PRICE);
                upgraded = true;
                if(working){
                    workingWhileUpgrade = true;
                }
                System.out.println(factoryName + " was upgraded");
                return true;
            }else {
                JOptionPane.showMessageDialog(null,"you need " + (TAILORING_UPGRADE_PRICE - coin.getCoin()) + " more coins to upgrade " + factoryName,"warning", JOptionPane.WARNING_MESSAGE);

            }
        }else {
            JOptionPane.showMessageDialog(null,factoryName + "is already upgraded","warning", JOptionPane.WARNING_MESSAGE);

        }
        return false;
    }
    @Override
    public void make() {
        Random random = new Random();
        Cloth cloth = new Cloth(random.nextInt(550) , random.nextInt(550));
        GameFieldStorage.commodityHashSet.add(cloth);
    }
    @Override
    public boolean startWorkingOneCommodity(Storeroom storeroom){
        if(!working){
            Fabric fabric = storeroom.takeFabric();
            if (fabric != null) {
                working = true;
                workingOneCommodity = true;
                System.out.println(factoryName + " started to work");
                return true;
            }else {
                JOptionPane.showMessageDialog(null,"there isn't any fabric in storeroom","warning", JOptionPane.WARNING_MESSAGE);

            }
        }else {
            JOptionPane.showMessageDialog(null,factoryName + " is already working","warning", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    @Override
    public boolean startWorkingTwoCommodities(Storeroom storeroom) {
        if(!upgraded){
            JOptionPane.showMessageDialog(null,"you can't make two cloth at the same time because " + factoryName + " is not upgraded","warning", JOptionPane.WARNING_MESSAGE);

            return false;
        }
        if (!working) {
            if (storeroom.numberOfFabrics() >= 2) {
                Fabric fabric1 = storeroom.takeFabric();
                Fabric fabric2 = storeroom.takeFabric();
                if (fabric1 != null && fabric2 != null) {
                    working = true;
                    workingTwoCommodity = true;
                    System.out.println(factoryName + " started to work with two fabrics");
                    return true;
                }
            }else {
                JOptionPane.showMessageDialog(null,"there aren't enough fabrics in storeroom","warning", JOptionPane.WARNING_MESSAGE);

            }
        }else {
            JOptionPane.showMessageDialog(null,factoryName + " is already working","warning", JOptionPane.WARNING_MESSAGE);

        }
        return false;
    }
    @Override
    public boolean checkIfTurnsReachedUpgraded() {
        if(upgraded){
            return turns >= TIME_NEEDED_TO_MAKE_CLOTH_WITH_UPGRADE;
        }
        return false;
    }
    @Override
    public boolean checkIfTurnsReachedNotUpgraded() {
        return turns >= TIME_NEEDED_TO_MAKE_CLOTH_WITHOUT_UPGRADE;
    }

    public Tailoring() {
        super();
        factoryName = "Tailoring";
    }
}
