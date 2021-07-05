import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIAuthentication implements ActionListener, MouseMotionListener{


    static int en=0;
    JButton jButton1,jButton2,jButton3;
    JPanel panel=new JPanel();
    Entrance entrance;
    public GUIAuthentication() {
        //
        entrance=new Entrance();
        entrance.initializeTasks();
        //




        GUIEntrance.jFrame.setLayout(null);
        jButton1=new JButton("Sign up");
        jButton2=new JButton("Log in");
        jButton3=new JButton("Exit");

        jButton1.setFocusable(false);
        jButton2.setFocusable(false);
        jButton3.setFocusable(false);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton1.setFont(new Font("consolas",Font.BOLD,18));
        jButton2.setFont(new Font("consolas",Font.BOLD,18));
        jButton3.setFont(new Font("consolas",Font.BOLD,18));
        jButton1.addMouseMotionListener(this);
        jButton2.addMouseMotionListener(this);
        jButton3.addMouseMotionListener(this);
        jButton1.setBackground(Color.WHITE);
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);





        panel.setBackground(Color.BLUE);
        panel.setOpaque(true);
        panel.setBounds(250,150,500,300);
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(jButton3);
        panel.setLayout(new GridLayout(3,1,5,5));




        GUIEntrance.jFrame.addMouseMotionListener(this);
        GUIEntrance.jFrame.add(panel);
        GUIEntrance.jFrame.revalidate();
        GUIEntrance.jFrame.repaint();



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==jButton3)
        {
            System.exit(0);

        }
        else if(e.getSource()==jButton1)
        {
            GUIEntrance.jFrame.remove(panel);
            new UserPassController(1);


        }
        else if(e.getSource()==jButton2)
        {

            GUIEntrance.jFrame.remove(panel);
            new UserPassController(2);



        }







    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    if(e.getSource()==jButton1)
    {
        jButton1.setFont(new Font("consolas",Font.BOLD,22));
        jButton2.setFont(new Font("consolas",Font.BOLD,18));
        jButton3.setFont(new Font("consolas",Font.BOLD,18));

        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        jButton1.setBackground(Color.green);
        panel.revalidate();
        panel.repaint();

    }

    else if(e.getSource()==jButton2)
    {
        jButton1.setFont(new Font("consolas",Font.BOLD,18));
        jButton2.setFont(new Font("consolas",Font.BOLD,22));
        jButton3.setFont(new Font("consolas",Font.BOLD,18));

        jButton1.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        jButton2.setBackground(Color.ORANGE);
        panel.revalidate();
        panel.repaint();







    }
   else  if(e.getSource()==jButton3)
    {
        jButton1.setFont(new Font("consolas",Font.BOLD,18));
        jButton2.setFont(new Font("consolas",Font.BOLD,18));
        jButton3.setFont(new Font("consolas",Font.BOLD,22));

        jButton1.setBackground(Color.WHITE);
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.PINK);
        panel.revalidate();
        panel.repaint();






    }

    else
    {
        jButton1.setFont(new Font("consolas",Font.BOLD,18));
        jButton2.setFont(new Font("consolas",Font.BOLD,18));
        jButton3.setFont(new Font("consolas",Font.BOLD,18));

        jButton1.setBackground(Color.WHITE);
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        panel.revalidate();
        panel.repaint();

    }



    if((e.getX()<=240)&&(e.getX()>=760)&&(e.getY()<=140)&&(e.getY()>=460))
    {
        System.out.println(">=200");
        jButton1.setFont(new Font("consolas",Font.BOLD,18));
        jButton2.setFont(new Font("consolas",Font.BOLD,18));
        jButton3.setFont(new Font("consolas",Font.BOLD,18));

        jButton1.setBackground(Color.WHITE);
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        panel.revalidate();
        panel.repaint();
    }










    }


}
