package model.factories;

import model.Coin;
import model.Storeroom;

abstract class PrimitiveFactory extends Factory{
    public abstract boolean upgrade(Coin coin);
    public abstract void make();
    public abstract boolean startWorkingOneCommodity(Storeroom storeroom);
    public abstract boolean startWorkingTwoCommodities(Storeroom storeroom);
    public abstract boolean checkIfTurnsReachedUpgraded();
    public abstract boolean checkIfTurnsReachedNotUpgraded();
    public PrimitiveFactory() {
        super();
    }
}
