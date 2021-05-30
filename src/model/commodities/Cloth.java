package model.commodities;

public class Cloth extends FinalCommodity{
    public static final int CLOTH_PRICE = 100;

    public Cloth(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Cloth";
    }
}
