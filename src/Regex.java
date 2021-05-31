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
    public Regex(){
        coin=new Coin();
        well=new Well();
        pickUpTruck=new PickUpTruck();
        storeroom=new Storeroom();
        inGameManager=new InGameManager(storeroom,coin,well,pickUpTruck);

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
        pattern7 = Pattern.compile("\\s*(?i:turn)\\s*\\[?\\s*(\\d+)\\s+\\]?\\s*$");
        //truck load
        pattern8 = Pattern.compile("\\s*(?i:truck)\\s*(?i:load)\\[?\\s*(\\w+)\\s*\\]?\\s*$");
        //truck unload
        pattern9 = Pattern.compile("\\s*(?i:truck)\\s*(?i:unload)\\[?\\s*(\\w+)\\s*\\]?\\s*$");
        //truck go
        pattern10 = Pattern.compile("\\s*(?i:truck)\\s*(?i:go)\\s*$");
        ////exit
        pattern11 = Pattern.compile("\\s*(?i:exit)\\s*$");
//////////////////////////

        if (matcher1.find()) {


            if ((matcher1.group(1).equalsIgnoreCase("cat"))) {
                Cat.buyCat(coin);

            }
            else if ((matcher1.group(1).equalsIgnoreCase("buffalo"))) {
                Buffalo.buyBuffalo(coin);

            }

            else if ((matcher1.group(1).equalsIgnoreCase("chicken"))) {
                Chicken.buyChicken(coin);

            }
            else if ((matcher1.group(1).equalsIgnoreCase("turkey"))) {

                Turkey.buyTurkey(coin);

            }
            else if ((matcher1.group(1).equalsIgnoreCase("dog"))) {

                Dog.buyDog(coin);

            }

            else{
                System.out.println(ConsoleColors.RED+"INVALID INPUT(can't find an animal with this name)"+ConsoleColors.RESET);

            }


        }

        ////////////////////////////////////////

        if(matcher2.find())
        {
         int x_coordinate,y_coordinate;
         x_coordinate=Integer.parseInt(matcher2.group(1));
         y_coordinate=Integer.parseInt(matcher2.group(2));
            if((x_coordinate>=7)||(x_coordinate<=0)||(x_coordinate>=7)||(x_coordinate<=0))
            {
                System.out.println(ConsoleColors.RED+"INVALID INPUT (coordinate out of range)"+ConsoleColors.RESET);
                return;

            }
          boolean found=false;
            for (Commodity commodity :
                    GameFieldStorage.commodityHashSet) {
            if((commodity.getXCoordinate()==x_coordinate)&&(commodity.getYCoordinate()==y_coordinate))
            {
                found=true;
                if(storeroom.store(commodity)){
                    break;
                }



            }



            }
           if(!found)
           {
               System.out.println(ConsoleColors.RED+"INVALID INPUT (there is no commodity in this coordinate)"+ConsoleColors.RESET);

           }









        }
        ////////////////////////////////
        if(matcher3.find())
        {

          well.startGettingWater();



        }
        /////////////////////////////
        if(matcher4.find())
        {
            int x_coordinate,y_coordinate;
            x_coordinate=Integer.parseInt(matcher4.group(1));
            y_coordinate=Integer.parseInt(matcher4.group(2));
            if((x_coordinate>=7)||(x_coordinate<=0)||(x_coordinate>=7)||(x_coordinate<=0))
            {
                System.out.println(ConsoleColors.RED+"INVALID INPUT (coordinate out of range)"+ConsoleColors.RESET);
                return;

            }



            well.makeGrass(x_coordinate , y_coordinate);






        }
   ///////////////////////////////////

        if(matcher5.find())
        {
          String factoryName=matcher5.group(1);
          if(factoryName.equalsIgnoreCase("bakery"))
          {
              boolean found=false;

              for (Factory factory :
                      GameFieldStorage.factoryHashSet) {
              if(factory instanceof Bakery)
              {
                 found=true;
                 factory.startWorkingOneCommodity(storeroom);
                 break;

              }
              }
              if(!found)
              {
                  System.out.println(ConsoleColors.RED+"factory does't exist  first create bakery factory"+ConsoleColors.RESET);
              }







          }
          else if(factoryName.equalsIgnoreCase("mill"))
          {

              boolean found=false;

              for (Factory factory :
                      GameFieldStorage.factoryHashSet) {
                  if(factory instanceof Mill)
                  {
                      found=true;
                      factory.startWorkingOneCommodity(storeroom);
                      break;

                  }
              }
              if(!found)
              {
                  System.out.println(ConsoleColors.RED+"factory does't exist  first create mill"+ConsoleColors.RESET);
              }






          }
          else if(factoryName.equalsIgnoreCase("milk pocketing production"))
          {

              boolean found=false;

              for (Factory factory :
                      GameFieldStorage.factoryHashSet) {
                  if(factory instanceof MilkPocketingProduction)
                  {
                      found=true;
                      factory.startWorkingOneCommodity(storeroom);
                      break;

                  }
              }
              if(!found)
              {
                  System.out.println(ConsoleColors.RED+"factory does't exist  first create milk pocketing production factory"+ConsoleColors.RESET);
              }




          }
          else if(factoryName.equalsIgnoreCase("ice cream maker"))
          {
              boolean found=false;

              for (Factory factory :
                      GameFieldStorage.factoryHashSet) {
                  if(factory instanceof IceCreamMaker)
                  {
                      found=true;
                      factory.startWorkingOneCommodity(storeroom);
                      break;

                  }
              }
              if(!found)
              {
                  System.out.println(ConsoleColors.RED+"factory does't exist  first create ice cream maker factory"+ConsoleColors.RESET);
              }






          }

          else if(factoryName.equalsIgnoreCase("tailoring"))
          {
              boolean found=false;

              for (Factory factory :
                      GameFieldStorage.factoryHashSet) {
                  if(factory instanceof Tailoring)
                  {
                      found=true;
                      factory.startWorkingOneCommodity(storeroom);
                      break;

                  }
              }
              if(!found)
              {
                  System.out.println(ConsoleColors.RED+"factory does't exist  first create tailoring factory"+ConsoleColors.RESET);
              }

          }
          else if(factoryName.equalsIgnoreCase("fabric production"))
          {
              boolean found=false;

              for (Factory factory :
                      GameFieldStorage.factoryHashSet) {
                  if(factory instanceof FabricProduction)
                  {
                      found=true;
                      factory.startWorkingOneCommodity(storeroom);
                      break;

                  }
              }
              if(!found)
              {
                  System.out.println(ConsoleColors.RED+"factory does't exist  first create fabric production factory"+ConsoleColors.RESET);
              }

          }

          else{

              System.out.println(ConsoleColors.RED+"INVALID INPUT (coordinate out of range)"+ConsoleColors.RESET);

          }



    }
        ////////////////////////////////////////
        if(matcher6.find())
        {
            boolean found=false;
            int x_coordinate,y_coordinate;
            x_coordinate=Integer.parseInt(matcher6.group(1));
            y_coordinate=Integer.parseInt(matcher6.group(2));
            if((x_coordinate>=7)||(x_coordinate<=0)||(x_coordinate>=7)||(x_coordinate<=0))
            {
                System.out.println(ConsoleColors.RED+"INVALID INPUT (coordinate out of range)"+ConsoleColors.RESET);
                return;

            }
            for (WildAnimal wildanimal :
                    GameFieldStorage.wildAnimalHashSet) {
                if((x_coordinate==wildanimal.getXCoordinate())&&(y_coordinate==wildanimal.getYCoordinate()))
                {
                    found=true;
                  if(wildanimal instanceof Bear)
                  {

                      ((Bear) wildanimal).addCage();

                  }
                     if(wildanimal instanceof Tiger)
                    {

                        ((Tiger) wildanimal).addCage();

                    }
                    if(wildanimal instanceof Loin )
                    {

                        ((Loin) wildanimal).addCage();

                    }


                }


            }

            if(!found)
            {
                System.out.println(ConsoleColors.RED+"INVALID INPUT (there is no animal in this coordinate)"+ConsoleColors.RESET);            }





        }
        //////////////////////////////////////
        if(matcher7.find())
        {

           int n=Integer.parseInt(matcher7.group(1));
           if(n<=0)
           {
               System.out.println(ConsoleColors.RED+"INVALID INPUT (incorrect time)"+ConsoleColors.RESET);
               return;
           }
            for (int i = 0; i < n; i++) {
                inGameManager.game();
                inGameManager.turnsPassed+=1;
            }
            System.out.println(ConsoleColors.RED+"****************************************************************************************************"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE+"                                         turn   "+ConsoleColors.CYAN_+inGameManager.turnsPassed+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLACK);
            inGameManager.show();
            System.out.println(ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED+"****************************************************************************************************"+ConsoleColors.RESET);









        }
        ///////////////////
       if(matcher8.find())
       {
String name=matcher8.group(1);
            if(name.equalsIgnoreCase("egg"))
            {

                boolean found =false;

                for (Commodity commodity :
                        GameFieldStorage.commodityHashSet) {
                    if (commodity instanceof Egg)
                    {
                      found=true;
                      pickUpTruck.pickUp(commodity);
                      GameFieldStorage.commodityHashSet.remove(commodity);
                      break;


                    }


                }

                if(!found)
                {
                    System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

                }




            }
            else  if(name.equalsIgnoreCase("brad"))
           {

               boolean found =false;

               for (Commodity commodity :
                       GameFieldStorage.commodityHashSet) {
                   if (commodity instanceof Bread)
                   {
                       found=true;
                       pickUpTruck.pickUp(commodity);
                       GameFieldStorage.commodityHashSet.remove(commodity);
                       break;


                   }


               }

               if(!found)
               {
                   System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

               }




           }


          else if(name.equalsIgnoreCase("cloth"))
           {

               boolean found =false;

               for (Commodity commodity :
                       GameFieldStorage.commodityHashSet) {
                   if (commodity instanceof Cloth)
                   {
                       found=true;
                       pickUpTruck.pickUp(commodity);
                       GameFieldStorage.commodityHashSet.remove(commodity);
                       break;


                   }


               }

               if(!found)
               {
                   System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

               }




           }
          else if(name.equalsIgnoreCase("fabric"))
           {

               boolean found =false;

               for (Commodity commodity :
                       GameFieldStorage.commodityHashSet) {
                   if (commodity instanceof Fabric)
                   {
                       found=true;
                       pickUpTruck.pickUp(commodity);
                       GameFieldStorage.commodityHashSet.remove(commodity);
                       break;


                   }


               }

               if(!found)
               {
                   System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

               }




           }
            else if(name.equalsIgnoreCase("feather"))
           {

               boolean found =false;

               for (Commodity commodity :
                       GameFieldStorage.commodityHashSet) {
                   if (commodity instanceof Feather)
                   {
                       found=true;
                       pickUpTruck.pickUp(commodity);
                       GameFieldStorage.commodityHashSet.remove(commodity);
                       break;


                   }


               }

               if(!found)
               {
                   System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

               }




           }
           else if(name.equalsIgnoreCase("flour"))
           {

               boolean found =false;

               for (Commodity commodity :
                       GameFieldStorage.commodityHashSet) {
                   if (commodity instanceof Flour)
                   {
                       found=true;
                       pickUpTruck.pickUp(commodity);
                       GameFieldStorage.commodityHashSet.remove(commodity);
                       break;


                   }


               }

               if(!found)
               {
                   System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

               }




           }
           else if(name.equalsIgnoreCase("ice cream"))
           {

               boolean found =false;

               for (Commodity commodity :
                       GameFieldStorage.commodityHashSet) {
                   if (commodity instanceof IceCream)
                   {
                       found=true;
                       pickUpTruck.pickUp(commodity);
                       GameFieldStorage.commodityHashSet.remove(commodity);
                       break;


                   }


               }

               if(!found)
               {
                   System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

               }




           }
          else if(name.equalsIgnoreCase("milk"))
           {

               boolean found =false;

               for (Commodity commodity :
                       GameFieldStorage.commodityHashSet) {
                   if (commodity instanceof Milk)
                   {
                       found=true;
                       pickUpTruck.pickUp(commodity);
                       GameFieldStorage.commodityHashSet.remove(commodity);
                       break;


                   }


               }

               if(!found)
               {
                   System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

               }




           }
           else if(name.equalsIgnoreCase("pocket milk"))
           {

               boolean found =false;

               for (Commodity commodity :
                       GameFieldStorage.commodityHashSet) {
                   if (commodity instanceof PocketMilk)
                   {
                       found=true;
                       pickUpTruck.pickUp(commodity);
                       GameFieldStorage.commodityHashSet.remove(commodity);
                       break;


                   }


               }

               if(!found)
               {
                   System.out.println(ConsoleColors.RED+"there is no commodity with this name"+ConsoleColors.RESET);

               }




           }
           else{
                System.out.println(ConsoleColors.RED+"INVALID INPUT (there is no commodity with this name)"+ConsoleColors.RESET);            }


       }




       }
       //////////////////////
        if(matcher9.find())
        {
            /*boolean found=pickUpTruck.smatcher9.group(1));
            if(!found)
            {
                System.out.println(ConsoleColors.RED+"INVALID INPUT (there is no commodity with this name)"+ConsoleColors.RESET);


            }
*/



        }
//////////////////////////
        if(matcher10.find())
        {
    /*boolean found=pickUpTruck.smatcher9.group(1));
            if(!found)
            {
                System.out.println(ConsoleColors.RED+"INVALID INPUT (there is no commodity with this name)"+ConsoleColors.RESET);


            }
*/



        }

////////////////////


    }


}

