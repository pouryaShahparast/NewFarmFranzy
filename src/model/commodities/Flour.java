package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class Flour extends IntermediaryCommodity{
    public static final int FLOUR_PRICE = 40;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.flour , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public Flour(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Flour";
    }
}
