package model.commodities;

public class Flour extends IntermediaryCommodity{
    public static final int FLOUR_PRICE = 40;

    public Flour(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Flour";
    }
}
