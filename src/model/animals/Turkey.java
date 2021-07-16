package model.animals;

import inGamGraphics.Animation;
import inGamGraphics.Assets;
import model.Coin;
import model.GameFieldStorage;
import model.commodities.Feather;

import javax.swing.*;
import java.awt.*;

public class Turkey extends DomesticatedAnimal{
    public static final int TURKEY_PRICE = 200;
    public static final int TURKEY_TURNS_NEEDED_TO_MAKE_FEATHER = 3;
    public static int turkeyNumber = 0;

    public Turkey() {
        super();
        turkeyNumber++;
        animalName = "Turkey" + turkeyNumber;
        downAnimation = new Animation(300 , Assets.turkeyDown);
        upAnimation = new Animation(300 , Assets.turkeyUp);
        rightAnimation = new Animation(300 , Assets.turkeyRight);
        leftAnimation = new Animation(300 , Assets.turkeyLeft);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentFrame() , xCoordinate , yCoordinate , ANIMAL_WIDTH , ANIMAL_HEIGHT , null);
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

    public Feather produce(){
        return new Feather(xCoordinate,yCoordinate);
    }
    public static boolean buyTurkey(Coin coin){
        if(coin.hasEnoughCoins(TURKEY_PRICE)){
            coin.reduceCoin(TURKEY_PRICE);
            GameFieldStorage.domesticatedAnimalHashSet.add(new Turkey());
            System.out.println("Turkey was bought");
            return true;
        }else {
    //        System.err.println("you need " + (TURKEY_PRICE - coin.getCoin()) + " more coins to buy Turkey");
            JOptionPane.showMessageDialog(null,"you need " + (TURKEY_PRICE - coin.getCoin()) + " more coins to buy Turkey","warning",JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
