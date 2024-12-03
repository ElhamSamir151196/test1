
/** Samar Sabry Shaker 20150129**/
/** Elham Samir Rashad 20150062 **/




package a1_security;

import java.awt.Color;
import javax.swing.JFrame;

public class A1_Security {

    
    public static void main(String[] args) {
       All_Gui form = new All_Gui();
        form.setTitle("Non uniform Quantizer");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setSize(900, 700);
        form.setVisible(true);
        form.getContentPane().setBackground(Color.BLACK);
    }
    
}
