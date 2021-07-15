package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
import model.GameFieldStorage;
import model.animals.Tiger;
import model.animals.WildAnimal;

public class TigerPanel extends TruckAndStoragePanels{
    public TigerPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("tiger");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfTigers()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfTigers()));
    }

    @Override
    public void load() {

        Tiger tiger = storeroom.takeTiger();
        if (tiger == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(tiger);
        }
    }

    @Override
    public void unload() {
        pickUpTruck.reStoreTigerFromTruck(storeroom);
    }
}
