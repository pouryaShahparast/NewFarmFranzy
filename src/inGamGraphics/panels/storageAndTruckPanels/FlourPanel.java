package inGamGraphics.panels.storageAndTruckPanels;

import model.GameFieldStorage;
import model.commodities.Commodity;
import model.commodities.Flour;

public class FlourPanel extends TruckAndStoragePanels{
    public FlourPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("flour");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfFlours()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfFlours()));
    }

    @Override
    public void load() {

        boolean found = false;

        for (Commodity commodity :
                storeroom.commodityHashSet) {
            if (commodity instanceof Flour) {
                found = true;
                if(pickUpTruck.pickUp(commodity)) {
                    storeroom.takeFlour();

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
        pickUpTruck.reStoreFlourFromTruck(storeroom);
    }



}
