package model.animals;

import model.Coin;
import model.GameFieldStorage;
import model.commodities.Milk;

public class Buffalo extends DomesticatedAnimal{
    public static final int BUFFALO_PRICE = 400;
    public static final int BUFFALO_TURNS_NEEDED_TO_MAKE_MILK = 2;

    public Buffalo() {
        super();
        animalName = "Buffalo";
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
            return true;
        }
        return false;
    }
}
