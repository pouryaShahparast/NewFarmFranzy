package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
import model.GameFieldStorage;
import model.animals.Bear;
import model.animals.WildAnimal;

public class BearPanel extends TruckAndStoragePanels{
    public BearPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("bear");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfBears()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfBears()));
    }

    @Override
    public void load() {

        boolean found = false;

        for (WildAnimal wildAnimal :
                storeroom.wildAnimalHashSet) {
            if (wildAnimal instanceof Bear) {
                found = true;
                if(pickUpTruck.pickUp(wildAnimal)) {
                    storeroom.takeBear();
                }
                break;
            }
        }

        if (!found) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8","info");
            System.out.println(ConsoleColors.RED + "there is no animal with this name" + ConsoleColors.RESET);

        }
    }

    @Override
    public void unload() {
        pickUpTruck.reStoreBearFromTruck(storeroom);
    }
}
