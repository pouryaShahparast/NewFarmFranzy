package model.commodities;

public class Feather extends PrimitiveCommodity{
    public static final int FEATHER_PRICE = 20;

    public Feather(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Feather";
    }
}
