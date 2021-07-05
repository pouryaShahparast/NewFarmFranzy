import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserPassController implements ActionListener {

    JPanel jPanel;
    JTextField jTextField1,jTextField2;
    JButton jButton;
    int i;

    public UserPassController() {}

    public UserPassController(int i) {

        this.i=i;



        jPanel=new JPanel();
        jPanel.setLayout(null);
        jPanel.setBounds(250,50,500,500);
        //
        JTextField usernameField=new JTextField("username");
        usernameField.setBounds(40,150,100,50);
        usernameField.setEditable(false);
        usernameField.setBackground(Color.green);
        usernameField.setFont(new Font("Consalas",Font.PLAIN,19));

        JTextField passwordField=new JTextField("password");
        passwordField.setBounds(40,220,100,50);
        passwordField.setEditable(false);
        passwordField.setBackground(Color.green);
        passwordField.setFont(new Font("Consalas",Font.PLAIN,19));





        jPanel.add(usernameField);
        jPanel.add(passwordField);

        jTextField1=new JTextField("");
        jTextField2=new JTextField("");
        jTextField1.setBounds(190,150,150,50);
        jTextField2.setBounds(190,220,150,50);
        jPanel.add(jTextField1);
        jPanel.add(jTextField2);
        jTextField1.setForeground(new Color(63,45,223));
        jTextField2.setForeground(new Color(63,45,223));
        jTextField1.setBackground(new Color(239,253,163));
        jTextField2.setBackground(new Color(239,253,163));
        jTextField1.setFont(new Font("Italic",2,19));
        jTextField2.setFont(new Font("Italic",2,19));

        jButton=new JButton("submit");
        jButton.setBounds(210,290,100,40);
        jButton.setBackground(Color.orange);
        jPanel.add(jButton);
        jButton.addActionListener(this);
        jButton.setFocusable(false);

        jButton.setFont(new Font("Consolas",Font.PLAIN,18));

        jPanel.setVisible(true);


        GUIEntrance.jFrame.add(jPanel);
        GUIEntrance.jFrame.setVisible(true);
        GUIEntrance.jFrame.repaint();







    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username="username";
        String password="password";

        if(e.getSource()==jButton)
        {

            username=jTextField1.getText();
            password=jTextField2.getText();
            System.out.println(username+"\n"+password);



            if(username.equalsIgnoreCase("")||(password.equalsIgnoreCase("")))
            {
                JOptionPane.showConfirmDialog(null,"enter your user name and password please","warning",JOptionPane.PLAIN_MESSAGE);



            }




           else if(i==1)
            {

                if(Entrance.checkIfUserExists(username))
                {


                    JOptionPane.showConfirmDialog(null,"Already exists try another","warning",JOptionPane.PLAIN_MESSAGE);




                }
                else {
                    JOptionPane.showConfirmDialog(null, "your sign up was successful", "info", JOptionPane.PLAIN_MESSAGE);
                    Entrance.signUp(username, password);
                    GUIEntrance.jFrame.remove(jPanel);


                }

            }

            if(i==2)
            {


                if(!Entrance.checkIfUserExists(username))
                {
                    JOptionPane.showConfirmDialog(null," sign up first ","warning",JOptionPane.WARNING_MESSAGE);

                    i=1;


                }
                else{

                    if(Entrance.checkIfPasswordIsCorrect(username,password))
                    {




                        GUIEntrance.jFrame.remove(jPanel);
                        GUIEntrance.jFrame.repaint();



                    }
                    else
                    {
                        JOptionPane.showConfirmDialog(null," wrong password ","warning",JOptionPane.ERROR_MESSAGE);

                    }

                }




            }






        }



    }
}
