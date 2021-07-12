package inGamGraphics.panels.storageAndTruckPanels;

import javax.swing.*;
import java.awt.*;

public class InfoPanel {
    public static final int PANEL_WIDTH = 100;
    public static final int PANEL_HEIGHT = 200;
    JLabel nameOrPicture;
    JLabel numInStorage;
    JLabel numInTruck;
    JLabel buttons;
    JPanel panel;
    public void firstInit(){
        nameOrPictureLauncher();
        numInStorageLauncher();
        numInTruckLauncher();
        buttonsLauncher();
        panelLauncher();
        addToPanel();
    }
    public InfoPanel(int x , int y) {
        firstInit();
        setPossession(x,y);
    }
    private void nameOrPictureLauncher(){
        nameOrPicture = new JLabel();
        nameOrPicture.setBounds(0,10,100,50);
        nameOrPicture.setFont(new Font(Font.DIALOG , Font.PLAIN , 20));
        nameOrPicture.setText("name :");
    }

    private void numInStorageLauncher(){
        numInStorage = new JLabel();
        numInStorage.setBounds(0,70,100,30);
        numInStorage.setFont(new Font(Font.DIALOG , Font.PLAIN , 20));
        numInStorage.setText("storage :");
    }
    private void numInTruckLauncher(){
        numInTruck = new JLabel();
        numInTruck.setBounds(0,110,100,30);
        numInTruck.setFont(new Font(Font.DIALOG , Font.PLAIN , 20));
        numInTruck.setText("truck :");
    }
    private void buttonsLauncher(){
        buttons = new JLabel();
        buttons.setBounds(0,150,100,30);
        buttons.setFont(new Font(Font.DIALOG , Font.PLAIN , 15));
        buttons.setText("load/unload :");
    }
    private void panelLauncher(){
        panel = new JPanel();
        panel.setLayout(null);
    }
    private void addToPanel(){
        panel.add(nameOrPicture);
        panel.add(numInStorage);
        panel.add(numInTruck);
        panel.add(buttons);
    }
    public void setPossession(int x , int y){
        panel.setBounds(x,y,PANEL_WIDTH , PANEL_HEIGHT);
    }

    public JPanel getPanel() {
        return panel;
    }
}
