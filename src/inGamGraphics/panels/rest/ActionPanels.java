package inGamGraphics.panels.rest;


import inGamGraphics.Program;
import model.GameFieldStorage;
import model.PickUpTruck;
import model.Well;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPanels implements ActionListener {
    public static final int PANEL_WIDTH = 300;
    public static final int PANEL_HEIGHT = 200;
    Well well;
    Program program;
    PickUpTruck pickUpTruck;
    JButton stop;
    JButton wellButton;
    JButton truck;
    JPanel panel;
    public void setPossession(int x , int y){
        panel.setBounds(x,y,PANEL_WIDTH , PANEL_HEIGHT);
    }

    public ActionPanels(int x , int y , Program program) {
        well = GameFieldStorage.well;
        pickUpTruck = GameFieldStorage.pickUpTruck;
        this.program = program;
        firstInit();
        setPossession(x,y);
    }

    public void init(){

    }
    public void tick(){

    }
    public void firstInit(){
        wellButtonLauncher();
        truckButtonLauncher();
        stopButtonLauncher();
        panelLauncher();
        addToPanel();
    }
    private void wellButtonLauncher(){
        wellButton = new JButton();
        wellButton.setText("well");
        wellButton.setBounds(50,0,150,30);
        wellButton.addActionListener(this);
    }
    private void truckButtonLauncher(){
        truck = new JButton();
        truck.setText("truck");
        truck.setBounds(50,60,150,30);
        truck.addActionListener(this);
    }
    private void stopButtonLauncher(){
        stop = new JButton();
        stop.setText("stop");
        stop.setBounds(50,120,150,30);
        stop.addActionListener(this);
    }
    private void panelLauncher(){
        panel = new JPanel();
        panel.setLayout(null);
    }
    private void addToPanel(){
        panel.add(wellButton);
        panel.add(truck);
        panel.add(stop);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == wellButton){
            well.startGettingWater();
        }
        if(e.getSource() == truck){
            pickUpTruck.startTraveling();
        }
        if(e.getSource() == stop){
            //program.setStop(!program.getStop());
            program.setRunning(false);
        }
    }


    public JPanel getPanel() {
        return panel;
    }
}
