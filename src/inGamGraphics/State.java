package inGamGraphics;

import java.awt.*;

public abstract class State {
    public static State currentState;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }
    public static boolean isInGameState(){
        if(currentState != null){
            if(currentState instanceof GameState){
                return true;
            }
        }
        return false;
    }
    public static boolean isInMenuState(){
        if(currentState != null){
            if(currentState instanceof graphics.MenuState){
                return true;
            }
        }
        return false;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);
}
