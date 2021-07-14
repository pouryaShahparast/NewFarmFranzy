package inGamGraphics.panels.rest;


import GUI.Inquiry;
import inGamGraphics.Program;
import inGamGraphics.panels.factoryPanels.FactoriesCombinedPanel;
import inGamGraphics.panels.storageAndTruckPanels.StorageAndTruckCombinedPanel;
import model.GameFieldStorage;
import model.PickUpTruck;
import model.Well;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPanels implements ActionListener {
    public static final int PANEL_WIDTH = 1000;
    public static final int PANEL_HEIGHT = 100;
    Well well;
    Program program;
    PickUpTruck pickUpTruck;
    JButton stop;
    JButton wellButton;
    JButton truck;
    JButton buyAnimal;
    JButton inquiryButton;
    JButton factories;
    JButton storage;
    JPanel panel;
    StorageAndTruckCombinedPanel storageAndTruckCombinedPanel;
    FactoriesCombinedPanel factoriesCombinedPanel;
    BuyAnimalPanel buyAnimalPanel;
    Inquiry inquiry;
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
        storageAndTruckCombinedPanel = new StorageAndTruckCombinedPanel(600,0);
        storageAndTruckCombinedPanel.init();

        factoriesCombinedPanel = new FactoriesCombinedPanel(600 , 0);
        factoriesCombinedPanel.init();
        buyAnimalPanel = new BuyAnimalPanel(600 , 0);
        drawPanel(buyAnimalPanel.getPanel());
    }
    public void tick(){
        storageAndTruckCombinedPanel.tick();
        factoriesCombinedPanel.tick();
    }
    public void firstInit(){
        wellButtonLauncher();
        truckButtonLauncher();
        stopButtonLauncher();
        buyAnimalButtonLauncher();
        factoriesButtonLauncher();
        inquiryButtonLauncher();
        storageButtonLauncher();
        panelLauncher();
        addToPanel();
    }
    private void wellButtonLauncher(){
        wellButton = new JButton();
        wellButton.setText("well");
        wellButton.setBounds(10,20,130,40);
        wellButton.addActionListener(this);
    }
    private void truckButtonLauncher(){
        truck = new JButton();
        truck.setText("truck");
        truck.setBounds(150,20,130,40);
        truck.addActionListener(this);
    }
    private void buyAnimalButtonLauncher(){
        buyAnimal = new JButton();
        buyAnimal.setText("buy animals");
        buyAnimal.setBounds(290,20,130,40);
        buyAnimal.addActionListener(this);
    }
    private void factoriesButtonLauncher(){
        factories = new JButton();
        factories.setText("factories");
        factories.setBounds(430,20,130,40);
        factories.addActionListener(this);
    }
    private void storageButtonLauncher(){
        storage = new JButton();
        storage.setText("storage");
        storage.setBounds(570,20,130,40);
        storage.addActionListener(this);
    }
    private void inquiryButtonLauncher(){
        inquiryButton = new JButton();
        inquiryButton.setText("inquiry");
        inquiryButton.setBounds(710,20,130,40);
        inquiryButton.addActionListener(this);
    }
    private void stopButtonLauncher(){
        stop = new JButton();
        stop.setText("stop");
        stop.setBounds(850,20,130,40);
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
        panel.add(buyAnimal);
        panel.add(storage);
        panel.add(factories);
        panel.add(inquiryButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == wellButton){
            well.startGettingWater();
        }
        if(e.getSource() == storage){
            drawPanel(storageAndTruckCombinedPanel.getCombinedPanel());
        }
        if(e.getSource() == truck){
            pickUpTruck.startTraveling();
        }
        if(e.getSource() == factories){
            drawPanel(factoriesCombinedPanel.getCombinedPanel());
        }
        if(e.getSource() == stop){
            stopWorks();
        }
        if(e.getSource() == buyAnimal){
            drawPanel(buyAnimalPanel.getPanel());
        }
        if(e.getSource() == inquiryButton){

        }
    }
    private void removeFromFrame(){
        program.getDisplay().getFrame().remove(storageAndTruckCombinedPanel.getCombinedPanel());
        program.getDisplay().getFrame().remove(factoriesCombinedPanel.getCombinedPanel());
        program.getDisplay().getFrame().remove(buyAnimalPanel.getPanel());
    }
    public boolean stopPane(){
        String[] responses = {"resume" , "exit"};
        int a =JOptionPane.showOptionDialog(null, "paused", "paused", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, responses[0]);
        return a == 1;
    }
    private void stopWorks(){
        program.setStop(true);
        if (!stopPane()) {
            program.setStop(false);
        } else {
            program.setRunning(false);
        }
    }
    private void drawPanel(JPanel jPanel){
        removeFromFrame();
        program.getDisplay().getFrame().add(jPanel);
        program.getDisplay().getFrame().revalidate();
        program.getDisplay().getFrame().repaint();
    }
//
    public JPanel getPanel() {
        return panel;
    }
}
