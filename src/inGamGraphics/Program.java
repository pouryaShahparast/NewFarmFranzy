package inGamGraphics;

import inGamGraphics.panels.factoryPanels.FactoriesCombinedPanel;
import inGamGraphics.panels.rest.ActionPanels;
import inGamGraphics.panels.storageAndTruckPanels.StorageAndTruckCombinedPanel;
import model.*;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Program implements Runnable{
    private Display display;

    private int width;
    private int height;
    private String title;
    private JFrame jFrame;
    private StorageAndTruckCombinedPanel storageAndTruckCombinedPanel;
    private FactoriesCombinedPanel factoriesCombinedPanel;
    private ActionPanels actionPanels;

    private BufferStrategy bufferStrategy;
    private Graphics graphic;

    private boolean running = false;
    private boolean stop = false;
    private Thread thread;

//    public Program(int width, int height, String title) {
//        this.width = width;
//        this.height = height;
//        this.title = title;
//    }

    public Program(int width, int height, JFrame jFrame) {
        this.width = width;
        this.height = height;
        this.jFrame = jFrame;
    }

    private void init(){
        //   display = new Display(title , width , height, 600 ,600 , 0 ,0);
        display = new Display(jFrame , width , height , 600 , 600 , 0 ,0);
        Assets.init();
        Cell.init();
        //
        GameFieldStorage.init(1000);
        //


        storageAndTruckCombinedPanel = new StorageAndTruckCombinedPanel(0,600);
        storageAndTruckCombinedPanel.init();
        display.getFrame().add(storageAndTruckCombinedPanel.getCombinedPanel());

        factoriesCombinedPanel = new FactoriesCombinedPanel(600 , 0);
        factoriesCombinedPanel.init();
        display.getFrame().add(factoriesCombinedPanel.getCombinedPanel());

        actionPanels = new ActionPanels(1300 , 600 , this);
        actionPanels.init();
        display.getFrame().add(actionPanels.getPanel());

        MouseInput mouseInput = new MouseInput();
        GameState.gameState = new GameState();

        GameState.gameState.init();

        State.setCurrentState(GameState.gameState);

        display.getPanel().addMouseListener(mouseInput);
        display.getCanvas().addMouseListener(mouseInput);

        display.getFrame().setVisible(true);
    }
    private void tick(){
        if(State.getCurrentState() != null){
            //
            State.getCurrentState().tick();
            //
            storageAndTruckCombinedPanel.tick();
            factoriesCombinedPanel.tick();
            actionPanels.tick();
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
            if (checkGameLoopTimer()) {
                if(!stop) {
                    tick();
                    render();
                }
                ticks++;
                delta--;
            }
            if (timer >= 1_000_000_000) {
                //    System.out.println(ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }
    private void gameLoopTimerInit(){
        fps = 30;
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
        if(!running){
            running = false;
            jFrame.getContentPane().removeAll();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //


    public boolean getRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean getStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Thread getThread() {
        return thread;
    }
}
