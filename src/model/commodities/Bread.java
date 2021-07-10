package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class Bread extends FinalCommodity{
    public static final int BREAD_PRICE = 80;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.bread , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public Bread(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Bread";
    }
}
