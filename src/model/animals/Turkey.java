package model.animals;

import model.Coin;
import model.GameFieldStorage;
import model.commodities.Feather;

public class Turkey extends DomesticatedAnimal{
    public static final int TURKEY_PRICE = 200;
    public static final int TURKEY_TURNS_NEEDED_TO_MAKE_FEATHER = 3;

    public Turkey() {
        super();
        animalName = "Turkey";
    }

    @Override
    public boolean resetTurns() {
        if(turns >= TURKEY_TURNS_NEEDED_TO_MAKE_FEATHER){
            turns = 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIfTurnsReached() {
        return turns >= TURKEY_TURNS_NEEDED_TO_MAKE_FEATHER;
    }

    @Override


    public Feather produce(){
        return new Feather(xCoordinate,yCoordinate);
    }
    public static boolean buyTurkey(Coin coin){
        if(coin.hasEnoughCoins(TURKEY_PRICE)){
            coin.reduceCoin(TURKEY_PRICE);
            GameFieldStorage.domesticatedAnimalHashSet.add(new Turkey());
            return true;
        }
        return false;
    }
}
