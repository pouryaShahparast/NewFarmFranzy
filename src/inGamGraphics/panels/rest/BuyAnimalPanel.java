package inGamGraphics.panels.rest;

import model.Coin;
import model.GameFieldStorage;
import model.animals.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyAnimalPanel implements ActionListener {
    public static final int PANEL_WIDTH = 400;
    public static final int PANEL_HEIGHT = 600;
    Coin coin;
    JButton cat;
    JButton dog;
    JButton buffalo;
    JButton chicken;
    JButton turkey;
    JPanel panel;
    public void setPossession(int x , int y){
        panel.setBounds(x,y,PANEL_WIDTH , PANEL_HEIGHT);
    }

    public BuyAnimalPanel(int x , int y ) {
        this.coin = GameFieldStorage.coin;
        firstInit();
        setPossession(x,y);
    }
    public void firstInit(){
        catButtonLauncher();
        dogButtonLauncher();
        chickenButtonLauncher();
        turkeyButtonLauncher();
        buffaloButtonLauncher();
        panelLauncher();
        addToPanel();
    }
    private void catButtonLauncher(){
        cat = new JButton();
        cat.setText("cat");
        cat.setBounds(0,0,120,40);
        cat.addActionListener(this);
    }
    private void dogButtonLauncher(){
        dog = new JButton();
        dog.setText("dog");
        dog.setBounds(130,0,120,40);
        dog.addActionListener(this);

    }
    private void chickenButtonLauncher(){
        chicken = new JButton();
        chicken.setText("chicken");
        chicken.setBounds(0,60,120,40);
        chicken.addActionListener(this);
    }
    private void turkeyButtonLauncher(){
        turkey = new JButton();
        turkey.setText("turkey");
        turkey.setBounds(130,60,120,40);
        turkey.addActionListener(this);
    }
    private void buffaloButtonLauncher(){
        buffalo = new JButton();
        buffalo.setText("buffalo");
        buffalo.setBounds(65,120,120,40);
        buffalo.addActionListener(this);
    }
    private void panelLauncher(){
        panel = new JPanel();
        panel.setLayout(null);
    }
    private void addToPanel(){
        panel.add(cat);
        panel.add(dog);
        panel.add(chicken);
        panel.add(turkey);
        panel.add(buffalo);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cat){
            Cat.buyCat(coin);
        }
        if(e.getSource() == dog){
            Dog.buyDog(coin);
        }
        if(e.getSource() == chicken){
            Chicken.buyChicken(coin);
        }
        if(e.getSource() == turkey){
            Turkey.buyTurkey(coin);
        }
        if(e.getSource() == buffalo){
            Buffalo.buyBuffalo(coin);
        }
    }






    public JPanel getPanel() {
        return panel;
    }
}
