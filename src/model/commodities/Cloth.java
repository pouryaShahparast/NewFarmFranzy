package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class Cloth extends FinalCommodity{
    public static final int CLOTH_PRICE = 100;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.cloth , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public Cloth(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Cloth";
    }
}
