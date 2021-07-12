package inGamGraphics.panels.storageAndTruckPanels;

import model.GameFieldStorage;
import model.commodities.Commodity;
import model.commodities.Egg;

public class EggPanel extends TruckAndStoragePanels{
    public EggPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("egg");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfEggs()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfEggs()));
    }

    @Override
    public void load() {

        boolean found = false;

        for (Commodity commodity :
                storeroom.commodityHashSet) {
            if (commodity instanceof Egg) {
                found = true;
                if(pickUpTruck.pickUp(commodity)) {
                    storeroom.takeEgg();

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
        pickUpTruck.reStoreEggFromTruck(storeroom);
    }



}
