package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
import model.GameFieldStorage;
import model.commodities.Cloth;
import model.commodities.Commodity;

public class ClothPanel extends TruckAndStoragePanels{
    public ClothPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("cloth");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfCloths()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfCloths()));
    }

    @Override
    public void load() {



        Cloth cloth = storeroom.takeCloth();
        if (cloth == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(cloth);
        }


    }

    @Override
    public void unload() {
        pickUpTruck.reStoreClothFromTruck(storeroom);
    }



}
