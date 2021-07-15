package inGamGraphics;

import GUI.Game;
import GUI.LevelPanel;
import GUI.UserPassController;
import controller.Entrance;
import model.*;
import model.animals.*;
import model.commodities.*;
import model.factories.Factory;

import javax.swing.*;
import java.awt.*;

public class GameState extends State{
    public static GameState gameState;
    Program program;
    Coin coin;
    Well well;
    PickUpTruck pickUpTruck;
    Storeroom storeroom;
    int a = 0;
    int turn = 0;


    public GameState(Program program) {
        this.coin = GameFieldStorage.coin;
        this.well = GameFieldStorage.well;
        this.pickUpTruck = GameFieldStorage.pickUpTruck;
        this.storeroom = GameFieldStorage.storeroom;
        this.program = program;
    }

    @Override
    public void tick() {
        a++;
        shortTick();
        if(a % 45 == 0){
            longTick();
            turn++;
            addWildAnimals(turn);
            if(checkIfNeededIsPreparedReturnBoolean())
            {
                //stop game
                program.setRunning(false);
                Entrance.userInitialCoins=GameFieldStorage.coin.getCoin();
                UserPassController.user.coins=GameFieldStorage.coin.getCoin();
                if(turn<=Game.task.firstStandardTime)
                {
                    Entrance.userInitialCoins+=Game.task.firstBonus;
                    UserPassController.user.coins+=Game.task.firstBonus;
                    JOptionPane.showMessageDialog(null ,"game ended   Gold Medal" , "game message" , JOptionPane.PLAIN_MESSAGE);
                }
               else if(turn<=Game.task.secondStandardTime)
                {
                    Entrance.userInitialCoins+=Game.task.secondBonus;
                    UserPassController.user.coins+=Game.task.secondBonus;
                    JOptionPane.showMessageDialog(null ,"game ended   silver Medal" , "game message" , JOptionPane.PLAIN_MESSAGE);
                }
                else{

                    JOptionPane.showMessageDialog(null ,"game ended" , "game message" , JOptionPane.PLAIN_MESSAGE);
                }





                if(Entrance.levelOfUser<=LevelPanel.level)
                {

                    Entrance.levelOfUser=LevelPanel.level+1;
                    UserPassController.user.level=LevelPanel.level+1 ;

                }
              Entrance.saveUserInfo(UserPassController.user.name);










            }





            a = 0;
        }
    }
    public void init(){
//     GameFieldStorage.domesticatedAnimalHashSet.add(new Buffalo());
//     GameFieldStorage.domesticatedAnimalHashSet.add(new Chicken());
//     GameFieldStorage.catHashSet.add(new Cat());
//     GameFieldStorage.wildAnimalHashSet.add(new Bear());
    }
    private void shortTick(){
        Cell.tickWorld();
        //cat
        for (Cat cat : GameFieldStorage.catHashSet) {
            cat.shortTick();
            cat.pickupCommodity(storeroom);
        }
        //dog
        for (Dog dog : GameFieldStorage.dogHashSet) {
            dog.shortTick();
        }
        GameFieldStorage.dogHashSet.removeIf(Dog::attackWildAnimal);
        //wild animal
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.shortTick();
        }
        //domesticated animal
        DomesticatedAnimal.domesticatedAnimalEat();
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.shortTick();
        }

    }

    private void longTick(){
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //cat
        for (Cat cat : GameFieldStorage.catHashSet) {
            cat.longTick();
            cat.pickupCommodity(storeroom);
        }
        //dog
        for (Dog dog : GameFieldStorage.dogHashSet) {
            dog.longTick();
        }

        //wild animal
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.longTick();
        }
        GameFieldStorage.wildAnimalHashSet.removeIf(WildAnimal::maxTurnsInfieldReached);
        //domesticated animal
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.longTick();
        }
        GameFieldStorage.domesticatedAnimalHashSet.removeIf(domesticatedAnimal -> domesticatedAnimal.getHealth() <= 0);
        //commodity
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            commodity.addTurnsInField();
        }

        GameFieldStorage.commodityHashSet.removeIf(Commodity::maxTurnsInfieldReached);
        //factory
        for (Factory factory : GameFieldStorage.factoryHashSet) {
            factory.makeOneCommodityWithTurn();
            factory.makeTwoCommodityWithTurn();
        }
        //truck
        pickUpTruck.sellWithTurns(coin);
        //well
        well.getWaterWithTurns();
    }

    @Override
    public void render(Graphics graphics) {
        Cell.renderWorld(graphics);
        for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
            domesticatedAnimal.render(graphics);
        }
        for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
            wildAnimal.render(graphics);
        }
        for (Dog dog : GameFieldStorage.dogHashSet) {
            dog.render(graphics);
        }
        for (Cat cat : GameFieldStorage.catHashSet) {
            cat.render(graphics);
        }
        for (Commodity commodity : GameFieldStorage.commodityHashSet) {
            commodity.render(graphics);
        }
    }

    public int getTurn() {
        return turn;
    }
    
///add wildAnimal
public void addWildAnimals(int time)
{

    for (String string :
            Game.task.animalsAppearing.keySet()) {
        if(string.equalsIgnoreCase("tiger"))
        {
            for (Integer integer :
                    Game.task.animalsAppearing.get("tiger")) {
                if(time==integer)
                {

                    GameFieldStorage.wildAnimalHashSet.add(new Tiger());
                }
            }


        }


        if(string.equalsIgnoreCase("lion"))
        {
            for (Integer integer :
                    Game.task.animalsAppearing.get("lion")) {
                if(time==integer)
                {

                    GameFieldStorage.wildAnimalHashSet.add(new Loin());
                }
            }


        }
        if(string.equalsIgnoreCase("bear"))
        {
            for (Integer integer :
                    Game.task.animalsAppearing.get("bear")) {
                if(time==integer)
                {

                    GameFieldStorage.wildAnimalHashSet.add(new Bear());
                }
            }


        }


    }





}
 ///check 

    public boolean checkIfNeededIsPreparedReturnBoolean()
    {
        boolean f1=true,f2=true,f3=true,f4=true,f5=true,f6=true,f7=true;
        for (String string :
                Game.task.neededCommodity.keySet()) {
            if (string.equalsIgnoreCase("bread")) {
                f1 = true;
                int amountNeeded = Game.task.neededCommodity.get("bread");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Bread)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f1 = true;
                } else {

                    f1 = false;

                }

            }


            if (string.equalsIgnoreCase("cloth")) {
                f2 = true;
                int amountNeeded = Game.task.neededCommodity.get("cloth");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Cloth)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f2 = true;
                } else {

                    f2 = false;

                }

            }
            if (string.equalsIgnoreCase("egg")) {
                f2 = true;
                int amountNeeded = Game.task.neededCommodity.get("egg");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Egg)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f2 = true;
                } else {

                    f2 = false;

                }
            }
            if (string.equalsIgnoreCase("fabric")) {
                f3 = true;
                int amountNeeded = Game.task.neededCommodity.get("fabric");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Fabric)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f3 = true;
                } else {

                    f3 = false;

                }
            }

            if (string.equalsIgnoreCase("feather")) {
                f3 = true;
                int amountNeeded = Game.task.neededCommodity.get("feather");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Feather)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f3 = true;
                } else {

                    f3 = false;

                }
            }
            if (string.equalsIgnoreCase("flour")) {
                f4 = true;
                int amountNeeded = Game.task.neededCommodity.get("flour");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Flour)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f4 = true;
                } else {

                    f4 = false;

                }
            }
            if (string.equalsIgnoreCase("ice cream")) {
                f5 = true;
                int amountNeeded = Game.task.neededCommodity.get("ice cream");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof IceCream)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f5 = true;
                } else {

                    f5 = false;

                }
            }
            if (string.equalsIgnoreCase("milk")) {
                f6 = true;
                int amountNeeded = Game.task.neededCommodity.get("milk");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Milk)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f6 = true;
                } else {

                    f6 = false;

                }
            }
            if (string.equalsIgnoreCase("pocket milk")) {
                f7 = true;
                int amountNeeded = Game.task.neededCommodity.get("pocket milk");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof PocketMilk)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    f7 = true;
                } else {

                    f7 = false;

                }
            }


        }

        return (f1&&f2&&f3&&f4&&f5&&f6&&f7);






    }





}
