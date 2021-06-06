package model.animals;

import model.Coin;
import model.GameFieldStorage;

import java.util.Random;

public class Dog extends Animal{
    public static final int DOG_PRICE = 100;
    public static int dogNumber = 0;
    public boolean attackWildAnimal(){
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            if((xCoordinate == wildAnimal.getXCoordinate()) && (yCoordinate == wildAnimal.getYCoordinate())){
                GameFieldStorage.wildAnimalHashSet.remove(wildAnimal);
                return true;
            }
        }
        return false;
    }
    public static boolean buyDog(Coin coin){
        if(coin.hasEnoughCoins(DOG_PRICE)){
            coin.reduceCoin(DOG_PRICE);
            GameFieldStorage.dogHashSet.add(new Dog());
            System.out.println("Dog was bought");
            return true;
        }else {
            System.err.println("you need " + (DOG_PRICE - coin.getCoin()) + " more coins to buy Dog");
        }
        return false;
    }
    @Override
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
        return animalName + " " + "[" + (xCoordinate + 1) + " " + (yCoordinate + 1) +"]";
    }

    public Dog() {
        super();
        dogNumber++;
        animalName = "Dog" + dogNumber;
    }
}
