package model.animals;

import java.util.Random;

public class Loin extends WildAnimal {
    public static final int LOIN_CAGES_NEEDED = 3;
    public static final int LOIN_SELL_PRICE = 300;

    public Loin() {
        super();
        animalName = "Loin";
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
        return animalName + " " + (LOIN_CAGES_NEEDED - currentCageNumber) + " " +"[" + (xCoordinate + 1) + " " + (yCoordinate + 1) + "]";
    }
}
