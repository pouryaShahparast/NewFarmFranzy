package model.commodities;

public class Fabric extends IntermediaryCommodity{
    public static final int FABRIC_PRICE = 50;

    public Fabric(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Fabric";
    }
}
