package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
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

        Bread bread = storeroom.takeBread();
        if (bread == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(bread);
        }



    }

    @Override
    public void unload() {
        pickUpTruck.reStoreBreadFromTruck(storeroom);
    }



}
