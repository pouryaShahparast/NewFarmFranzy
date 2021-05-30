package model.commodities;

public class IceCream extends FinalCommodity{
    public static final int ICE_CREAM_PRICE = 120;

    public IceCream(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "IceCream";
    }
}
