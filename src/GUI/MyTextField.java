package GUI;

import javax.swing.*;

public class MyTextField extends JTextField {
       public String name;
       public MyTextField(String name)
       {
           this.name=name;
           this.setText(name);
           this.setHorizontalAlignment(SwingConstants.CENTER);



       }

}
