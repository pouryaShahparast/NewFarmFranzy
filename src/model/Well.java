package model;

public class Well {
    static final int TURNS_NEEDED_TO_GET_WATER = 3;
    int bucketWater;
    int turns;
    boolean gettingWater;
    public void finishGettingWater(){
        gettingWater = false;
        turns = 1;
    }
    public boolean startGettingWater(){
        if(gettingWater){
            return false;
        }else {
            gettingWater = true;
            return true;
        }
    }
    public boolean getWaterWithTurns(){
        if(gettingWater){
            if(checkIfTurnsReached()){
                getWater();
                finishGettingWater();
                return true;
            }else {
                addTurn();
            }
        }
        return false;
    }
    void addTurn(){
        turns++;
    }
    private void getWater(){
        bucketWater = 5;
    }
    public boolean checkIfTurnsReached(){
        return turns >= TURNS_NEEDED_TO_GET_WATER;
    }
    public boolean makeGrass(int xLocation ,int yLocation){
        if((xLocation >= 0) && (xLocation < 6) && (yLocation >= 0) && (yLocation < 6)) {
            if (bucketWater > 0) {
                bucketWater--;
                GameFieldStorage.grassHashSet.add(new Grass(xLocation , yLocation));
                return true;
            }
        }
        return false;
    }

    public Well() {
        turns = 1;
        bucketWater = 0;
        gettingWater = false;
    }
}
