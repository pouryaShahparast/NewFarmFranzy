package inGamGraphics.panels.storageAndTruckPanels;

import model.GameFieldStorage;
import model.PickUpTruck;
import model.Storeroom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class TruckAndStoragePanels implements ActionListener {
    public static final int PANEL_WIDTH = 100;
    public static final int PANEL_HEIGHT = 200;
    Storeroom storeroom;
    PickUpTruck pickUpTruck;
    JLabel nameOrPicture;
    JLabel numInStorage;
    JLabel numInTruck;
    JButton truckLoudButton;
    JButton truckUnLoudButton;
    JPanel panel;

    public TruckAndStoragePanels(int x , int y) {
        storeroom = GameFieldStorage.storeroom;
        pickUpTruck = GameFieldStorage.pickUpTruck;
        firstInit();
        setPossession(x,y);
    }
    public abstract void init();
    public abstract void tick();
    public abstract void load();
    public abstract void unload();
    public void firstInit(){
        nameOrPictureLauncher();
        numInStorageLauncher();
        numInTruckLauncher();
        truckLoudButtonLauncher();
        truckUnLoudButtonLauncher();
        panelLauncher();
        addToPanel();
    }
    private void nameOrPictureLauncher(){
        nameOrPicture = new JLabel();
        nameOrPicture.setBounds(10,10,100,50);
        nameOrPicture.setFont(new Font(Font.DIALOG , Font.PLAIN , 20));
    }
    private void numInStorageLauncher(){
        numInStorage = new JLabel();
        numInStorage.setBounds(45,70,100,20);
        numInStorage.setFont(new Font(Font.DIALOG , Font.PLAIN , 20));
    }
    private void numInTruckLauncher(){
        numInTruck = new JLabel();
        numInTruck.setBounds(45,110,100,20);
        numInTruck.setFont(new Font(Font.DIALOG , Font.PLAIN , 20));
    }
    private void truckLoudButtonLauncher(){
        truckLoudButton = new JButton();
        truckLoudButton.setBounds(0,150,45,20);
        truckLoudButton.addActionListener(this);
    }
    private void truckUnLoudButtonLauncher(){
        truckUnLoudButton = new JButton();
        truckUnLoudButton.setBounds(50,150,45,20);
        truckUnLoudButton.addActionListener(this);
    }
    private void panelLauncher(){
        panel = new JPanel();
        panel.setLayout(null);
    }
    private void addToPanel(){
        panel.add(nameOrPicture);
        panel.add(numInStorage);
        panel.add(numInTruck);
        panel.add(truckLoudButton);
        panel.add(truckUnLoudButton);
    }
    public void setPossession(int x , int y){
        panel.setBounds(x,y,PANEL_WIDTH , PANEL_HEIGHT);
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == truckLoudButton){
            load();
           // System.out.println(1);
        }
        if(e.getSource() == truckUnLoudButton){
            unload();
        //c    System.out.println(2);
        }
    }
}
