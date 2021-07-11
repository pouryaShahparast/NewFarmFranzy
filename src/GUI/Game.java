package GUI;
import ETC.Task1;
import controller.Entrance;
import controller.InGameManager;
import model.*;
import model.animals.*;
import model.commodities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game implements ActionListener {

    Timer timer;
    int time=0;
    JPanel panel;
    Coin coin;
    Well well;
    PickUpTruck pickUpTruck;
    Storeroom storeroom;
    InGameManager inGameManager;
    Task1 task;
    public Game(Task1 task) {
        this.task=task;
        coin = new Coin(Entrance.userInitialCoins);
        well = new Well();
        pickUpTruck = new PickUpTruck();
        storeroom = new Storeroom();
        inGameManager = new InGameManager(storeroom, coin, well, pickUpTruck);


         timer=new Timer(200,this);
         panel=new JPanel(null);
         panel.setBackground(new Color(164,98,70));
         panel.setOpaque(true);
         panel.setBounds(20,100,600,600);
         GUIEntrance.jFrame.add(panel);
         GUIEntrance.jFrame.revalidate();
         GUIEntrance.jFrame.repaint();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        time++;
        addWildAnimals(time);
        Entrance.userInitialCoins= coin.getCoin();
        addWildAnimals(inGameManager.turnsPassed);
        inGameManager.game();
        inGameManager.turnsPassed += 1;

        panel.revalidate();
        panel.repaint();

        if(checkIfNeededIsPreparedReturnBoolean())
        {
            timer.stop();
            //wins the game
        }







    }




    public boolean checkIfNeededIsPreparedReturnBoolean()
    {
        boolean f1=true,f2=true,f3=true,f4=true,f5=true,f6=true,f7=true;
        for (String string :
                task.neededCommodity.keySet()) {
            if (string.equalsIgnoreCase("bread")) {
                f1 = true;
                int amountNeeded = task.neededCommodity.get("bread");
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
                int amountNeeded = task.neededCommodity.get("cloth");
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
                int amountNeeded = task.neededCommodity.get("egg");
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
                int amountNeeded = task.neededCommodity.get("fabric");
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
                int amountNeeded = task.neededCommodity.get("feather");
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
                int amountNeeded = task.neededCommodity.get("flour");
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
                int amountNeeded = task.neededCommodity.get("ice cream");
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
                int amountNeeded = task.neededCommodity.get("milk");
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
                int amountNeeded = task.neededCommodity.get("pocket milk");
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
    public void addWildAnimals(int time)
    {

        for (String string :
                task.animalsAppearing.keySet()) {
            if(string.equalsIgnoreCase("tiger"))
            {
                for (Integer integer :
                        task.animalsAppearing.get("tiger")) {
                    if(time==integer)
                    {

                        GameFieldStorage.wildAnimalHashSet.add(new Tiger());
                    }
                }


            }


            if(string.equalsIgnoreCase("lion"))
            {
                for (Integer integer :
                        task.animalsAppearing.get("lion")) {
                    if(time==integer)
                    {

                        GameFieldStorage.wildAnimalHashSet.add(new Loin());
                    }
                }


            }
            if(string.equalsIgnoreCase("bear"))
            {
                for (Integer integer :
                        task.animalsAppearing.get("bear")) {
                    if(time==integer)
                    {

                        GameFieldStorage.wildAnimalHashSet.add(new Bear());
                    }
                }


            }


        }





    }

}
