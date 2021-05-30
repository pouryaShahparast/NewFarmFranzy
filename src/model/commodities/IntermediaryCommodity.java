package model.commodities;

public abstract class IntermediaryCommodity extends Commodity{
    public static final int INTERMEDIARY_COMMODITY_SIZE = 2;
    public static final int INTERMEDIARY_COMMODITY_MAX_TURNS_IN_GROUND = 5;
    public boolean maxTurnsInfieldReached(){
        return turnsInField >= INTERMEDIARY_COMMODITY_MAX_TURNS_IN_GROUND;
    }
    public IntermediaryCommodity(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }
}
