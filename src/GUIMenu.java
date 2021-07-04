import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMenu implements ActionListener {

    JPanel jPanel;
    JButton exit,levels,coins;
    public GUIMenu(){
        GUIEntrance.jFrame.setLayout(null);
        jPanel=new JPanel(new GridLayout(3,1,4,4));
        exit=new JButton("exit");
        levels=new JButton("levels");
        coins=new JButton("coins");
        exit.addActionListener(this);
        coins.addActionListener(this);
        levels.addActionListener(this);

        jPanel.add(exit);
        jPanel.add(levels);
        jPanel.add(coins);
        jPanel.setBounds(300,100,400,300);
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

            //todo

        }

        if(e.getSource()==coins)
        {

            //todo

        }





    }
}
