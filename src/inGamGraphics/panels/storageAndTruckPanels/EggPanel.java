package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
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


        Egg egg = storeroom.takeEgg();

        if (egg == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(egg);
        }


    }

    @Override
    public void unload() {
        pickUpTruck.reStoreEggFromTruck(storeroom);
    }



}
