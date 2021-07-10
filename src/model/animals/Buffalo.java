package model.animals;

import inGamGraphics.Animation;
import inGamGraphics.Assets;
import model.Coin;
import model.GameFieldStorage;
import model.commodities.Milk;

import java.awt.*;

public class Buffalo extends DomesticatedAnimal{
    public static final int BUFFALO_PRICE = 400;
    public static final int BUFFALO_TURNS_NEEDED_TO_MAKE_MILK = 2;
    public static int buffaloNumber = 0;

    public Buffalo() {
        super();
        buffaloNumber++;
        animalName = "Buffalo" + buffaloNumber;
        downAnimation = new Animation(300 , Assets.buffaloDown);
        upAnimation = new Animation(300 , Assets.buffaloUp);
        rightAnimation = new Animation(300 , Assets.buffaloRight);
        leftAnimation = new Animation(300 , Assets.buffaloLeft);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentFrame() , xCoordinate , yCoordinate , ANIMAL_WIDTH , ANIMAL_HEIGHT , null);
    }

    @Override
    public boolean resetTurns() {
        if(turns >= BUFFALO_TURNS_NEEDED_TO_MAKE_MILK){
            turns = 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIfTurnsReached() {
        return turns >= BUFFALO_TURNS_NEEDED_TO_MAKE_MILK;
    }

    public Milk produce(){
        return new  Milk(xCoordinate , yCoordinate);
    }
    public static boolean buyBuffalo(Coin coin){
        if(coin.hasEnoughCoins(BUFFALO_PRICE)){
            coin.reduceCoin(BUFFALO_PRICE);
            GameFieldStorage.domesticatedAnimalHashSet.add(new Buffalo());
            System.out.println("Buffalo was bought");
            return true;
        }else {
            System.err.println("you need " + (BUFFALO_PRICE - coin.getCoin()) + " more coins to buy Buffalo" );
        }
        return false;
    }
}
