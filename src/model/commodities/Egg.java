package model.commodities;

public class Egg extends PrimitiveCommodity{
    public static final int EGG_PRICE = 15;

    public Egg(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Egg";
    }
}
