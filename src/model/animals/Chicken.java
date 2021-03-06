package model.animals;

import inGamGraphics.Animation;
import inGamGraphics.Assets;
import model.Coin;
import model.GameFieldStorage;
import model.commodities.Egg;

import javax.swing.*;
import java.awt.*;

public class Chicken extends DomesticatedAnimal {
    public static final int CHICKEN_PRICE = 100;
    public static final int CHICKEN_TURNS_NEEDED_TO_MAKE_EGG = 2;
    public static int chickenNumber = 0;

    public Chicken() {
        super();
        chickenNumber++;
        animalName = "Chicken" + chickenNumber;
        downAnimation = new Animation(300 , Assets.chickenDown);
        upAnimation = new Animation(300 , Assets.chickenUp);
        rightAnimation = new Animation(300 , Assets.chickenRight);
        leftAnimation = new Animation(300 , Assets.chickenLeft);
    }



    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentFrame() , xCoordinate , yCoordinate , ANIMAL_WIDTH , ANIMAL_HEIGHT , null);
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
            System.out.println("Chicken was bought");
            return true;
        }else {
   //         System.err.println("you need " + (CHICKEN_PRICE - coin.getCoin()) + " more coins to buy Chicken");
            JOptionPane.showMessageDialog(null,"you need " + (CHICKEN_PRICE - coin.getCoin()) + " more coins to buy Chicken" ,"warning",JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
