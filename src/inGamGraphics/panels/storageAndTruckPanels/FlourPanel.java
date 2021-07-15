package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
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

        Flour flour = storeroom.takeFlour();
        if (flour == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(flour);
        }

    }

    @Override
    public void unload() {
        pickUpTruck.reStoreFlourFromTruck(storeroom);
    }



}
