package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
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

        Milk milk = storeroom.takeMilk();

        if (milk == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(milk);
        }

    }

    @Override
    public void unload() {
        pickUpTruck.reStoreMilkFromTruck(storeroom);
    }
}

