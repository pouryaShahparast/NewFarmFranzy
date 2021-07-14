package GUI;
import controller.Entrance;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIMenu implements ActionListener, MouseListener {

    JPanel jPanel;
    CoinPanel coinPanel;
    JButton exit,levels,coins,back,ok;
    public GUIMenu(){
        GUIEntrance.jFrame.setLayout(null);
        //panels
        jPanel=new JPanel(new GridLayout(4,1,5,5));
        jPanel.setBackground(Color.BLUE);
        jPanel.setOpaque(true);

        coinPanel=new CoinPanel();
        JLabel jLabel=new JLabel();
        jLabel.setIcon(new ImageIcon("coin.jpg"));
        jLabel.setBounds(175,0,400,400);
        jLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        JLabel textLabel=new JLabel();
        textLabel.setText(UserPassController.user.name+" "+" you are at level "+Integer.toString(Entrance.levelOfUser)+" and you have "+Integer.toString(Entrance.userInitialCoins)+" coins");
        textLabel.setBounds(55,350,550,50);
        textLabel.setFont(new Font("Mv boli",Font.BOLD,19));
        textLabel.setBackground(Color.orange);
        textLabel.setOpaque(true);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ok=new JButton("OK");
        ok.setFocusable(false);
        ok.setBounds(300,440,100,50);
        ok.addActionListener(this);
        coinPanel.add(ok);
        coinPanel.add(textLabel);







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

            Entrance.saveUserInfo(UserPassController.user.name);
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

        GUIEntrance.jFrame.remove(jPanel);
        GUIEntrance.jFrame.add(coinPanel);
        GUIEntrance.jFrame.revalidate();
        GUIEntrance.jFrame.repaint();

        }

        if(e.getSource()==back)
        {
            Entrance.saveUserInfo(UserPassController.user.name);
            GUIEntrance.jFrame.remove(jPanel);
            GUIEntrance.jFrame.revalidate();
            GUIEntrance.jFrame.repaint();
            new GUIAuthentication();





        }

        if(e.getSource()==ok)
        {

            GUIEntrance.jFrame.remove(coinPanel);
            GUIEntrance.jFrame.add(jPanel);
            GUIEntrance.jFrame.revalidate();
            GUIEntrance.jFrame.repaint();






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
