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
        jTextField.setFont(new Font("consalas",Font.BOLD,19));
        jTextField.setEditable(false);
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

                    System.out.println("Bread " + ConsoleColors.BLUE + amountExisting + "\\" + amountNeeded + ConsoleColors.RESET);
                    f1 = true;
                } else {
                    myTextField.setText("Bread "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                    f1 = false;

                }

            }


            if (string.equalsIgnoreCase("cloth")) {


                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                        arr) {
                    if(myTextField1.name.equalsIgnoreCase("cloth"))
                    {
                        myTextField=myTextField1;

                    }


                }
                f2 = true;
                int amountNeeded = task.neededCommodity.get("cloth");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Cloth)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                  myTextField.setText("amount of Cloth is complete");
                    f2 = true;
                } else {
                    myTextField.setText("cloth "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                     f2 = false;

                }

            }
            if (string.equalsIgnoreCase("egg")) {

                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                        arr) {
                    if(myTextField1.name.equalsIgnoreCase("egg"))
                    {
                        myTextField=myTextField1;

                    }


                }

                f2 = true;
                int amountNeeded = task.neededCommodity.get("egg");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Egg)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    myTextField.setText("amount of Egg is complete");
                    f2 = true;
                } else {
                    myTextField.setText("Egg "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                      f2 = false;

                }
            }
            if (string.equalsIgnoreCase("fabric")) {
                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                        arr) {
                    if(myTextField1.name.equalsIgnoreCase("fabric"))
                    {
                        myTextField=myTextField1;

                    }


                }
                f3 = true;
                int amountNeeded = task.neededCommodity.get("fabric");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Fabric)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    myTextField.setText("amount of Fabric is complete");
                        f3 = true;
                } else {
                    myTextField.setText("fabric "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                       f3 = false;

                }
            }

            if (string.equalsIgnoreCase("feather")) {
                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                        arr) {
                    if(myTextField1.name.equalsIgnoreCase("feather"))
                    {
                        myTextField=myTextField1;

                    }


                }

                f3 = true;
                int amountNeeded = task.neededCommodity.get("feather");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Feather)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {

                    myTextField.setText("amount of feather is complete"); f3 = true;
                } else {
                    myTextField.setText("feather  "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                    f3 = false;

                }
            }
            if (string.equalsIgnoreCase("flour")) {
                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                        arr) {
                    if(myTextField1.name.equalsIgnoreCase("flour"))
                    {
                        myTextField=myTextField1;

                    }


                }
                f4 = true;
                int amountNeeded = task.neededCommodity.get("flour");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Flour)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    myTextField.setText("amount of flour is complete");
                    f4 = true;
                } else {
                    myTextField.setText("flour "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                    f4 = false;

                }
            }
            if (string.equalsIgnoreCase("ice cream")) {
                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                        arr) {
                    if(myTextField1.name.equalsIgnoreCase("ice cream"))
                    {
                        myTextField=myTextField1;

                    }


                }


                f5 = true;
                int amountNeeded = task.neededCommodity.get("ice cream");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof IceCream)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    myTextField.setText("amount of ice cream is complete");
                    f5 = true;
                } else {
                    myTextField.setText("ice cream "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                    f5 = false;

                }
            }
            if (string.equalsIgnoreCase("milk")) {
                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                        arr) {
                    if(myTextField1.name.equalsIgnoreCase("milk"))
                    {
                        myTextField=myTextField1;

                    }


                }
                f6 = true;
                int amountNeeded = task.neededCommodity.get("milk");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof Milk)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    myTextField.setText("amount of milk is complete");
                    f6 = true;
                } else {
                    myTextField.setText("milk "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                    f6 = false;

                }
            }
            if (string.equalsIgnoreCase("pocket milk")) {
                MyTextField myTextField=new MyTextField("");

                for (MyTextField myTextField1 :
                        arr) {
                    if(myTextField1.name.equalsIgnoreCase("pocket milk"))
                    {
                        myTextField=myTextField1;

                    }


                }

                f7 = true;
                int amountNeeded = task.neededCommodity.get("pocket milk");
                int amountExisting = 0;
                for (Commodity commodity :
                        storeroom.commodityHashSet) {
                    if (commodity instanceof PocketMilk)
                        amountExisting++;
                }
                if (amountExisting >= amountNeeded) {
                    myTextField.setText("amount of milk is complete");
                    f7 = true;
                } else {
                    myTextField.setText("milk "+Integer.toString(amountExisting )+ "\\" +Integer.toString(amountNeeded));

                    f7 = false;

                }
            }


        }

        for (MyTextField m :
                arr) {
            m.revalidate();
            m.repaint();
        }
        jPanel.revalidate();
        jPanel.repaint();
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
