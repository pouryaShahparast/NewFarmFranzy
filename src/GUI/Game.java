package GUI;
import ETC.Task1;
import model.commodities.*;




public class Game {


    public static Task1 task;
    public Game(Task1 task1) {
      task=task1;
    }





/*
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
    */


}
