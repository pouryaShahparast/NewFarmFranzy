import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAuthentication implements ActionListener {

    JButton jButton1,jButton2,jButton3;
    JLabel jLabel=new JLabel();
    JFrame jFrame;
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

        jLabel.setBounds(300,130,400,300);
        jLabel.add(jButton1);
        jLabel.add(jButton2);
        jLabel.add(jButton3);
        jLabel.setLayout(new GridLayout(3,1,5,5));

        GUIEntrance.jFrame.add(jLabel);
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
            GUIEntrance.jFrame.remove(jLabel);
            new UserPassController(1);


        }
        else if(e.getSource()==jButton2)
        {

            GUIEntrance.jFrame.remove(jLabel);
            new UserPassController(2);



        }







    }










}
