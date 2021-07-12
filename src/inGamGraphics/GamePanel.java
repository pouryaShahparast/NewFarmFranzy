package inGamGraphics;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JPanel panel;
    private Canvas canvas;
    private int width , height , x , y;
    public GamePanel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        createGamePanel();
    }
    private void createGamePanel(){
        panel = new JPanel();
        panel.setBounds(x , y ,width ,height);
        panel.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        panel.add(canvas);

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JPanel getPanel() {
        return panel;
    }
}
