package model.animals;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.commodities.Commodity;

import java.util.HashSet;
import java.util.Random;

public class Cat extends Animal{
    public static final int CAT_PRICE = 150;
    private void normalMove(){
        Random random = new Random();
        boolean canMove = false;
        while (!canMove){
            int a = random.nextInt(4);
            switch (a){
                case 0:
                    if(xCoordinate - 1 >= 0){
                        xCoordinate -= 1;
                        canMove = true;
                    }
                    break;
                case 1:
                    if(xCoordinate + 1 < 6){
                        xCoordinate += 1;
                        canMove = true;
                    }
                    break;
                case 2:
                    if (yCoordinate - 1 >= 0){
                        yCoordinate -= 1;
                        canMove = true;
                    }
                    break;
                case 3:
                    if (yCoordinate + 1 < 6){
                        yCoordinate += 1;
                        canMove = true;
                    }
                    break;
            }
        }
    }

    public Cat() {
        super();
        animalName = "Cat";
    }
    public void pickupCommodity(Storeroom storeroom){
        HashSet<Commodity> removedCommodities = new HashSet<>();
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            if((xCoordinate == commodity.getXCoordinate()) && (yCoordinate == commodity.getYCoordinate())){
                removedCommodities.add(commodity);
            }
        }
        for (Commodity removedCommodity : removedCommodities) {
            storeroom.store(removedCommodity);
        }
    }
//    public boolean pickupCommodity(Storeroom storeroom){
//        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
//            if((commodity.getXCoordinate() == xCoordinate ) && (commodity.getYCoordinate() == yCoordinate)){
//                if(storeroom.store(commodity)){
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
    public static boolean buyCat(Coin coin){
        if(coin.hasEnoughCoins(CAT_PRICE)){
            coin.reduceCoin(CAT_PRICE);
            GameFieldStorage.catHashSet.add(new Cat());
            return true;
        }
        return false;
    }
    @Override
    public void move() {
        Commodity commodity = findNearestCommodity(GameFieldStorage.commodityHashSet);
        if(commodity == null){
            normalMove();
        }else {
            if ((commodity.getXCoordinate() == xCoordinate) && (commodity.getYCoordinate() != yCoordinate)) {
                if (commodity.getYCoordinate() > yCoordinate) {
                    yCoordinate++;
                } else {
                    yCoordinate--;
                }
            } else if ((commodity.getXCoordinate() != xCoordinate) && (commodity.getYCoordinate() == yCoordinate)) {
                if (commodity.getXCoordinate() > xCoordinate) {
                    xCoordinate++;
                } else {
                    xCoordinate--;
                }
            } else if ((commodity.getXCoordinate() != xCoordinate) && (commodity.getYCoordinate() != yCoordinate)) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    if (commodity.getYCoordinate() > yCoordinate) {
                        yCoordinate++;
                    } else {
                        yCoordinate--;
                    }
                } else {
                    if (commodity.getXCoordinate() > xCoordinate) {
                        xCoordinate++;
                    } else {
                        xCoordinate--;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return animalName + " " + "[" + (xCoordinate + 1) + " " + (yCoordinate + 1) +"]";
    }

    private Commodity findNearestCommodity(HashSet<Commodity> commodityHashSet){
        double minDistance = -1;
        Commodity commodity = null;
        if(commodityHashSet.isEmpty()){
            return null;
        }
        for (Commodity commodity1 : commodityHashSet) {
            if((commodity1.getYCoordinate()>=0)&&(commodity1.getYCoordinate()<6)&&(commodity1.getXCoordinate()>=0)&&(commodity1.getXCoordinate()<6)) {
                double distance = Math.sqrt(Math.pow(xCoordinate - commodity1.getXCoordinate(), 2) + Math.pow(yCoordinate - commodity1.getYCoordinate(), 2));
                if ((minDistance == -1) || (minDistance > distance)) {
                    minDistance = distance;
                    commodity = commodity1;
                }
            }
        }
        return commodity;
    }
}
