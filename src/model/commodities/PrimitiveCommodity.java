package model.commodities;

public abstract class PrimitiveCommodity extends Commodity{
    public static final int PRIMITIVE_COMMODITY_SIZE = 1;
    public static final int PRIMITIVE_COMMODITY_MAX_TURNS_IN_GROUND = 4;

    public boolean maxTurnsInfieldReached(){
        return turnsInField >= PRIMITIVE_COMMODITY_MAX_TURNS_IN_GROUND;
    }

    public PrimitiveCommodity(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }
}
