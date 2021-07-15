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

        boolean found = false;

        for (WildAnimal wildAnimal :
                storeroom.wildAnimalHashSet) {
            if (wildAnimal instanceof Loin) {
                found = true;
                if(pickUpTruck.pickUp(wildAnimal)) {
                    storeroom.takeLoin();
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
        pickUpTruck.reStoreLoinFromTruck(storeroom);
    }
}
