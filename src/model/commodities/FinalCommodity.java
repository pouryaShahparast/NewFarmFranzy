package model.commodities;

public abstract class FinalCommodity extends Commodity{
    public static final int FINAL_COMMODITY_SIZE = 4;
    public static final int FINAL_COMMODITY_MAX_TURNS_IN_GROUND = 6;

    public boolean maxTurnsInfieldReached(){
        return turnsInField >= FINAL_COMMODITY_MAX_TURNS_IN_GROUND;
    }

    public FinalCommodity(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }
}
