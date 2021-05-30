package model.animals;


import java.util.Random;

public class Bear extends WildAnimal {
    public static final int BEAR_CAGES_NEEDED = 4;
    public static final int BEAR_SELL_PRICE = 400;

    public Bear() {
        super();
        animalName = "Bear";
    }

    @Override
    public boolean addCage() {
        if(!isCaged){
            currentCageNumber++;
            if(currentCageNumber >= BEAR_CAGES_NEEDED){
                isCaged = true;
            }
            isCagedInThisRound = true;
            return true;
        }
        return false;
    }

    public void move() {
        Random random = new Random();
        boolean canMove = false;
        while (!canMove){
            int a = random.nextInt(4);
            switch (a){
                case 0:
                    if(xCoordinate - 1 >= 0){
                        xCoordinate -= 1;
                        canMove = true;
                    }
                    break;
                case 1:
                    if(xCoordinate + 1 < 6){
                        xCoordinate += 1;
                        canMove = true;
                    }
                    break;
                case 2:
                    if (yCoordinate - 1 >= 0){
                        yCoordinate -= 1;
                        canMove = true;
                    }
                    break;
                case 3:
                    if (yCoordinate + 1 < 6){
                        yCoordinate += 1;
                        canMove = true;
                    }
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return animalName + " " + (BEAR_CAGES_NEEDED - currentCageNumber) + " " +"[" + (xCoordinate + 1) + " " + (yCoordinate + 1) + "]";
    }
}
