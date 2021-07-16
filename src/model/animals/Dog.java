package model.animals;

import inGamGraphics.Animation;
import inGamGraphics.Assets;
import model.Coin;
import model.GameFieldStorage;

import javax.swing.*;
import java.awt.*;

public class Dog extends Animal{
    public static final int DOG_PRICE = 100;
    public static int dogNumber = 0;
    public boolean attackWildAnimal(){
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            if(checkForCollision(wildAnimal.getCollisionBounds())){
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
   //         System.err.println("you need " + (DOG_PRICE - coin.getCoin()) + " more coins to buy Dog");
            JOptionPane.showMessageDialog(null,"you need " + (DOG_PRICE - coin.getCoin()) + " more coins to buy Dog" ,"warning",JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    @Override
    public void move() {
        randomMove();
    }

    @Override
    public String toString() {
        return animalName + " " + "[" + (xCoordinate + 1) + " " + (yCoordinate + 1) +"]";
    }

    public Dog() {
        super();
        dogNumber++;
        animalName = "Dog" + dogNumber;
        downAnimation = new Animation(300 , Assets.dogDown);
        upAnimation = new Animation(300 , Assets.dogUp);
        rightAnimation = new Animation(300 , Assets.dogRight);
        leftAnimation = new Animation(300 , Assets.dogLeft);
    }

    @Override
    public void shortTick() {
        getCurrentAnimation().tick();
        move();
    }

    @Override
    public void longTick() {
//  GameFieldStorage.dogHashSet.removeIf(Dog::attackWildAnimal);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentFrame() , xCoordinate , yCoordinate , ANIMAL_WIDTH , ANIMAL_HEIGHT , null);
    }
}
