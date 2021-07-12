package model.animals;

import inGamGraphics.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

abstract class Animal {
    int speed;

    static final int ANIMAL_WIDTH = 100;
    static final int BORDER_WIDTH = 10;
    static final int DEFAULT_SPEED = 4;
    static final int ANIMAL_HEIGHT = 100;
    String animalName;
    enum MOVE_DIRECTIONS{
        LEFT,RIGHT,UP,DOWN
    }
    protected MOVE_DIRECTIONS direction;
    protected Animation downAnimation;
    protected Animation upAnimation;
    protected Animation leftAnimation;
    protected Animation rightAnimation;
    protected Rectangle bounds;
    int xCoordinate;
    int yCoordinate;
    public Animal() {
        speed = DEFAULT_SPEED;
        Random random = new Random();
        xCoordinate = random.nextInt(500);
        yCoordinate = random.nextInt(500);
        bounds = new Rectangle(0 , 0 ,ANIMAL_WIDTH , ANIMAL_HEIGHT - 30);
        switch (random.nextInt(4)){
            case 0:
                direction = MOVE_DIRECTIONS.DOWN;
                break;
            case 1:
                direction = MOVE_DIRECTIONS.LEFT;
                break;
            case 2:
                direction = MOVE_DIRECTIONS.RIGHT;
                break;
            case 3:
                direction = MOVE_DIRECTIONS.UP;
                break;
        }
    }

    public Rectangle getCollisionBounds(){
        return new Rectangle(xCoordinate + bounds.x , yCoordinate + bounds.y , bounds.width , bounds.height);
    }
    public boolean checkForCollision(Rectangle rectangle){
        return getCollisionBounds().intersects(rectangle);
    }


    abstract public void shortTick();
    abstract public void longTick();
    abstract public void render(Graphics graphics);
    protected void randomMoveDirection(){
        Random random = new Random();
        int a = random.nextInt(25);
        switch (direction){
            case UP :
                randomMoveDirectionInUp(a);
                break;
            case DOWN:
                randomMoveDirectionInDown(a);
                break;
            case RIGHT:
                randomMoveDirectionInRight(a);
                break;
            case LEFT:
                randomMoveDirectionInLeft(a);
                break;
        }
    }
    protected void randomMoveDirectionInUp(int a){
        if((a >= 0 ) && (a <= 21)){
            direction = MOVE_DIRECTIONS.UP;
        }else if(a == 22){
            direction = MOVE_DIRECTIONS.DOWN;
        }else if(a == 23){
            direction = MOVE_DIRECTIONS.RIGHT;
        }else if(a == 24){
            direction = MOVE_DIRECTIONS.LEFT;
        }
    }
    protected void randomMoveDirectionInDown(int a){
        if((a >= 0 ) && (a <= 21)){
            direction = MOVE_DIRECTIONS.DOWN;
        }else if(a == 22){
            direction = MOVE_DIRECTIONS.UP;
        }else if(a == 23){
            direction = MOVE_DIRECTIONS.RIGHT;
        }else if(a == 24){
            direction = MOVE_DIRECTIONS.LEFT;
        }
    }
    protected void randomMoveDirectionInRight(int a){
        if((a >= 0 ) && (a <= 21)){
            direction = MOVE_DIRECTIONS.RIGHT;
        }else if(a == 22){
            direction = MOVE_DIRECTIONS.UP;
        }else if(a == 23){
            direction = MOVE_DIRECTIONS.DOWN;
        }else if(a == 24){
            direction = MOVE_DIRECTIONS.LEFT;
        }
    }
    protected void randomMoveDirectionInLeft(int a){
        if((a >= 0 ) && (a <= 21)){
            direction = MOVE_DIRECTIONS.LEFT;
        }else if(a == 22){
            direction = MOVE_DIRECTIONS.UP;
        }else if(a == 23){
            direction = MOVE_DIRECTIONS.DOWN;
        }else if(a == 24){
            direction = MOVE_DIRECTIONS.RIGHT;
        }
    }
    protected boolean canMoveLeft(){
        boolean b =  xCoordinate - speed >= 0;
        if(!b){
            direction = notLeft();
        }
        return b;
    }
    protected void moveLeft(){
        xCoordinate -= speed;
    }
    protected boolean canMoveDown(){

        boolean b = yCoordinate + bounds.height + speed <= 600 - BORDER_WIDTH;
        if(!b){
            direction = notDown();
        }
        return b;
    }
    protected void moveDown(){
        yCoordinate += speed;
    }
    protected boolean canMoveUp(){
        boolean b =  yCoordinate - speed >= 0;
        if(!b){
            direction = notUp();
        }
        return b;
    }
    protected void moveUP(){
        yCoordinate -= speed;

    }
    protected boolean canMoveRight(){
        boolean b =  xCoordinate + bounds.width + speed <= 600 - BORDER_WIDTH;
        if(!b){
            direction = notRight();
        }
        return b;
    }
    protected void moveRight(){
        xCoordinate += speed;
    }
    protected void randomMove(){
        randomMoveDirection();
        moving();
    }
    protected void moving(){
        switch (direction){
            case UP :
                if(canMoveUp()){
                    moveUP();
                }
                break;
            case DOWN:
                if(canMoveDown()){
                    moveDown();
                }
                break;
            case RIGHT:
                if(canMoveRight()){
                    moveRight();
                }
                break;
            case LEFT:
                if(canMoveLeft()){
                    moveLeft();
                }
                break;
        }
    }
    abstract public void move();
    @Override
    public abstract String toString();
    protected Animation getCurrentAnimation(){
        switch (direction){
            case UP :
                return upAnimation;
            case DOWN:
                return downAnimation;
            case RIGHT:
                return rightAnimation;
            case LEFT:
                return leftAnimation;
        }
        return null;
    }
    protected BufferedImage getCurrentFrame(){
        return getCurrentAnimation().getCurrentFrame();
    }
    private MOVE_DIRECTIONS notDown(){
        Random random = new Random();
        switch (random.nextInt(3)){
            case 1:
                return MOVE_DIRECTIONS.UP;
            case 2:
                return MOVE_DIRECTIONS.LEFT;
            case 0:
                return MOVE_DIRECTIONS.RIGHT;
        }
        return MOVE_DIRECTIONS.DOWN;
    }
    private MOVE_DIRECTIONS notRight(){
        Random random = new Random();
        switch (random.nextInt(3)){
            case 1:
                return MOVE_DIRECTIONS.DOWN;
            case 2:
                return MOVE_DIRECTIONS.LEFT;
            case 0:
                return MOVE_DIRECTIONS.UP;
        }
        return MOVE_DIRECTIONS.RIGHT;
    }
    private MOVE_DIRECTIONS notLeft(){
        Random random = new Random();
        switch (random.nextInt(3)){
            case 1:
                return MOVE_DIRECTIONS.DOWN;
            case 2:
                return MOVE_DIRECTIONS.UP;
            case 0:
                return MOVE_DIRECTIONS.RIGHT;
        }
        return MOVE_DIRECTIONS.LEFT;
    }
    private MOVE_DIRECTIONS notUp(){
        Random random = new Random();
        switch (random.nextInt(3)){
            case 1:
                return MOVE_DIRECTIONS.DOWN;
            case 2:
                return MOVE_DIRECTIONS.LEFT;
            case 0:
                return MOVE_DIRECTIONS.RIGHT;
        }
        return MOVE_DIRECTIONS.UP;
    }

    public boolean xInRang(int x){
        return (xCoordinate >= x - 10) && (xCoordinate <= x + 10);
    }

    public boolean yInRang(int y){
        return (yCoordinate >= y - 10) && (yCoordinate <= y + 10);
    }

    //getters and setters
    public int getXCoordinate() {
        return xCoordinate;
    }
    public int getYCoordinate() {
        return yCoordinate;
    }

}
