package model.animals;

import model.Coin;
import model.GameFieldStorage;
import model.commodities.Egg;

public class Chicken extends DomesticatedAnimal {
    public static final int CHICKEN_PRICE = 100;
    public static final int CHICKEN_TURNS_NEEDED_TO_MAKE_EGG = 2;

    public Chicken() {
        super();
        animalName = "Chicken";
    }

    @Override
    public boolean resetTurns() {
        if(turns >= CHICKEN_TURNS_NEEDED_TO_MAKE_EGG){
            turns = 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIfTurnsReached() {
        return turns >= CHICKEN_TURNS_NEEDED_TO_MAKE_EGG;
    }

    public Egg produce(){
        return new Egg(xCoordinate,yCoordinate);
    }
    public static boolean buyChicken(Coin coin){
        if(coin.hasEnoughCoins(CHICKEN_PRICE)){
            coin.reduceCoin(CHICKEN_PRICE);
            GameFieldStorage.domesticatedAnimalHashSet.add(new Chicken());
            return true;
        }
        return false;
    }
}
