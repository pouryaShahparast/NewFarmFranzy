package model.commodities;

public class Milk extends PrimitiveCommodity{
    public static final int MILK_PRICE = 25;

    public Milk(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Milk";
    }
}
