package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
import model.GameFieldStorage;
import model.commodities.Commodity;
import model.commodities.IceCream;

public class IceCreamPanel extends TruckAndStoragePanels{
    public IceCreamPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {

        nameOrPicture.setText("ice cream");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfIceCreams()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfIceCreams()));
    }

    @Override
    public void load() {

        IceCream iceCream = storeroom.takeIceCream();
        if (iceCream == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(iceCream);
        }


    }

    @Override
    public void unload() {
        pickUpTruck.reStoreEggFromTruck(storeroom);
    }



}
