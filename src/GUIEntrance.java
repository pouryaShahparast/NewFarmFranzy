import javax.swing.*;
import java.awt.*;

public class GUIEntrance {
    public static JFrame jFrame=new JFrame("Farm Frenzy");
    ImageIcon imageIcon;
    Image backGround;
    Image instance;
    JLabel jLabel1,jLabel2;
    public GUIEntrance(){
        imageIcon=new ImageIcon("sharif1.png");
        backGround=new ImageIcon("galaxy.jpg").getImage();
        instance=backGround.getScaledInstance(1000,700,Image.SCALE_SMOOTH);

        jFrame.getContentPane().setBackground(Color.BLUE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(0,0,1000,700);
        jFrame.setIconImage(imageIcon.getImage());



        //label
        jLabel1=new JLabel();
        jLabel1.setBounds(0,0,1000,700);
        jLabel1.setIcon(new ImageIcon(instance));
        jFrame.add(jLabel1);

        jLabel2=new JLabel();
        jLabel2.setBounds(300,400,400,60);
        jLabel2.setBackground(Color.BLUE);
        jLabel2.setOpaque(true);
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setText("Welcome to Farm Frenzy");
        jLabel2.setFont(new Font("consalas",Font.BOLD,33));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        jFrame.setVisible(true);

        try {
           Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.remove(jLabel1);
        jFrame.revalidate();
        jFrame.repaint();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.add(jLabel2);
        jFrame.revalidate();
        jFrame.repaint();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jLabel2.setText("<html>..............by.............<br/> ....Pourya Shahparast<br/>.......Meysam Asady</html>");
        jLabel2.setFont(new Font("Mv boli",Font.BOLD,32));

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.revalidate();
        jFrame.repaint();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jFrame.remove(jLabel2);
        jFrame.revalidate();
        jFrame.repaint();


    }










}
