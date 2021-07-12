package inGamGraphics.panels.storageAndTruckPanels;

import model.GameFieldStorage;
import model.commodities.Bread;
import model.commodities.Commodity;

public class BreadPanel extends TruckAndStoragePanels{
    public BreadPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("Bread");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfBreads()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfBreads()));
    }

    @Override
    public void load() {
        boolean found = false;

        for (Commodity commodity :
                storeroom.commodityHashSet) {
            if (commodity instanceof Bread) {
                found = true;
                if(pickUpTruck.pickUp(commodity)) {
                    storeroom.takeBread();

                }
                break;


            }


        }
//        if (!found) {
//            LoggingToFile.logToFile( "there is no commodity with this name_matcher 8","info");
//            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);
//
//        }


    }

    @Override
    public void unload() {
        pickUpTruck.reStoreBreadFromTruck(storeroom);
    }



}
