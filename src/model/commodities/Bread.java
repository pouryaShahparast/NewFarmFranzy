package model.commodities;

public class Bread extends FinalCommodity{
    public static final int BREAD_PRICE = 80;

    public Bread(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Bread";
    }
}
