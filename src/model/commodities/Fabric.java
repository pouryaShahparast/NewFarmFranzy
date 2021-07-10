package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class Fabric extends IntermediaryCommodity{
    public static final int FABRIC_PRICE = 50;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.fabric , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public Fabric(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Fabric";
    }
}
