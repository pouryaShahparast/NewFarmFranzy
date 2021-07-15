package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
import model.GameFieldStorage;
import model.commodities.Commodity;
import model.commodities.Feather;

public class FeatherPanel extends TruckAndStoragePanels{
    public FeatherPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("feather");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfFeathers()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfFeathers()));
    }

    @Override
    public void load() {

        boolean found = false;

        for (Commodity commodity :
                storeroom.commodityHashSet) {
            if (commodity instanceof Feather) {
                found = true;
                if(pickUpTruck.pickUp(commodity)) {
                    storeroom.takeFeather();

                }
                break;
            }
        }
        if (!found) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8" ,"info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);

        }

    }

    @Override
    public void unload() {
        pickUpTruck.reStoreFeatherFromTruck(storeroom);
    }



}
