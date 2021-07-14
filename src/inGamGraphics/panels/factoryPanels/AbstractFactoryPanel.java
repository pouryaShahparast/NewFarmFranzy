package inGamGraphics.panels.factoryPanels;

import model.Coin;
import model.GameFieldStorage;
import model.Storeroom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractFactoryPanel implements ActionListener {
    public static final int PANEL_WIDTH = 200;
    public static final int PANEL_HEIGHT = 130;
    Coin coin;
    Storeroom storeroom;
    JLabel factoryNameOrImage;
    JButton build;
    JButton update;
    JButton workWithOne;
    JButton workWithTwo;
    JPanel panel;

    public AbstractFactoryPanel(int x , int y) {
        storeroom = GameFieldStorage.storeroom;
        coin = GameFieldStorage.coin;
        firstInit();
        setPossession(x,y);
    }

    public abstract void init();
    public abstract void tick();
    public abstract boolean build();
    public abstract boolean update();
    public abstract boolean workWithOne();
    public abstract boolean workWithTwo();

    public void setPossession(int x , int y){
        panel.setBounds(x,y,PANEL_WIDTH , PANEL_HEIGHT);
    }

    public void firstInit(){
        factoryNameOrImageLauncher();
        buildButtonLauncher();
        updateButtonLauncher();
        workWithOneButtonLauncher();
        workWithTwoButtonLauncher();
        panelLauncher();
        addToPanel();
    }
    private void factoryNameOrImageLauncher(){
        factoryNameOrImage = new JLabel();
        factoryNameOrImage.setBounds(10,10,190,60);
        factoryNameOrImage.setFont(new Font(Font.DIALOG , Font.PLAIN , 30));
    }
    private void buildButtonLauncher(){
        build = new JButton();
        build.setText("build");
        build.setBounds(0,70,95,25);
        build.addActionListener(this);
        build.setEnabled(true);
    }
    private void updateButtonLauncher(){
        update = new JButton();
        update.setText("update");
        update.setBounds(105,70,95,25);
        update.addActionListener(this);
        update.setEnabled(false);
    }
    private void workWithOneButtonLauncher(){
        workWithOne = new JButton();
        workWithOne.setText("one");
        workWithOne.setBounds(0,105,95,25);
        workWithOne.addActionListener(this);
        workWithOne.setEnabled(false);
    }
    private void workWithTwoButtonLauncher(){
        workWithTwo = new JButton();
        workWithTwo.setText("two");
        workWithTwo.setBounds(105,105,95,25);
        workWithTwo.addActionListener(this);
        workWithTwo.setEnabled(false);
    }
    private void panelLauncher(){
        panel = new JPanel();
        panel.setLayout(null);
    }
    private void addToPanel(){
        panel.add(factoryNameOrImage);
        panel.add(build);
        panel.add(update);
        panel.add(workWithOne);
        panel.add(workWithTwo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == build){
            if(build()){
                build.setEnabled(false);
                workWithOne.setEnabled(true);
                update.setEnabled(true);
            }
        }
        if(e.getSource() == update){
            if(update()){
                update.setEnabled(false);
                workWithTwo.setEnabled(true);
            }
        }
        if(e.getSource() == workWithOne){
            workWithOne();
        }
        if(e.getSource() == workWithTwo){
            workWithTwo();
        }
    }


    public JPanel getPanel() {
        return panel;
    }
}
