package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class Milk extends PrimitiveCommodity{
    public static final int MILK_PRICE = 25;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.milk , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public Milk(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "Milk";
    }
}
