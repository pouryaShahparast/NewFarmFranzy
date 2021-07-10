package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class Feather extends PrimitiveCommodity{
    public static final int FEATHER_PRICE = 20;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.feather , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public Feather(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Feather";
    }
}
