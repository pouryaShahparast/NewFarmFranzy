package inGamGraphics.panels.factoryPanels;

import javax.swing.*;

public class FactoriesCombinedPanel {
    public static final int COMBINED_PANEL_WIDTH = 1000;
    public static final int COMBINED_PANEL_HEIGHT = 400;
    JPanel combinedPanel;
    JPanel buyPanel;
    AbstractFactoryPanel[] abstractFactoryPanels;
    public void setPossession(int x , int y){
        combinedPanel.setBounds(x,y,COMBINED_PANEL_WIDTH , COMBINED_PANEL_HEIGHT);
    }
    public void init(){
        for (int i = 0; i < abstractFactoryPanels.length; i++) {
            abstractFactoryPanels[i].init();
        }
    }
    public void tick(){
        for (int i = 0; i < abstractFactoryPanels.length; i++) {
            abstractFactoryPanels[i].tick();
        }
    }

    public FactoriesCombinedPanel(int x ,int y) {
        abstractFactoryPanels = new AbstractFactoryPanel[7];
        abstractFactoryPanelsLauncher();
        buyPanel = new BuyAnimalPanel(AbstractFactoryPanel.PANEL_WIDTH * 3 , AbstractFactoryPanel.PANEL_HEIGHT).getPanel();
        combinedPanelLauncher();
        addToCombinedPanel();
        setPossession(x,y);
    }
    private void combinedPanelLauncher(){
        combinedPanel = new JPanel();
        combinedPanel.setLayout(null);
    }
    public void abstractFactoryPanelsLauncher(){
        abstractFactoryPanels[0] = new BakeryPanel(0 , 0);
        abstractFactoryPanels[1] = new ChickenMakingPanel(AbstractFactoryPanel.PANEL_WIDTH , 0);
        abstractFactoryPanels[2] = new FabricProductionPanel(AbstractFactoryPanel.PANEL_WIDTH * 2 , 0);
        abstractFactoryPanels[3] = new IceCreamMakerFactoryPanel(AbstractFactoryPanel.PANEL_WIDTH * 3 , 0);
        abstractFactoryPanels[4] = new MilkPocketingProductionPanel(0 , AbstractFactoryPanel.PANEL_HEIGHT);
        abstractFactoryPanels[5] = new MillPanel(AbstractFactoryPanel.PANEL_WIDTH , AbstractFactoryPanel.PANEL_HEIGHT);
        abstractFactoryPanels[6] = new TailoringPanel(AbstractFactoryPanel.PANEL_WIDTH * 2 , AbstractFactoryPanel.PANEL_HEIGHT);

    }

    public void addToCombinedPanel(){
        combinedPanel.add(buyPanel);
        for (int i = 0; i < abstractFactoryPanels.length; i++) {
            combinedPanel.add(abstractFactoryPanels[i].getPanel());
        }
    }

    public JPanel getCombinedPanel() {
        return combinedPanel;
    }
}
