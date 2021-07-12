package inGamGraphics.panels.factoryPanels;

import model.GameFieldStorage;
import model.factories.Factory;
import model.factories.Tailoring;

public class TailoringPanel extends AbstractFactoryPanel{
    public TailoringPanel(int x, int y) {
        super(x, y);
    }

    @Override
    public void init() {
        factoryNameOrImage.setText("tailoring");
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean build() {
        boolean found = false;

        for (Factory factory :
                GameFieldStorage.factoryHashSet) {
            if (factory instanceof Tailoring) {
                found = true;
                //       System.out.println(ConsoleColors.RED+"Already exists"+ConsoleColors.RESET);
                break;

            }
        }
        if (!found) {
            return Tailoring.buildTailoring(coin);

        }
        return false;
    }

    @Override
    public boolean update() {
        boolean found = false;

        for (Factory factory :
                GameFieldStorage.factoryHashSet) {
            if (factory instanceof Tailoring) {
                found = true;
                return factory.upgrade(coin);

            }
        }

//        if (!found) {
//            LoggingToFile.logToFile("factory doesn't exist  first create bakery factory_matcher 13","info" );
//            System.out.println(ConsoleColors.RED + "factory doesn't exist  first create bakery factory" + ConsoleColors.RESET);
//        }
        return false;

    }

    @Override
    public boolean workWithOne() {
        boolean found = false;

        for (Factory factory :
                GameFieldStorage.factoryHashSet) {
            if (factory instanceof Tailoring) {
                found = true;
                return factory.startWorkingOneCommodity(storeroom);
                //  break;

            }
        }
//        if (!found) {
//            LoggingToFile.logToFile("factory doesn't exist  first create bakery factory","info");
//            System.out.println(ConsoleColors.RED + "factory doesn't exist  first create bakery factory" + ConsoleColors.RESET);
//        }
        return false;
    }

    @Override
    public boolean workWithTwo() {
        boolean found = false;

        for (Factory factory :
                GameFieldStorage.factoryHashSet) {
            if (factory instanceof Tailoring) {
                found = true;
                return factory.startWorkingTwoCommodities(storeroom);
                // break;

            }
        }
//        if (!found) {
//            System.out.println(ConsoleColors.RED + "factory doesn't exist  first create bakery factory" + ConsoleColors.RESET);
//        }
        return false;
    }
}
