package model;

import inGamGraphics.Assets;
import model.animals.DomesticatedAnimal;

import java.awt.*;
import java.util.ArrayList;

public class Cell {
    public static Cell[][] worldCells = new Cell[6][6];
    public static int WIDTH = 100;
    public static int HEIGHT = 100;
    ArrayList<Grass> grasses;
    Rectangle bounds;
    int x , y;
    private Cell(int x , int y) {
        grasses = new ArrayList<>();
        this.x = x;
        this.y = y;
        bounds = new Rectangle(x * WIDTH + WIDTH/4, y * HEIGHT + HEIGHT/4 , WIDTH/2 , HEIGHT/2);
    }
    public static void init(){
        for (int i = 0; i < worldCells.length; i++) {
            for (int i1 = 0; i1 < worldCells[i].length; i1++) {
                worldCells[i][i1] = new Cell(i , i1);
            }
        }
    }
    public void addGrass(){
        Grass grass = new Grass(x * WIDTH + WIDTH/4,y * HEIGHT + HEIGHT/4);
        grasses.add(grass);
    }
    public void removeGrass(){
        if(!grasses.isEmpty()){
            GameFieldStorage.grassHashSet.remove(grasses.remove(0));
        }
    }
    public void tick(){

    }
    public void render(Graphics graphics){
        graphics.drawImage(Assets.ground , x * WIDTH , y * HEIGHT , WIDTH , HEIGHT , null);
        for (Grass grass : grasses) {
            graphics.drawImage(Assets.grass , x * WIDTH + WIDTH/4, y * HEIGHT + HEIGHT/4, WIDTH/2 , HEIGHT/2 , null);
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public static void renderWorld(Graphics graphics){
        for (int i = 0; i < worldCells.length; i++) {
            for (int i1 = 0; i1 < worldCells[i].length; i1++) {
                worldCells[i][i1].render(graphics);
            }
        }
    }
    public static void tickWorld(){
        for (int i = 0; i < worldCells.length; i++) {
            for (int i1 = 0; i1 < worldCells[i].length; i1++) {
                worldCells[i][i1].tick();
            }
        }
    }
    public ArrayList<DomesticatedAnimal> getDomesticatedAnimals(){
        ArrayList<DomesticatedAnimal> domesticatedAnimalArrayList = new ArrayList<>();
        if(!grasses.isEmpty()) {
            for (DomesticatedAnimal domesticatedAnimal : GameFieldStorage.domesticatedAnimalHashSet) {
                if (domesticatedAnimal.checkForCollision(bounds)) {
                    domesticatedAnimalArrayList.add(domesticatedAnimal);
                }
            }
        }
        return domesticatedAnimalArrayList;
    }
}
