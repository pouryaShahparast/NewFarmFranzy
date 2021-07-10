package model.animals;

import inGamGraphics.Animation;
import inGamGraphics.Assets;
import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;
import model.commodities.Commodity;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;

public class Cat extends Animal{
    public static final int CAT_PRICE = 150;
    public static int catNumber = 0;


    public Cat() {
        super();
        catNumber++;
        animalName = "Cat" + catNumber;
        downAnimation = new Animation(300 , Assets.catDown);
        upAnimation = new Animation(300 , Assets.catUp);
        rightAnimation = new Animation(300 , Assets.catRight);
        leftAnimation = new Animation(300 , Assets.catLeft);
    }


    @Override
    public void shortTick() {
        getCurrentAnimation().tick();
        move();
//        for (Cat cat : GameFieldStorage.catHashSet) {
//            cat.pickupCommodity(storeroom);
//        }
    }

    @Override
    public void longTick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentFrame() , xCoordinate , yCoordinate , ANIMAL_WIDTH , ANIMAL_HEIGHT , null);
    }

    public void pickupCommodity(Storeroom storeroom){
        HashSet<Commodity> removedCommodities = new HashSet<>();
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            if(checkForCollision(commodity.getBounds())){
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
            System.out.println("Cat was bought");
            return true;
        }else {
            System.err.println("you need " + (CAT_PRICE - coin.getCoin()) + " more coins to buy Cat");
        }
        return false;
    }
    protected void findDirection(Commodity commodity){
        if ((xInRang(commodity.getXCoordinate()))&& (!yInRang(commodity.getYCoordinate()))) {
            if (commodity.getYCoordinate() > yCoordinate) {
                direction = MOVE_DIRECTIONS.DOWN;
            } else {
                direction = MOVE_DIRECTIONS.UP;
            }
        } else if ((!xInRang(commodity.getXCoordinate())) && (yInRang(commodity.getYCoordinate()))) {
            if (commodity.getXCoordinate() > xCoordinate) {
                direction = MOVE_DIRECTIONS.RIGHT;
            } else {
                direction = MOVE_DIRECTIONS.LEFT;
            }
        } else if ((!xInRang(commodity.getXCoordinate())) && (!yInRang(commodity.getYCoordinate()))) {
            Random random = new Random();
            int a = random.nextInt(100);
            if (a > 50) {
                if (commodity.getYCoordinate() > yCoordinate) {
                    direction = MOVE_DIRECTIONS.DOWN;
                } else {
                    direction = MOVE_DIRECTIONS.UP;
                }
            } else {
                if (commodity.getXCoordinate() > xCoordinate) {
                    direction = MOVE_DIRECTIONS.RIGHT;
                } else {
                    direction = MOVE_DIRECTIONS.LEFT;
                }
            }
        }
    }

    private void normalMove(){
        randomMove();
    }
    @Override
    public void move() {
        Commodity commodity = findNearestCommodity(GameFieldStorage.commodityHashSet);
        if(commodity == null){
            normalMove();
        }else {
            findDirection(commodity);
            moving();
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
            if((commodity1.getYCoordinate()>=0)&&(commodity1.getYCoordinate()<=600)&&(commodity1.getXCoordinate()>=0)&&(commodity1.getXCoordinate()<=600)) {
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
