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
    public boolean makeGrass(int xLocation ,int yLocation){
        if((xLocation >= 0) && (xLocation < 6) && (yLocation >= 0) && (yLocation < 6)) {
            if (bucketWater > 0) {
                bucketWater--;
                GameFieldStorage.grassHashSet.add(new Grass(xLocation , yLocation));
                System.out.println("grass added , remaining water = " + bucketWater);
                return true;
            }else {
                System.err.println("you dont have enough water to make grass");
            }
        }else {
            System.err.println("Coordinates are not valid ");
        }
        return false;
    }

    public Well() {
        turns = 1;
        bucketWater = 0;
        gettingWater = false;
    }
}
