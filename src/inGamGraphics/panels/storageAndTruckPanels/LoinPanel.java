package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
import model.GameFieldStorage;
import model.animals.Loin;
import model.animals.WildAnimal;

public class LoinPanel extends TruckAndStoragePanels{
    public LoinPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("lion");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfLoins()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfLoins()));
    }

    @Override
    public void load() {

        Loin loin = storeroom.takeLoin();


        if (loin == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(loin);
        }

    }

    @Override
    public void unload() {
        pickUpTruck.reStoreLoinFromTruck(storeroom);
    }
}
