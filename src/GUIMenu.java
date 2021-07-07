import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GUIMenu implements ActionListener, MouseMotionListener {

    JPanel jPanel;
    JPanel levelPanel;
    JButton exit,levels,coins;
    public GUIMenu(){
        GUIEntrance.jFrame.setLayout(null);
        jPanel=new JPanel(new GridLayout(3,1,5,5));
        jPanel.setBackground(Color.BLUE);
        jPanel.setOpaque(true);
        exit=new JButton("exit");
        levels=new JButton("levels");
        coins=new JButton("coins");
        exit.addActionListener(this);
        coins.addActionListener(this);
        levels.addActionListener(this);
        exit.setFocusable(false);
        coins.setFocusable(false);
        levels.setFocusable(false);
        exit.setFont(new Font("consolas",Font.BOLD,18));
        coins.setFont(new Font("consolas",Font.BOLD,18));
        levels.setFont(new Font("consolas",Font.BOLD,18));
        levels.addMouseMotionListener(this);
        coins.addMouseMotionListener(this);
        exit.addMouseMotionListener(this);


        jPanel.add(levels);
        jPanel.add(coins);
        jPanel.add(exit);


        jPanel.setBounds(250,150,500,300);
        GUIEntrance.jFrame.add(jPanel);

        GUIEntrance.jFrame.revalidate();
        GUIEntrance.jFrame.repaint();










    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit)
        {

            //todo
            System.exit(0);


        }
        if(e.getSource()==levels)
        {

            GUIEntrance.jFrame.remove(jPanel);
            GUIEntrance.jFrame.add(new LevelPanel());



        }

        if(e.getSource()==coins)
        {

            //todo

        }





    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getSource()==levels)
        {
            levels.setFont(new Font("consolas",Font.BOLD,22));
            coins.setFont(new Font("consolas",Font.BOLD,18));
            exit.setFont(new Font("consolas",Font.BOLD,18));

            exit.setBackground(Color.WHITE);
            coins.setBackground(Color.WHITE);
            levels.setBackground(Color.green);
            jPanel.revalidate();
            jPanel.repaint();

        }

        else if(e.getSource()==coins)
        {
            levels.setFont(new Font("consolas",Font.BOLD,18));
            coins.setFont(new Font("consolas",Font.BOLD,22));
            exit.setFont(new Font("consolas",Font.BOLD,18));

            levels.setBackground(Color.WHITE);
            exit.setBackground(Color.WHITE);
            coins.setBackground(Color.ORANGE);
            jPanel.revalidate();
            jPanel.repaint();







        }
        else  if(e.getSource()==exit)
        {
            levels.setFont(new Font("consolas",Font.BOLD,18));
            coins.setFont(new Font("consolas",Font.BOLD,18));
            exit.setFont(new Font("consolas",Font.BOLD,22));

            levels.setBackground(Color.WHITE);
            coins.setBackground(Color.WHITE);
            exit.setBackground(Color.PINK);
            jPanel.revalidate();
            jPanel.repaint();






        }


       else
        {

           exit.setFont(new Font("consolas",Font.BOLD,18));
           levels.setFont(new Font("consolas",Font.BOLD,18));
           coins.setFont(new Font("consolas",Font.BOLD,18));

            levels.setBackground(Color.WHITE);
            coins.setBackground(Color.WHITE);
            exit.setBackground(Color.WHITE);
            jPanel.revalidate();
            jPanel.repaint();
        }






    }
}
