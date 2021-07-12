package GUI;
import ETC.ConsoleColors;
import ETC.Task1;
import model.PickUpTruck;
import model.Storeroom;
import model.commodities.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Inquiry extends JPanel {
    Task1 task;
    PickUpTruck pickUpTruck;
    Storeroom storeroom;
    ArrayList<MyTextField>arr;
    JPanel jPanel;
public Inquiry(Task1 task){

    this.task=task;
    pickUpTruck = new PickUpTruck();
    storeroom = new Storeroom();






    jPanel=new JPanel(new GridLayout(5,1,5,5));
    jPanel.setBounds(50,50,400,400);
    jPanel.setOpaque(true);
    jPanel.setBackground(Color.RED);



    arr=new ArrayList<>();


   this.setLayout(null);
   this.setBounds(0,0,500,500);
   this.setOpaque(true);
   this.setBackground(Color.cyan);
    for (String s :
            task.neededCommodity.keySet()) {
        MyTextField jTextField=new MyTextField(s);
         arr.add(jTextField);


    }
    for (JTextField j :
            arr) {
        jPanel.add(j);
    }
    jPanel.revalidate();
    jPanel.repaint();
    this.add(jPanel);
    this.revalidate();
    this.repaint();
    GUIEntrance.jFrame.add(this);
    GUIEntrance.jFrame.revalidate();
    GUIEntrance.jFrame.repaint();



}
    public boolean checkIfNeededIsPrepared()
    {




        boolean f1=true,f2=true,f3=true,f4=true,f5=true,f6=true,f7=true;
        for (String string :
                task.neededCommodity.keySet()) {


            if (string.equalsIgnoreCase("bread")) {
                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                     arr) {
                    if(myTextField1.name.equalsIgnoreCase("bread"))
                    {
                        myTextField=myTextField1;

                    }


                }





                f1 = true;
                int amountNeeded = task.neededCommodity.get("bread");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Bread)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    myTextField.setText("amount of Bread is complete");
                    //System.out.println();
                    System.out.println("Bread " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f1 = true;
                } else {
                    myTextField.setText("Bread "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));
                    //System.out.println("Bread " + ConsoleColors.BLUE + amountExisting  + ConsoleColors.RESET);
                    f1 = false;

                }

            }


            if (string.equalsIgnoreCase("cloth")) {
                f2 = true;
                int amountNeeded = task.neededCommodity.get("cloth");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Cloth)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    System.out.println("amount of Cloth is complete");
                    System.out.println("Cloth " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f2 = true;
                } else {
                    System.out.println("Cloth "+ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f2 = false;

                }

            }
            if (string.equalsIgnoreCase("egg")) {
                f2 = true;
                int amountNeeded = task.neededCommodity.get("egg");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Egg)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    System.out.println("amount of Egg is complete");
                    System.out.println("Egg " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f2 = true;
                } else {
                    System.out.println("Egg " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f2 = false;

                }
            }
            if (string.equalsIgnoreCase("fabric")) {
                f3 = true;
                int amountNeeded = task.neededCommodity.get("fabric");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Fabric)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    System.out.println("amount of Fabric is complete");
                    System.out.println("Fabric " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f3 = true;
                } else {
                    System.out.println("Fabric " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f3 = false;

                }
            }

            if (string.equalsIgnoreCase("feather")) {
                f3 = true;
                int amountNeeded = task.neededCommodity.get("feather");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Feather)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    System.out.println("amount of Feather is complete");
                    System.out.println("Feather " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f3 = true;
                } else {
                    System.out.println("Feather " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f3 = false;

                }
            }
            if (string.equalsIgnoreCase("flour")) {
                f4 = true;
                int amountNeeded = task.neededCommodity.get("flour");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Flour)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    System.out.println("amount of Flour is complete");
                    System.out.println("Flour " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f4 = true;
                } else {
                    System.out.println("Flour " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f4 = false;

                }
            }
            if (string.equalsIgnoreCase("ice cream")) {
                f5 = true;
                int amountNeeded = task.neededCommodity.get("ice cream");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof IceCream)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    System.out.println("amount of ice cream is complete");
                    System.out.println("ice cream " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f5 = true;
                } else {
                    System.out.println("ice cream " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f5 = false;

                }
            }
            if (string.equalsIgnoreCase("milk")) {
                f6 = true;
                int amountNeeded = task.neededCommodity.get("milk");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Milk)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    System.out.println("amount of Milk is complete");
                    System.out.println("Milk " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f6 = true;
                } else {
                    System.out.println("Milk " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f6 = false;

                }
            }
            if (string.equalsIgnoreCase("pocket milk")) {
                f7 = true;
                int amountNeeded = task.neededCommodity.get("pocket milk");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof PocketMilk)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    System.out.println("amount of Pocket milk is complete");
                    System.out.println("Pocket milk " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f7 = true;
                } else {
                    System.out.println("Pocket milk " +ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f7 = false;

                }
            }


        }

        return (f1&&f2&&f3&&f4&&f5&&f6&&f7);






    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d= (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.drawImage(new ImageIcon("color.jpg").getImage()
                ,0,0,null);

    }







}
