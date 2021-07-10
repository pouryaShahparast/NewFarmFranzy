package model.animals;

import inGamGraphics.Animation;
import inGamGraphics.Assets;

import java.awt.*;

public class Loin extends WildAnimal {
    public static final int LOIN_CAGES_NEEDED = 3;
    public static final int LOIN_SELL_PRICE = 300;
    public static int loinNumber = 0;

    public Loin() {
        super();
        loinNumber++;
        animalName = "Loin" + loinNumber;
        downAnimation = new Animation(300 , Assets.lionDown);
        upAnimation = new Animation(300 , Assets.lionUp);
        rightAnimation = new Animation(300 , Assets.lionRight);
        leftAnimation = new Animation(300 , Assets.lionLeft);
    }


    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentFrame() , xCoordinate , yCoordinate , ANIMAL_WIDTH , ANIMAL_HEIGHT , null);
    }

    @Override
    public boolean addCage() {
        if(!isCaged){
            currentCageNumber++;
            if(currentCageNumber >= LOIN_CAGES_NEEDED){
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
        return animalName + " " + (LOIN_CAGES_NEEDED - currentCageNumber) + " " +"[" + (xCoordinate + 1) + " " + (yCoordinate + 1) + "]";
    }
}
