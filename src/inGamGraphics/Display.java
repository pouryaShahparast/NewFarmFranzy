package inGamGraphics;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    private JPanel panel;
    private JButton button;
    private JButton button2;


    private String frameTitle;
    private int frameWidth , frameHeight , panelWidth , panelHeight , panelX , panelY;

    public Display(String frameTitle, int frameWidth, int frameHeight, int panelWidth, int panelHeight, int panelX, int panelY) {
        this.frameTitle = frameTitle;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.panelX = panelX;
        this.panelY = panelY;

        createDisplay();
    }

    public Display(JFrame frame, int frameWidth, int frameHeight, int panelWidth, int panelHeight, int panelX, int panelY) {
        this.frame = frame;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.panelX = panelX;
        this.panelY = panelY;
        createDisplay2();
    }

    private void createDisplay(){
        GamePanel gamePanel = new GamePanel(panelX , panelY , panelWidth , panelHeight);
        panel = gamePanel.getPanel();
        GameFrame gameFrame = new GameFrame(frameTitle, frameWidth , frameHeight);
        frame = gameFrame.getFrame();
        canvas = gamePanel.getCanvas();
        frame.add(panel);


    }
    private void createDisplay2(){
        GamePanel gamePanel = new GamePanel(panelX , panelY , panelWidth , panelHeight);
        panel = gamePanel.getPanel();

        canvas = gamePanel.getCanvas();
        frame.setSize(frameWidth , frameHeight);
        frame.add(panel);


    }
    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JPanel getPanel() {
        return panel;
    }
}
