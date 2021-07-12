package inGamGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame implements ActionListener {
    JFrame frame;
    String title;
    JButton button;
    int width;
    int height;
    public GameFrame(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
     //   this.frame = frame;

        createFrame();
    }

    public GameFrame(JFrame frame , int width , int height) {
        this.frame = frame;
        createFrame();
    }

    private void createFrame(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);



    }
    public void addToFrame(Component component){
        frame.add(component);
    }
    public void setVisible(boolean a){
        frame.setVisible(a);
    }

    public JFrame getFrame() {
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("KK");
        }
    }
}
