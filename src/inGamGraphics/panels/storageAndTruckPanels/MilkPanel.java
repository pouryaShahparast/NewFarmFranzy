package inGamGraphics.panels.storageAndTruckPanels;

import model.GameFieldStorage;
import model.commodities.Commodity;
import model.commodities.Milk;

public class MilkPanel extends TruckAndStoragePanels {
    public MilkPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("milk");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfMilks()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfMilks()));
    }

    @Override
    public void load() {

        boolean found = false;

        for (Commodity commodity :
                storeroom.commodityHashSet) {
            if (commodity instanceof Milk) {
                found = true;
                if (pickUpTruck.pickUp(commodity)) {
                    storeroom.takeMilk();

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
        pickUpTruck.reStoreMilkFromTruck(storeroom);
    }
}

