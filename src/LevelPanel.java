import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class LevelPanel extends JPanel implements ActionListener, MouseMotionListener {




    ArrayList<JButton>arr=new ArrayList<>();
    public LevelPanel(){
       this.setLayout(new GridLayout(5,1,5,5));
       this.setBackground(Color.BLUE);
       this.setOpaque(true);
       this.setBounds(200,100,600,400);
        for (int i = 0; i < 5; i++) {


            JButton jButton=new JButton(Integer.toString(i+1));
            jButton.setFocusable(false);
            jButton.setBackground(Color.WHITE);
            jButton.addActionListener(this);
            jButton.addMouseMotionListener(this);
            jButton.setFont(new Font("MV Boli",Font.BOLD,20));
            arr.add(jButton);

        }















    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (JButton j :
                arr) {

            if(e.getSource()==j)
            {




            }


        }







    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

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
              j.setFont(new Font("MV Boli",Font.BOLD,23));
                this.revalidate();
                this.repaint();



            }


        }

        if((e.getX()<200)||(e.getX()>800)||(e.getY()<100)||(e.getY()>500))
        {
            for (JButton j :
                    arr) {
                j.setBackground(Color.WHITE);
                j.setFont(new Font("MV Boli",Font.BOLD,20));
                this.revalidate();
                this.repaint();



            }






        }








    }
}
