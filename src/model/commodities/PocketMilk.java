package model.commodities;

import inGamGraphics.Assets;

import java.awt.*;

public class PocketMilk extends IntermediaryCommodity{
    public static final int POCKET_MILK_PRICE = 60;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.pocketMilk , xCoordinate , yCoordinate , WIDTH , HEIGHT , null);
    }

    public PocketMilk(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        commodityName = "PocketMilk";
    }
}
