import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.InGameManager;
import model.*;
import model.animals.*;
import model.commodities.*;
import model.factories.*;

public class Regex {

    Coin coin;
    Well well;
    PickUpTruck pickUpTruck;
    Storeroom storeroom;
    InGameManager inGameManager;
    Task1 task;
    //patterns

    Pattern pattern1;
    Pattern pattern2;
    Pattern pattern3;
    Pattern pattern4;
    Pattern pattern5;
    Pattern pattern6;
    Pattern pattern7;
    Pattern pattern8;
    Pattern pattern9;
    Pattern pattern10;
    Pattern pattern11;
    Pattern pattern12;
    Pattern pattern13;
    Pattern pattern14;
    Pattern pattern15;
    //matchers
    Matcher matcher1;
    Matcher matcher2;
    Matcher matcher3;
    Matcher matcher4;
    Matcher matcher5;
    Matcher matcher6;
    Matcher matcher7;
    Matcher matcher8;
    Matcher matcher9;
    Matcher matcher10;
    Matcher matcher11;
    Matcher matcher12;
    Matcher matcher13;
    Matcher matcher14;
    Matcher matcher15;



    public Regex(Task1 task) {
        this.task=task;
        coin = new Coin(Entrance.userInitialCoins);
        well = new Well();
        pickUpTruck = new PickUpTruck();
        storeroom = new Storeroom();
        inGameManager = new InGameManager(storeroom, coin, well, pickUpTruck);

    }

    public void matcher(String input) {

        //buy
        pattern1 = Pattern.compile("\\s*(?i:buy)\\s*\\[?\\s*(\\w+)\\s*\\]?\\s*$");
        //pickup
        pattern2 = Pattern.compile("\\s*(?i:pickup)\\s*\\[?\\s*(\\d+)\\s+(\\d+)\\s*\\]?\\s*$");
        //well
        pattern3 = Pattern.compile("\\s*(?i:well)\\s*$");
        //plant x y
        pattern4 = Pattern.compile("\\s*(?i:plant)\\s*\\[?\\s*(\\d+)\\s+(\\d+)\\s*\\]?\\s*$");
        //work
        pattern5 = Pattern.compile("\\s*(?i:work)\\s*\\[?\\s*(\\w+)\\s*\\]?\\s*$");
        //cage x y
        pattern6 = Pattern.compile("\\s*(?i:cage)\\s*\\[?\\s*(\\d+)\\s+(\\d+)\\s*\\]?\\s*$");
        //turn
        pattern7 = Pattern.compile("\\s*(?i:turn)\\s*\\[?\\s*(\\d+)\\s*\\]?\\s*$");
        //truck load
        pattern8 = Pattern.compile("\\s*(?i:truck)\\s*(?i:load)\\[?\\s*(\\w+)\\s*\\]?\\s*$");
        //truck unload
        pattern9 = Pattern.compile("\\s*(?i:truck)\\s*(?i:unload)\\[?\\s*(\\w+)\\s*\\]?\\s*$");
        //truck go
        pattern10 = Pattern.compile("\\s*(?i:truck)\\s*(?i:go)\\s*$");
        ////exit
        pattern11 = Pattern.compile("\\s*(?i:exit)\\s*$");
        ///inquiry
        pattern12 = Pattern.compile("\\s*(?i:inquiry)\\s*$");
        ///upgrade
        pattern13 = Pattern.compile("\\s*(?i:upgrade)\\s*(\\w+)\\s*$");
        ///build factory
        pattern14 = Pattern.compile("\\s*(?i:build)\\s*(\\w+)\\s*$");
        ///work with two commodity
        pattern15 = Pattern.compile("\\s*(?i:work+)\\s*\\[?\\s*(\\w+)\\s*\\]?\\s*$");
        /////////////////////////////////////////////////////////////
        matcher1 = pattern1.matcher(input);
        matcher2 = pattern2.matcher(input);
        matcher3 = pattern3.matcher(input);
        matcher4 = pattern4.matcher(input);
        matcher5 = pattern5.matcher(input);
        matcher6 = pattern6.matcher(input);
        matcher7 = pattern7.matcher(input);
        matcher8 = pattern8.matcher(input);
        matcher9 = pattern9.matcher(input);
        matcher10 = pattern10.matcher(input);
        matcher11 = pattern11.matcher(input);
        matcher12 = pattern12.matcher(input);
        matcher13 = pattern13.matcher(input);
        matcher14 = pattern14.matcher(input);
        matcher15 = pattern15.matcher(input);
//////////////////////////

        if (matcher1.find()) {


            if ((matcher1.group(1).equalsIgnoreCase("cat"))) {
                Cat.buyCat(coin);

            } else if ((matcher1.group(1).equalsIgnoreCase("buffalo"))) {
                Buffalo.buyBuffalo(coin);

            } else if ((matcher1.group(1).equalsIgnoreCase("chicken"))) {
                Chicken.buyChicken(coin);

            } else if ((matcher1.group(1).equalsIgnoreCase("turkey"))) {

                Turkey.buyTurkey(coin);

            } else if ((matcher1.group(1).equalsIgnoreCase("dog"))) {

                Dog.buyDog(coin);

            } else {
                System.out.println(ConsoleColors.RED + "INVALID INPUT(can't find an animal with this name)" + ConsoleColors.RESET);

            }


        }

        ////////////////////////////////////////

        else if (matcher2.find()) {
            int x_coordinate, y_coordinate;
            x_coordinate = Integer.parseInt(matcher2.group(1));
            y_coordinate = Integer.parseInt(matcher2.group(2));
            if ((x_coordinate >= 7) || (x_coordinate <= 0) || (y_coordinate >= 7) || (y_coordinate <= 0)) {
                System.out.println(ConsoleColors.RED + "INVALID INPUT (coordinate out of range)" + ConsoleColors.RESET);
                return;

            }
            boolean found = false;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if ((commodity.getXCoordinate() == x_coordinate) && (commodity.getYCoordinate() == y_coordinate)) {
                    found = true;
                    if (storeroom.store(commodity)) {
                        break;
                    }


                }


            }
            if (!found) {
                System.out.println(ConsoleColors.RED + "INVALID INPUT (there is no commodity in this coordinate)" + ConsoleColors.RESET);

            }


        }
        ////////////////////////////////
        else if (matcher3.find()) {

            well.startGettingWater();


        }
        /////////////////////////////
       else if (matcher4.find()) {
            int x_coordinate, y_coordinate;
            x_coordinate = Integer.parseInt(matcher4.group(1));
            y_coordinate = Integer.parseInt(matcher4.group(2));
            if ((x_coordinate >= 7) || (x_coordinate <= 0) || (y_coordinate >= 7) || (y_coordinate <= 0)) {
                System.out.println(ConsoleColors.RED + "INVALID INPUT (coordinate out of range)" + ConsoleColors.RESET);
                return;

            }


            well.makeGrass(x_coordinate, y_coordinate);


        }
        ///////////////////////////////////

        else if (matcher5.find()) {
            String factoryName = matcher5.group(1);
            if (factoryName.equalsIgnoreCase("bakery")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Bakery) {
                        found = true;
                        factory.startWorkingOneCommodity(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create bakery factory" + ConsoleColors.RESET);
                }


            } else if (factoryName.equalsIgnoreCase("mill")) {

                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Mill) {
                        found = true;
                        factory.startWorkingOneCommodity(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create mill" + ConsoleColors.RESET);
                }


            } else if (factoryName.equalsIgnoreCase("milk pocketing production")) {

                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof MilkPocketingProduction) {
                        found = true;
                        factory.startWorkingOneCommodity(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create milk pocketing production factory" + ConsoleColors.RESET);
                }


            } else if (factoryName.equalsIgnoreCase("ice cream maker")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof IceCreamMaker) {
                        found = true;
                        factory.startWorkingOneCommodity(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create ice cream maker factory" + ConsoleColors.RESET);
                }


            } else if (factoryName.equalsIgnoreCase("tailoring")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Tailoring) {
                        found = true;
                        factory.startWorkingOneCommodity(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create tailoring factory" + ConsoleColors.RESET);
                }

            } else if (factoryName.equalsIgnoreCase("fabric production")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof FabricProduction) {
                        found = true;
                        factory.startWorkingOneCommodity(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create fabric production factory" + ConsoleColors.RESET);
                }

            } else {

                System.out.println(ConsoleColors.RED + "INVALID INPUT (coordinate out of range)" + ConsoleColors.RESET);

            }


        }
        ////////////////////////////////////////
       else if (matcher6.find()) {
            boolean found = false;
            int x_coordinate, y_coordinate;
            x_coordinate = Integer.parseInt(matcher6.group(1));
            y_coordinate = Integer.parseInt(matcher6.group(2));
            if ((x_coordinate >= 7) || (x_coordinate <= 0) || (y_coordinate >= 7) || (y_coordinate <= 0)) {
                System.out.println(ConsoleColors.RED + "INVALID INPUT (coordinate out of range)" + ConsoleColors.RESET);
                return;

            }
            for (WildAnimal wildanimal :
                    GameFieldStorage.wildAnimalHashSet) {
                if ((x_coordinate == wildanimal.getXCoordinate()) && (y_coordinate == wildanimal.getYCoordinate())) {
                    found = true;
                    if (wildanimal instanceof Bear) {

                        ((Bear) wildanimal).addCage();

                    }
                    if (wildanimal instanceof Tiger) {

                        ((Tiger) wildanimal).addCage();

                    }
                    if (wildanimal instanceof Loin) {

                        ((Loin) wildanimal).addCage();

                    }


                }


            }

            if (!found) {
                System.out.println(ConsoleColors.RED + "INVALID INPUT (there is no animal in this coordinate)" + ConsoleColors.RESET);
            }


        }
        //////////////////////////////////////
        else if (matcher7.find()) {

            for (String string :
                    task.animalsAppearing.keySet()) {
                System.out.println(string);
                System.out.println(task.animalsAppearing.get(string));
            }





            int n = Integer.parseInt(matcher7.group(1));
            if (n <= 0) {
                System.out.println(ConsoleColors.RED + "INVALID INPUT (incorrect time)" + ConsoleColors.RESET);
                return;
            }
            for (int i = 0; (i < n)&&(!checkIfNeededIsPreparedReturnBoolean()); i++) {


                //System.out.println("hey");
                addWildAnimals(i);
                inGameManager.game();
                inGameManager.turnsPassed += 1;







            }
            System.out.println(ConsoleColors.RED + "****************************************************************************************************" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "                                         turn   " + ConsoleColors.CYAN_ + inGameManager.turnsPassed + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLACK);
            inGameManager.show();
            checkIfNeededIsPrepared();
            System.out.println(ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "****************************************************************************************************" + ConsoleColors.RESET);
            if(!checkIfNeededIsPreparedReturnBoolean())
            {
                Entrance.isGameRunning=false;
                return;
            }

        }
        ///////////////////
       else  if (matcher8.find()) {
            String name = matcher8.group(1);
            if (name.equalsIgnoreCase("egg")) {
                boolean found = false;

                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Egg) {
                        found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }

                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                }


            } else if (name.equalsIgnoreCase("bread")) {

                boolean found = false;

                for (Commodity commodity :
                       storeroom.commodityHashSet) {
                    if (commodity instanceof Bread) {
                         found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }
                    if (!found) {
                        System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                    }

                }



            } else if (name.equalsIgnoreCase("cloth")) {

                boolean found = false;

                for (Commodity commodity :
                      storeroom.commodityHashSet) {
                    if (commodity instanceof Cloth) {
                        found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                }


            } else if (name.equalsIgnoreCase("fabric")) {

                boolean found = false;

                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Fabric) {
                        found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                }


            } else if (name.equalsIgnoreCase("feather")) {

                boolean found = false;

                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Feather) {
                        found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                }


            } else if (name.equalsIgnoreCase("flour")) {

                boolean found = false;

                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Flour) {
                        found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                }


            } else if (name.equalsIgnoreCase("ice cream")) {

                boolean found = false;

                for (Commodity commodity :
                       storeroom.commodityHashSet) {
                    if (commodity instanceof IceCream) {
                        found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                }


            } else if (name.equalsIgnoreCase("milk")) {

                boolean found = false;

                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Milk) {
                        found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                }


            } else if (name.equalsIgnoreCase("pocket milk")) {

                boolean found = false;

                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof PocketMilk) {
                        found = true;
                        pickUpTruck.pickUp(commodity);
                        storeroom.commodityHashSet.remove(commodity);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

                }


            }

            else if (name.equalsIgnoreCase("tiger")) {

                boolean found = false;

                for (WildAnimal wildAnimal :
                        storeroom.wildAnimalHashSet) {
                    if (wildAnimal instanceof Tiger) {
                        found = true;
                        pickUpTruck.pickUp(wildAnimal);
                        storeroom.wildAnimalHashSet.remove(wildAnimal);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no animal with this name" + ConsoleColors.RESET);

                }


            }

            else if (name.equalsIgnoreCase("bear")) {

                boolean found = false;

                for (WildAnimal wildAnimal :
                        storeroom.wildAnimalHashSet) {
                    if (wildAnimal instanceof Bear) {
                        found = true;
                        pickUpTruck.pickUp(wildAnimal);
                        storeroom.wildAnimalHashSet.remove(wildAnimal);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no animal with this name" + ConsoleColors.RESET);

                }


            }
            else if (name.equalsIgnoreCase("lion")) {

                boolean found = false;

                for (WildAnimal wildAnimal :
                        storeroom.wildAnimalHashSet) {
                    if (wildAnimal instanceof Loin) {
                        found = true;
                        pickUpTruck.pickUp(wildAnimal);
                        storeroom.wildAnimalHashSet.remove(wildAnimal);
                        break;


                    }


                }

                if (!found) {
                    System.out.println(ConsoleColors.RED + "there is no animal with this name" + ConsoleColors.RESET);

                }


            }





            else {
                System.out.println(ConsoleColors.RED + "INVALID INPUT (there is no commodity with this name)" + ConsoleColors.RESET);
            }


        }



    //////////////////////
        else if(matcher9.find())

    {

        String name=matcher9.group(1);
        if (name.equalsIgnoreCase("egg")) {

            pickUpTruck.reStoreEggFromTruck(storeroom);


        } else if (name.equalsIgnoreCase("bread")) {

            pickUpTruck.reStoreBreadFromTruck(storeroom);

        } else if (name.equalsIgnoreCase("cloth")) {

           pickUpTruck.reStoreClothFromTruck(storeroom);


        } else if (name.equalsIgnoreCase("fabric")) {

           pickUpTruck.reStoreFabricFromTruck(storeroom);


        } else if (name.equalsIgnoreCase("feather")) {
             pickUpTruck.reStoreFeatherFromTruck(storeroom);


        } else if (name.equalsIgnoreCase("flour")) {

           pickUpTruck.reStoreFlourFromTruck(storeroom);


        } else if (name.equalsIgnoreCase("ice cream")) {
         pickUpTruck.reStoreIceCreamFromTruck(storeroom);


        } else if (name.equalsIgnoreCase("milk")) {
pickUpTruck.reStoreMilkFromTruck(storeroom);


        } else if (name.equalsIgnoreCase("pocket milk")) {

           pickUpTruck.reStorePocketMilkFromTruck(storeroom);


        }
        else if (name.equalsIgnoreCase("tiger")) {

            pickUpTruck.reStoreTigerFromTruck(storeroom);


        }
        else if (name.equalsIgnoreCase("lion")) {

            pickUpTruck.reStoreLoinFromTruck(storeroom);


        }
        else if (name.equalsIgnoreCase("bear")) {

            pickUpTruck.reStoreBearFromTruck(storeroom);


        }

        else {
            System.out.println(ConsoleColors.RED + "INVALID INPUT (there is no commodity with this name)" + ConsoleColors.RESET);
        }










    }
//////////////////////////
      else if(matcher10.find())

    {

       pickUpTruck.startTraveling();


    }

////////////////////
       else if(matcher11.find())
        {
            Entrance.isGameRunning=false;
            return;

        }

 /////////////////
       else if(matcher12.find())
        {

            System.out.println(ConsoleColors.RED + "****************************************************************************************************" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "                                         turn   " + ConsoleColors.CYAN_ + inGameManager.turnsPassed + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLACK);
            inGameManager.show();
            System.out.println(ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "****************************************************************************************************" + ConsoleColors.RESET);



        }
        ////////////////////////
       else if(matcher14.find())
        {
            String factoryName=matcher14.group(1);
            if (factoryName.equalsIgnoreCase("bakery")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Bakery) {
                        found = true;
                        System.out.println(ConsoleColors.RED+"Already exists"+ConsoleColors.RESET);
                        break;

                    }
                }
                if (!found) {
                    Bakery.buildBakery(coin);

                }


            } else if (factoryName.equalsIgnoreCase("mill")) {

                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Mill) {
                        found = true;
                        System.out.println(ConsoleColors.RED+"Already exists"+ConsoleColors.RESET);
                        break;


                    }
                }
                if (!found) {
                   Mill.buildMill(coin);
                }


            } else if (factoryName.equalsIgnoreCase("milk pocketing production")) {

                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof MilkPocketingProduction) {
                        found = true;
                        System.out.println(ConsoleColors.RED+"Already exists"+ConsoleColors.RESET);
                        break;

                    }
                }
                if (!found) {
                    MilkPocketingProduction.buildMilkPocketingProduction(coin);
                }


            } else if (factoryName.equalsIgnoreCase("ice cream maker")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof IceCreamMaker) {
                        found = true;
                        System.out.println(ConsoleColors.RED+"Already exists"+ConsoleColors.RESET);
                        break;

                    }
                }
                if (!found) {
                IceCreamMaker.buildIceCreamMaker(coin);
                }


            } else if (factoryName.equalsIgnoreCase("tailoring")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Tailoring) {
                        found = true;
                        System.out.println(ConsoleColors.RED+"Already exists"+ConsoleColors.RESET);
                        break;
                    }
                }
                if (!found) {
                Tailoring.buildTailoring(coin);
                }

            } else if (factoryName.equalsIgnoreCase("fabric production")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof FabricProduction) {
                        found = true;
                        System.out.println(ConsoleColors.RED+"Already exists"+ConsoleColors.RESET);
                        break;
                    }
                }
                if (!found) {
                FabricProduction.buildFabricProduction(coin);
                }

            } else {

                System.out.println(ConsoleColors.RED + "INVALID INPUT (there is no factory with this name)" + ConsoleColors.RESET);

            }





        }

       else if(matcher13.find())
        {
                String factoryName = matcher13.group(1);
                if (factoryName.equalsIgnoreCase("bakery")) {
                    boolean found = false;

                    for (Factory factory :
                            GameFieldStorage.factoryHashSet) {
                        if (factory instanceof Bakery) {
                            found = true;
                            factory.upgrade(coin);
                            break;

                        }
                    }
                    if (!found) {
                        System.out.println(ConsoleColors.RED + "factory doesn't exist  first create bakery factory" + ConsoleColors.RESET);
                    }


                } else if (factoryName.equalsIgnoreCase("mill")) {

                    boolean found = false;

                    for (Factory factory :
                            GameFieldStorage.factoryHashSet) {
                        if (factory instanceof Mill) {
                            found = true;
                            factory.upgrade(coin);
                            break;

                        }
                    }
                    if (!found) {
                        System.out.println(ConsoleColors.RED + "factory doesn't exist  first create mill" + ConsoleColors.RESET);
                    }


                } else if (factoryName.equalsIgnoreCase("milk pocketing production")) {

                    boolean found = false;

                    for (Factory factory :
                            GameFieldStorage.factoryHashSet) {
                        if (factory instanceof MilkPocketingProduction) {
                            found = true;
                            factory.upgrade(coin);
                            break;

                        }
                    }
                    if (!found) {
                        System.out.println(ConsoleColors.RED + "factory doesn't exist  first create milk pocketing production factory" + ConsoleColors.RESET);
                    }


                } else if (factoryName.equalsIgnoreCase("ice cream maker")) {
                    boolean found = false;

                    for (Factory factory :
                            GameFieldStorage.factoryHashSet) {
                        if (factory instanceof IceCreamMaker) {
                            found = true;
                            factory.upgrade(coin);
                            break;

                        }
                    }
                    if (!found) {
                        System.out.println(ConsoleColors.RED + "factory doesn't exist  first create ice cream maker factory" + ConsoleColors.RESET);
                    }


                } else if (factoryName.equalsIgnoreCase("tailoring")) {
                    boolean found = false;

                    for (Factory factory :
                            GameFieldStorage.factoryHashSet) {
                        if (factory instanceof Tailoring) {
                            found = true;
                            factory.upgrade(coin);
                            break;

                        }
                    }
                    if (!found) {
                        System.out.println(ConsoleColors.RED + "factory doesn't exist  first create tailoring factory" + ConsoleColors.RESET);
                    }

                } else if (factoryName.equalsIgnoreCase("fabric production")) {
                    boolean found = false;

                    for (Factory factory :
                            GameFieldStorage.factoryHashSet) {
                        if (factory instanceof FabricProduction) {
                            found = true;
                            factory.upgrade(coin);
                            break;

                        }
                    }
                    if (!found) {
                        System.out.println(ConsoleColors.RED + "factory doesn't exist  first create fabric production factory" + ConsoleColors.RESET);
                    }

                } else {

                    System.out.println(ConsoleColors.RED + "INVALID INPUT (coordinate out of range)" + ConsoleColors.RESET);

                }







        }
       else if(matcher15.find())
        {
            String factoryName = matcher15.group(1);
            if (factoryName.equalsIgnoreCase("bakery")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Bakery) {
                        found = true;
                        factory.startWorkingTwoCommodities(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create bakery factory" + ConsoleColors.RESET);
                }


            } else if (factoryName.equalsIgnoreCase("mill")) {

                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Mill) {
                        found = true;
                        factory.startWorkingTwoCommodities(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create mill" + ConsoleColors.RESET);
                }


            } else if (factoryName.equalsIgnoreCase("milk pocketing production")) {

                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof MilkPocketingProduction) {
                        found = true;
                        factory.startWorkingTwoCommodities(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create milk pocketing production factory" + ConsoleColors.RESET);
                }


            } else if (factoryName.equalsIgnoreCase("ice cream maker")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof IceCreamMaker) {
                        found = true;
                        factory.startWorkingTwoCommodities(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create ice cream maker factory" + ConsoleColors.RESET);
                }


            } else if (factoryName.equalsIgnoreCase("tailoring")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof Tailoring) {
                        found = true;
                        factory.startWorkingTwoCommodities(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create tailoring factory" + ConsoleColors.RESET);
                }

            } else if (factoryName.equalsIgnoreCase("fabric production")) {
                boolean found = false;

                for (Factory factory :
                        GameFieldStorage.factoryHashSet) {
                    if (factory instanceof FabricProduction) {
                        found = true;
                        factory.startWorkingTwoCommodities(storeroom);
                        break;

                    }
                }
                if (!found) {
                    System.out.println(ConsoleColors.RED + "factory doesn't exist  first create fabric production factory" + ConsoleColors.RESET);
                }

            } else {

                System.out.println(ConsoleColors.RED + "INVALID INPUT (coordinate out of range)" + ConsoleColors.RESET);

            }







        }
       else
        {
            System.out.println(ConsoleColors.RED+"INVALID"+ConsoleColors.RESET);
        }



    }

public void addWildAnimals(int n)
{

    for (String string :
            task.animalsAppearing.keySet()) {
        if(string.equalsIgnoreCase("tiger"))
        {
            for (Integer integer :
                    task.animalsAppearing.get("tiger")) {
                if(n==integer)
                {

                    GameFieldStorage.wildAnimalHashSet.add(new Tiger());
                }
            }   
            
            
        }


        if(string.equalsIgnoreCase("lion"))
        {
            for (Integer integer :
                    task.animalsAppearing.get("lion")) {
                if(n==integer)
                {

                    GameFieldStorage.wildAnimalHashSet.add(new Loin());
                }
            }


        }
        if(string.equalsIgnoreCase("bear"))
        {
            for (Integer integer :
                    task.animalsAppearing.get("bear")) {
                if(n==integer)
                {

                    GameFieldStorage.wildAnimalHashSet.add(new Bear());
                }
            }


        }


    }


    
    
    
}
public boolean checkIfNeededIsPrepared()
{
    boolean f1=true,f2=true,f3=true,f4=true,f5=true,f6=true,f7=true;
    for (String string :
            task.neededCommodity.keySet()) {
        if (string.equalsIgnoreCase("braed")) {
            f1 = true;
            int amountNeeded = task.neededCommodity.get("bread");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof Bread)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of Bread is complete");
                System.out.println("Bread " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f1 = true;
            } else {
                System.out.println("Bread " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f1 = false;

            }

        }


        if (string.equalsIgnoreCase("cloth")) {
            f2 = true;
            int amountNeeded = task.neededCommodity.get("cloth");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof Cloth)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of Cloth is complete");
                System.out.println("Cloth " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f2 = true;
            } else {
                System.out.println("Cloth "+ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f2 = false;

            }

        }
        if (string.equalsIgnoreCase("egg")) {
            f2 = true;
            int amountNeeded = task.neededCommodity.get("egg");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof Egg)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of Egg is complete");
                System.out.println("Egg " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f2 = true;
            } else {
                System.out.println("Egg " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f2 = false;

            }
        }
        if (string.equalsIgnoreCase("fabric")) {
            f3 = true;
            int amountNeeded = task.neededCommodity.get("fabric");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof Fabric)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of Fabric is complete");
                System.out.println("Fabric " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f3 = true;
            } else {
                System.out.println("Fabric " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f3 = false;

            }
        }

        if (string.equalsIgnoreCase("feather")) {
            f3 = true;
            int amountNeeded = task.neededCommodity.get("feather");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof Feather)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of Feather is complete");
                System.out.println("Feather " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f3 = true;
            } else {
                System.out.println("Feather " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f3 = false;

            }
        }
        if (string.equalsIgnoreCase("flour")) {
            f4 = true;
            int amountNeeded = task.neededCommodity.get("flour");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof Flour)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of Flour is complete");
                System.out.println("Flour " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f4 = true;
            } else {
                System.out.println("Flour " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f4 = false;

            }
        }
        if (string.equalsIgnoreCase("ice cream")) {
            f5 = true;
            int amountNeeded = task.neededCommodity.get("ice cream");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof IceCream)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of ice cream is complete");
                System.out.println("ice cream " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f5 = true;
            } else {
                System.out.println("ice cream " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f5 = false;

            }
        }
        if (string.equalsIgnoreCase("milk")) {
            f6 = true;
            int amountNeeded = task.neededCommodity.get("Milk");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof Milk)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of Milk is complete");
                System.out.println("Milk " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f6 = true;
            } else {
                System.out.println("Milk " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f6 = false;

            }
        }
        if (string.equalsIgnoreCase("pocket milk")) {
            f7 = true;
            int amountNeeded = task.neededCommodity.get("pocket milk");
            int amountExisting = 0;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
                if (commodity instanceof PocketMilk)
                    amountExisting++;
            }
            if (amountExisting >= amountNeeded) {
                System.out.println("amount of Pocket milk is complete");
                System.out.println("Pocket milk " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f7 = true;
            } else {
                System.out.println("Pocket milk " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                f7 = false;

            }
        }


    }

return (f1&&f2&&f3&&f4&&f5&&f6&&f7);






}

    public boolean checkIfNeededIsPreparedReturnBoolean()
    {
        boolean f1=true,f2=true,f3=true,f4=true,f5=true,f6=true,f7=true;
        for (String string :
                task.neededCommodity.keySet()) {
            if (string.equalsIgnoreCase("braed")) {
                f1 = true;
                int amountNeeded = task.neededCommodity.get("bread");
                int amountExisting = 0;
                for (Commodity commodity :
                        GameFieldStorage.commodityHashSet) {
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
                        GameFieldStorage.commodityHashSet) {
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
                        GameFieldStorage.commodityHashSet) {
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
                        GameFieldStorage.commodityHashSet) {
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
                        GameFieldStorage.commodityHashSet) {
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
                        GameFieldStorage.commodityHashSet) {
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
                        GameFieldStorage.commodityHashSet) {
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
                int amountNeeded = task.neededCommodity.get("Milk");
                int amountExisting = 0;
                for (Commodity commodity :
                        GameFieldStorage.commodityHashSet) {
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
                        GameFieldStorage.commodityHashSet) {
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
