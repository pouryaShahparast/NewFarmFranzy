package ETC;

import ETC.Task1;

import java.util.ArrayList;

public class Level {

    //level1
   public Task1 taskOfLevel1,taskOfLevel2,taskOfLevel3,taskOfLevel4,taskOfLevel5;




    public Level() {


         taskOfLevel1 = new Task1(1, 50, 60, 400, 300, 200);
        ArrayList<Integer> bearTimes1=new ArrayList<>();
        bearTimes1.add(10);
        bearTimes1.add(35);
        taskOfLevel1.animalsAppearing.put("bear",bearTimes1);

        taskOfLevel1.neededCommodity.put("egg",5);
        taskOfLevel1.neededCommodity.put("turkey",2);

        //level2
        taskOfLevel2=new Task1(2,70,90,500,300,350);

        ArrayList<Integer>bearTimes2=new ArrayList<>();
        bearTimes2.add(10);
        bearTimes2.add(35);
        ArrayList<Integer>tigerTimes2=new ArrayList<>();
        tigerTimes2.add(45);
        taskOfLevel2.animalsAppearing.put("bear",bearTimes2);
        taskOfLevel2.animalsAppearing.put("tiger",tigerTimes2);

        taskOfLevel2.neededCommodity.put("egg",10);
        taskOfLevel2.neededCommodity.put("turkey",5);
        taskOfLevel2.neededCommodity.put("bread",5);
        taskOfLevel2.neededCommodity.put("cow",2);
        taskOfLevel2.neededCommodity.put("milk",2);
        //level3
          taskOfLevel3=new Task1(3,90,110,600,700,400);
        ArrayList<Integer>bearTimes3=new ArrayList<>();
        bearTimes3.add(15);
        bearTimes3.add(40);
        bearTimes3.add(70);
        ArrayList<Integer>tigerTimes3=new ArrayList<>();
        tigerTimes3.add(5);
        tigerTimes3.add(35);
        taskOfLevel3.animalsAppearing.put("bear",bearTimes3);
        taskOfLevel3.animalsAppearing.put("tiger",tigerTimes3);

        taskOfLevel3.neededCommodity.put("egg",10);
        taskOfLevel3.neededCommodity.put("turkey",5);
        taskOfLevel3.neededCommodity.put("bread",5);
        taskOfLevel3.neededCommodity.put("cow",3);
        taskOfLevel3.neededCommodity.put("milk",5);
        taskOfLevel3.neededCommodity.put("ice cream",5);
        //level4
         taskOfLevel4=new Task1(4,110,150,800,850,500);
        ArrayList<Integer>bearTimes4=new ArrayList<>();
        bearTimes4.add(5);
        bearTimes4.add(40);
        bearTimes4.add(70);
        ArrayList<Integer>tigerTimes4=new ArrayList<>();
        tigerTimes4.add(35);
        tigerTimes4.add(90);
        ArrayList<Integer>lionTimes4=new ArrayList<>();
        lionTimes4.add(96);


        taskOfLevel4.animalsAppearing.put("bear",bearTimes4);
        taskOfLevel4.animalsAppearing.put("tiger",tigerTimes4);
        taskOfLevel4.animalsAppearing.put("lion",lionTimes4);


        taskOfLevel4.neededCommodity.put("egg",10);
        taskOfLevel4.neededCommodity.put("turkey",5);
        taskOfLevel4.neededCommodity.put("chicken",5);
        taskOfLevel4.neededCommodity.put("bread",5);
        taskOfLevel4.neededCommodity.put("cow",5);
        taskOfLevel4.neededCommodity.put("milk",5);
        taskOfLevel4.neededCommodity.put("ice cream",5);
        taskOfLevel4.neededCommodity.put("wool",5);
        //level5
         taskOfLevel5=new Task1(5,150,200,1000,850,750);

        ArrayList<Integer>bearTimes5=new ArrayList<>();
        bearTimes5.add(5);
        bearTimes5.add(40);
        bearTimes5.add(60);
        bearTimes5.add(70);
        ArrayList<Integer>tigerTimes5=new ArrayList<>();
        tigerTimes5.add(35);
        tigerTimes5.add(90);
        ArrayList<Integer>lionTimes5=new ArrayList<>();
        lionTimes5.add(96);
        lionTimes5.add(105);
        lionTimes5.add(120);

        taskOfLevel4.animalsAppearing.put("bear",bearTimes5);
        taskOfLevel4.animalsAppearing.put("tiger",tigerTimes5);
        taskOfLevel4.animalsAppearing.put("lion",lionTimes5);


        taskOfLevel5.neededCommodity.put("egg",20);
        taskOfLevel5.neededCommodity.put("turkey",10);
        taskOfLevel5.neededCommodity.put("chicken",8);
        taskOfLevel5.neededCommodity.put("bread",5);
        taskOfLevel5.neededCommodity.put("cow",5);
        taskOfLevel5.neededCommodity.put("milk",5);
        taskOfLevel5.neededCommodity.put("ice cream",5);
        taskOfLevel5.neededCommodity.put("wool",5);
        taskOfLevel5.neededCommodity.put("flour",10);
        taskOfLevel5.neededCommodity.put("feather",10);



    }






}
