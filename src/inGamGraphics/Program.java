package inGamGraphics;

import model.*;
import model.animals.Chicken;
import model.animals.Turkey;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Program implements Runnable{
    private graphics.Display display;

    Coin coin;
    Well well;
    PickUpTruck pickUpTruck;
    Storeroom storeroom;
    private int width;
    private int height;
    private String title;

    private BufferStrategy bufferStrategy;
    private Graphics graphic;

    private boolean running = false;

    private Thread thread;

    public Program(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init(){
        display = new graphics.Display(title , width , height);
        Assets.init();
        Cell.init();
        //
        coin = new Coin(200);
        //
        well = new Well();
        pickUpTruck = new PickUpTruck();
        storeroom = new Storeroom();
        MouseInput mouseInput = new MouseInput(storeroom , well);
        GameState.gameState = new GameState(coin , well , pickUpTruck , storeroom);
        State.setCurrentState(GameState.gameState);
        display.getFrame().addMouseListener(mouseInput);
        display.getCanvas().addMouseListener(mouseInput);
        GameFieldStorage.domesticatedAnimalHashSet.add(new Chicken());
        GameFieldStorage.domesticatedAnimalHashSet.add(new Turkey());
    }
    private void tick(){
        if(State.getCurrentState() != null){
            //
            State.getCurrentState().tick();
            //
        }
    }
    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphic = bufferStrategy.getDrawGraphics();

        graphic.clearRect(0,0,width,height);
        //


        if(State.getCurrentState() != null){
            State.getCurrentState().render(graphic);
        }

        //
        bufferStrategy.show();
        graphic.dispose();
    }
    int fps;
    double timePerTick;
    double delta;
    long now;
    long lastTime;
    long timer;
    int ticks;
    @Override
    public void run() {
        init();
        gameLoopTimerInit();
        while (running){
            if(checkGameLoopTimer()) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1_000_000_000){
            //    System.out.println(ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }
    private void gameLoopTimerInit(){
        fps = 50;
        timePerTick = (double) 1_000_000_000 / fps;
        delta = 0;
        lastTime = System.nanoTime();
        timer = 0;
        ticks = 0;
    }
    private boolean checkGameLoopTimer(){
        now = System.nanoTime();
        delta += (now - lastTime) / timePerTick;
        timer += now - lastTime;
        lastTime = now;
        return delta >= 1;
    }

    public synchronized void start(){
        if(!running){
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    public synchronized void stop(){
        if(running){
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
