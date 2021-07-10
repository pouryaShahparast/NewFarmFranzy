package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class IceCream extends FinalCommodity{
    public static final int ICE_CREAM_PRICE = 120;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.iceCream , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public IceCream(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "IceCream";
    }
}
