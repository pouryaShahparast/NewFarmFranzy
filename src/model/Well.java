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
            System.err.println("well is already getting water");
            return false;
        }else {
            gettingWater = true;
            System.out.println("well started to get water");
            return true;
        }
    }
    public boolean getWaterWithTurns(){
        if(gettingWater){
            if(checkIfTurnsReached()){
                getWater();
                finishGettingWater();
                System.out.println("water is added");
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
    public boolean makeGrass(int xTile , int yTile) {
        if ((xTile >= 0) && (xTile < 6) && (yTile >= 0) && (yTile < 6)) {
            if (bucketWater > 0) {
                bucketWater--;
                Cell.worldCells[xTile][yTile].addGrass();
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
    public void setBucketWater(int a){
        bucketWater = a;
    }
}
