package inGamGraphics.panels.storageAndTruckPanels;

import model.GameFieldStorage;
import model.commodities.Commodity;
import model.commodities.PocketMilk;

public class PocketMilkPanels extends TruckAndStoragePanels{
    public PocketMilkPanels(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("pocket milk");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfPocketMilks()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfPocketMilks()));
    }

    @Override
    public void load() {

        boolean found = false;

        for (Commodity commodity :
                storeroom.commodityHashSet) {
            if (commodity instanceof PocketMilk) {
                found = true;
                if(pickUpTruck.pickUp(commodity)) {
                    storeroom.takePocketMilk();

                }
                break;
            }

        }
//        if (!found) {
//            LoggingToFile.logToFile("there is no commodity with this name_matcher 8" ,"info");
//            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);
//
//        }


    }

    @Override
    public void unload() {
        pickUpTruck.reStorePocketMilkFromTruck(storeroom);
    }



}
