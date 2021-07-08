import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIMenu implements ActionListener, MouseListener {

    JPanel jPanel;
    JButton exit,levels,coins,back;
    public GUIMenu(){
        GUIEntrance.jFrame.setLayout(null);
        jPanel=new JPanel(new GridLayout(4,1,5,5));
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
        levels.addMouseListener(this);
        coins.addMouseListener(this);
        exit.addMouseListener(this);

        back=new JButton("back");
        back.setFocusable(false);
        back.setFont(new Font("consolas",Font.BOLD,18));
        back.setBackground(Color.cyan);
        jPanel.add(levels);
        jPanel.add(coins);
        jPanel.add(exit);
        jPanel.add(back);
        back.addMouseListener(this);
        back.addActionListener(this);
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
            GUIEntrance.jFrame.revalidate();
            GUIEntrance.jFrame.repaint();
            GUIEntrance.jFrame.add(new LevelPanel());
            GUIEntrance.jFrame.revalidate();
            GUIEntrance.jFrame.repaint();


        }

        if(e.getSource()==coins)
        {

            //todo

        }

        if(e.getSource()==back)
        {

            GUIEntrance.jFrame.remove(jPanel);
            GUIEntrance.jFrame.revalidate();
            GUIEntrance.jFrame.repaint();
            new GUIAuthentication();





        }



    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource()==levels)
        {
            levels.setFont(new Font("consolas",Font.BOLD,22));
            coins.setFont(new Font("consolas",Font.BOLD,18));
            exit.setFont(new Font("consolas",Font.BOLD,18));
            back.setFont(new Font("consolas",Font.BOLD,18));
            exit.setBackground(Color.WHITE);
            coins.setBackground(Color.WHITE);
            levels.setBackground(Color.green);
            back.setBackground(Color.cyan);
            jPanel.revalidate();
            jPanel.repaint();

        }

        else if(e.getSource()==coins)
        {
            levels.setFont(new Font("consolas",Font.BOLD,18));
            coins.setFont(new Font("consolas",Font.BOLD,22));
            exit.setFont(new Font("consolas",Font.BOLD,18));
            back.setFont(new Font("consolas",Font.BOLD,18));
            levels.setBackground(Color.WHITE);
            exit.setBackground(Color.WHITE);
            coins.setBackground(Color.ORANGE);
            back.setBackground(Color.cyan);
            jPanel.revalidate();
            jPanel.repaint();







        }
        else  if(e.getSource()==exit)
        {
            levels.setFont(new Font("consolas",Font.BOLD,18));
            coins.setFont(new Font("consolas",Font.BOLD,18));
            exit.setFont(new Font("consolas",Font.BOLD,22));
            back.setFont(new Font("consolas",Font.BOLD,18));
            levels.setBackground(Color.WHITE);
            coins.setBackground(Color.WHITE);
            exit.setBackground(Color.PINK);
            back.setBackground(Color.cyan);
            jPanel.revalidate();
            jPanel.repaint();






        }
        else if(e.getSource()==back)
        {

            levels.setFont(new Font("consolas",Font.BOLD,18));
            coins.setFont(new Font("consolas",Font.BOLD,18));
            exit.setFont(new Font("consolas",Font.BOLD,18));
            back.setFont(new Font("consolas",Font.BOLD,22));
            levels.setBackground(Color.WHITE);
            coins.setBackground(Color.WHITE);
            exit.setBackground(Color.WHITE);
            back.setBackground(Color.RED);
            jPanel.revalidate();
            jPanel.repaint();







        }




    }

    @Override
    public void mouseExited(MouseEvent e) {



            exit.setFont(new Font("consolas",Font.BOLD,18));
            levels.setFont(new Font("consolas",Font.BOLD,18));
            coins.setFont(new Font("consolas",Font.BOLD,18));
            back.setFont(new Font("consolas",Font.BOLD,18));
            levels.setBackground(Color.WHITE);
            coins.setBackground(Color.WHITE);
            exit.setBackground(Color.WHITE);
            back.setBackground(Color.CYAN);
            jPanel.revalidate();
            jPanel.repaint();

    }
}
