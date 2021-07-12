package model.animals;


import inGamGraphics.Animation;
import inGamGraphics.Assets;

import java.awt.*;

public class Bear extends WildAnimal {
    public static final int BEAR_CAGES_NEEDED = 4;
    public static final int BEAR_SELL_PRICE = 400;
    public static int bearNumber = 0;

    public Bear() {
        super();
        bearNumber++;
        animalName = "Bear" + bearNumber;
        downAnimation = new Animation(300 , Assets.bearDown);
        upAnimation = new Animation(300 , Assets.bearUp);
        rightAnimation = new Animation(300 , Assets.bearRight);
        leftAnimation = new Animation(300 , Assets.bearLeft);
    }


    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentFrame() , xCoordinate , yCoordinate , ANIMAL_WIDTH , ANIMAL_HEIGHT , null);
        if(currentCageNumber > 0){
            graphics.drawImage(Assets.cage , xCoordinate , yCoordinate , ANIMAL_WIDTH , ANIMAL_HEIGHT , null);
        }
    }

    @Override
    public boolean addCage() {
        if(!isCaged){
            currentCageNumber++;
            if(currentCageNumber >= BEAR_CAGES_NEEDED){
                isCaged = true;
                System.out.println("the " + animalName + " got caged");
            }
            isCagedInThisRound = true;
            return true;
        }else {
            System.err.println("this " + animalName +" is already caged");
        }
        return false;
    }


    @Override
    public String toString() {
        return animalName + " " + (BEAR_CAGES_NEEDED - currentCageNumber) + " " +"[" + (xCoordinate + 1) + " " + (yCoordinate + 1) + "]";
    }
}
