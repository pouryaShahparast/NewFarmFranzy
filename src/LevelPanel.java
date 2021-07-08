import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LevelPanel extends JPanel implements ActionListener, MouseListener {




    ArrayList<JButton>arr=new ArrayList<>();
    JButton back;
    public LevelPanel(){
       this.setLayout(new GridLayout(6,1,5,5));
       this.setBackground(Color.BLUE);
       this.setOpaque(true);
       this.setBounds(200,100,600,400);
        for (int i = 0; i < 5; i++) {


            JButton jButton=new JButton(Integer.toString(i+1));
            jButton.setFocusable(false);
            jButton.setBackground(Color.WHITE);
            jButton.addActionListener(this);
            jButton.addMouseListener(this);
            jButton.setFont(new Font("MV Boli",Font.BOLD,20));
            arr.add(jButton);
            this.add(jButton);

        }
        back=new JButton("menu");
        back.setFocusable(false);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        back.addMouseListener(this);
        back.setFont(new Font("MV Boli",Font.BOLD,20));
        this.add(back);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (JButton j :
                arr) {

            if(e.getSource()==j)
            {




            }


        }

        if(e.getSource()==back)
        {

            GUIEntrance.jFrame.remove(this);
            GUIEntrance.jFrame.revalidate();
            GUIEntrance.jFrame.repaint();
            new GUIMenu();


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
        for (JButton j :
                arr) {

            if(e.getSource()==j)
            {

                for (JButton b :
                        arr) {
                    if(b!=j)
                    {
                        b.setBackground(Color.WHITE);
                        b.setFont(new Font("MV Boli",Font.BOLD,20));
                        this.revalidate();
                        this.repaint();




                    }







                }


                j.setBackground(Color.cyan);
                j.setFont(new Font("MV Boli",Font.BOLD,25));
                j.setForeground(Color.red);
                this.revalidate();
                this.repaint();



            }


        }
        if(e.getSource()==back)
        {

            back.setBackground(Color.cyan);
            back.setFont(new Font("MV Boli",Font.BOLD,25));
            back.setForeground(Color.red);
            this.revalidate();
            this.repaint(); 
            
            
            
            
        }
        



    }

    @Override
    public void mouseExited(MouseEvent e) {
           for (JButton j :
                    arr) {
                j.setBackground(Color.WHITE);
                j.setFont(new Font("MV Boli",Font.BOLD,20));
                j.setForeground(Color.black);
                this.revalidate();
                this.repaint();



            }

        back.setBackground(Color.WHITE);
        back.setFont(new Font("MV Boli",Font.BOLD,20));
        back.setForeground(Color.black);
        this.revalidate();
        this.repaint();





    }
}
