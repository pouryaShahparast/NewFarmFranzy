package GUI;

import javax.swing.*;
import java.awt.*;

public class CoinPanel extends JPanel {


    public CoinPanel()
    {
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setBounds(150,50,700,500);


    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d= (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.drawImage(new ImageIcon("coin.jpg").getImage()
,0,0,null);

    }
}
