package model.commodities;

public class PocketMilk extends IntermediaryCommodity{
    public static final int POCKET_MILK_PRICE = 60;

    public PocketMilk(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "PocketMilk";
    }
}
