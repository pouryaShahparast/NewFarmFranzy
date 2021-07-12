package inGamGraphics;

import model.Cell;
import model.GameFieldStorage;
import model.Storeroom;
import model.Well;
import model.animals.WildAnimal;
import model.commodities.Commodity;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener  {
    Storeroom storeroom;
    Well well;
    public MouseInput() {
        this.storeroom = GameFieldStorage.storeroom;
        this.well = GameFieldStorage.well;
    }

    public void farmWorks(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        Rectangle rectangle = new Rectangle(x-2,y-2,4,4);
        if(x >=0 && x <600 && y >=0 && y < 600){
            for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
                if(wildAnimal.checkForCollision(rectangle)){
                    if(!wildAnimal.isCaged()) {
                        wildAnimal.addCage();
                        return;
                    }
                }
            }
            for (WildAnimal wildAnimal : GameFieldStorage.wildAnimalHashSet) {
                if(wildAnimal.checkForCollision(rectangle) && wildAnimal.isCaged()){
                    storeroom.store(wildAnimal);
                    return;
                }
            }
            for (Commodity commodity : GameFieldStorage.commodityHashSet) {
                if(commodity.getBounds().intersects(rectangle)){
                    storeroom.store(commodity);
                    return;
                }
            }
            well.makeGrass(x/ Cell.WIDTH , y/Cell.HEIGHT);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(State.isInGameState()) {
            farmWorks(e);
            // System.out.println(1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
