package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class Egg extends PrimitiveCommodity{
    public static final int EGG_PRICE = 15;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.egg , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public Egg(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Egg";
    }
}
