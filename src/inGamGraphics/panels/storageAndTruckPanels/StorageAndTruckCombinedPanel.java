package inGamGraphics.panels.storageAndTruckPanels;

import javax.swing.*;

public class StorageAndTruckCombinedPanel {
    public static final int COMBINED_PANEL_WIDTH = 1300;
    public static final int COMBINED_PANEL_HEIGHT = 200;
    JPanel combinedPanel;
    JPanel info;
    TruckAndStoragePanels[] truckAndStoragePanels;
    public void setPossession(int x , int y){
        combinedPanel.setBounds(x,y,COMBINED_PANEL_WIDTH , COMBINED_PANEL_HEIGHT);
    }

    public void init(){
        for (int i = 0; i < truckAndStoragePanels.length; i++) {
            truckAndStoragePanels[i].init();
        }
    }
    public void tick(){
        for (int i = 0; i < truckAndStoragePanels.length; i++) {
            truckAndStoragePanels[i].tick();
        }
    }

    public StorageAndTruckCombinedPanel(int x , int y) {
        truckAndStoragePanels = new TruckAndStoragePanels[12];
        truckAndStoragePanelsLauncher();
        info = new InfoPanel(0,0).panel;
        combinedPanelLauncher();
        addToCombinedPanel();
        setPossession(x,y);
    }
    private void combinedPanelLauncher(){
        combinedPanel = new JPanel();
        combinedPanel.setLayout(null);
    }
    private void truckAndStoragePanelsLauncher(){
        truckAndStoragePanels[0] = new EggPanel(TruckAndStoragePanels.PANEL_WIDTH , 0);
        truckAndStoragePanels[1] = new BreadPanel(TruckAndStoragePanels.PANEL_WIDTH * 2, 0);
        truckAndStoragePanels[2] = new ClothPanel(TruckAndStoragePanels.PANEL_WIDTH * 3, 0);
        truckAndStoragePanels[3] = new FabricPanel(TruckAndStoragePanels.PANEL_WIDTH * 4, 0);
        truckAndStoragePanels[4] = new FeatherPanel(TruckAndStoragePanels.PANEL_WIDTH * 5, 0);
        truckAndStoragePanels[5] = new FlourPanel(TruckAndStoragePanels.PANEL_WIDTH * 6, 0);
        truckAndStoragePanels[6] = new IceCreamPanel(TruckAndStoragePanels.PANEL_WIDTH * 7 , 0);
        truckAndStoragePanels[7] = new MilkPanel(TruckAndStoragePanels.PANEL_WIDTH * 8, 0);
        truckAndStoragePanels[8] = new PocketMilkPanels(TruckAndStoragePanels.PANEL_WIDTH * 9, 0);
        truckAndStoragePanels[9] = new TigerPanel(TruckAndStoragePanels.PANEL_WIDTH * 10, 0);
        truckAndStoragePanels[10] = new LoinPanel(TruckAndStoragePanels.PANEL_WIDTH * 11, 0);
        truckAndStoragePanels[11] = new BearPanel(TruckAndStoragePanels.PANEL_WIDTH * 12, 0);
    }
    public void addToCombinedPanel(){
        combinedPanel.add(info);
        for (int i = 0; i < truckAndStoragePanels.length; i++) {
            combinedPanel.add(truckAndStoragePanels[i].getPanel());
        }
    }

    public JPanel getCombinedPanel() {
        return combinedPanel;
    }
}
