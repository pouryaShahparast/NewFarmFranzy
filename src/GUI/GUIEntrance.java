package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUIEntrance implements ActionListener {
    public static JFrame jFrame=new JFrame("Farm Frenzy");
    ImageIcon imageIcon;
    Image backGround;
    Image icon;
    Timer timer;
    Image instance1,instance2;
    JLabel jLabel1,jLabel2,jLabel3;
    Random random=new Random();
    int x=0;
    public GUIEntrance(){
        imageIcon=new ImageIcon("sharif1.png");
        backGround=new ImageIcon("galaxy.jpg").getImage();
        icon =new ImageIcon("sharif2.png").getImage();
        instance1=backGround.getScaledInstance(1000,700,Image.SCALE_SMOOTH);
        instance2=icon.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        jFrame.getContentPane().setBackground(Color.BLUE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(0,0,1000,700);
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setLayout(null);


        //timer
            timer=new Timer(100,this);

        //label
        jLabel1=new JLabel();
        jLabel1.setBounds(0,0,1000,700);
        jLabel1.setIcon(new ImageIcon(instance1));
        jFrame.add(jLabel1);

        jLabel2=new JLabel();
        jLabel2.setBounds(250,450,500,200);
        jLabel2.setBackground(Color.BLUE);
        jLabel2.setOpaque(true);
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setText("Welcome to Farm Frenzy");
        jLabel2.setFont(new Font("consalas",Font.BOLD,36));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel3=new JLabel();
        jLabel3.setBounds(-200,100,200,200);
        jLabel3.setIcon(new ImageIcon(instance2));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        jFrame.setVisible(true);

        try {
           Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.remove(jLabel1);
        jFrame.revalidate();
        jFrame.repaint();
        timer.start();




        jFrame.add(jLabel2);
        GUIEntrance.jFrame.add(jLabel3);
        jFrame.revalidate();
        jFrame.repaint();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GUIEntrance.jFrame.add(jLabel3);
        jLabel2.setText("........by........");
        jLabel2.setFont(new Font("Mv boli",Font.BOLD,35 ));

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.revalidate();
        jFrame.repaint();
        jLabel2.setText("Pourya Shahparast");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.revalidate();
        jFrame.repaint();
        jLabel2.setText("Meysam Asady");
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.revalidate();
        jFrame.repaint();


        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.remove(jLabel2);
        jFrame.remove(jLabel3);
        jFrame.revalidate();
        jFrame.repaint();

       timer.stop();
       new GUIAuthentication();


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        x+=20;
        jLabel3.setBounds( -200+x,100,200,200);
        jLabel2.setForeground(new Color(random.nextInt(155)+100,random.nextInt(155)+100,random.nextInt(255)));
        GUIEntrance.jFrame.getContentPane().setBackground(new Color(x/15,x/15,255-(x/15)));
        GUIEntrance.jFrame.revalidate();
        GUIEntrance.jFrame.repaint();

    }
}
