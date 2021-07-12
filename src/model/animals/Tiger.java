package model.animals;


import inGamGraphics.Animation;
import inGamGraphics.Assets;

import java.awt.*;

public class Tiger extends WildAnimal{
    public static final int TIGER_CAGES_NEEDED = 4;
    public static final int TIGER_SELL_PRICE = 500;
    public static int tigerNumber = 0;



    public Tiger() {
        super();
        speed = DEFAULT_SPEED * 2;
        tigerNumber++;
        animalName = "Tiger" + tigerNumber;
        downAnimation = new Animation(300 , Assets.tigerDown);
        upAnimation = new Animation(300 , Assets.tigerUp);
        rightAnimation = new Animation(300 , Assets.tigerRight);
        leftAnimation = new Animation(300 , Assets.tigerLeft);
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
            if(currentCageNumber >= TIGER_CAGES_NEEDED){
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
        return animalName + " " + (TIGER_CAGES_NEEDED - currentCageNumber) + " " +"[" + (xCoordinate + 1) + " " + (yCoordinate + 1) + "]";
    }

}
