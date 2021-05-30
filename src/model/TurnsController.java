package model;

public class TurnsController {
    final int MAX_TURNS;
    private int turns;
    private boolean isLocked;
    public TurnsController(int MAX_TURNS) {
        this.MAX_TURNS = MAX_TURNS;
        isLocked = true;
        turns = 0;
    }
    public boolean passTurn(){
        if((!isLocked) && (turns < MAX_TURNS)) {
            turns++;
            if (turns == MAX_TURNS) {
                lock();
            }
            return true;
        }
        return false;
    }
    public boolean conditionalUnlock(){
        if (turns < MAX_TURNS){
            isLocked = false;
            return true;
        }
        return false;
    }
    public void forcedUnlock(){
        isLocked = false;
    }
    public void lock(){
        isLocked = true;
    }
    public boolean turnsReached (){
        return turns == MAX_TURNS;
    }
    public void resetTimeControllerIfTurnsReached(){
        if(turnsReached()){
            turns = 0;
        }
    }
}
