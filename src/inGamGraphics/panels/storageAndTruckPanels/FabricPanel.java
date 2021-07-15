package inGamGraphics.panels.storageAndTruckPanels;

import ETC.ConsoleColors;
import ETC.LoggingToFile;
import model.GameFieldStorage;
import model.commodities.Commodity;
import model.commodities.Fabric;

public class FabricPanel extends TruckAndStoragePanels{
    public FabricPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {
        nameOrPicture.setText("fabric");
    }

    @Override
    public void tick() {
        numInStorage.setText(Integer.toString(GameFieldStorage.storeroom.numberOfFabrics()));
        numInTruck.setText(Integer.toString(GameFieldStorage.pickUpTruck.numberOfFabrics()));
    }

    @Override
    public void load() {

        Fabric fabric = storeroom.takeFabric();
        if (fabric == null) {
            LoggingToFile.logToFile("there is no commodity with this name_matcher 8", "info");
            System.out.println(ConsoleColors.RED + "there is no commodity with this name" + ConsoleColors.RESET);


        } else {

            pickUpTruck.pickUp(fabric);
        }



    }

    @Override
    public void unload() {
        pickUpTruck.reStoreFabricFromTruck(storeroom);
    }



}
