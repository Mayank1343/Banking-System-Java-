import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class signUpOne extends JFrame{

    signUpOne() {

        getContentPane().setBackground(Color.WHITE);

         setSize (850,800);
         setLocation(350,10);
         setVisible(true);

         Random ran = new Random();
         long random= (Math.abs(ran.nextLong() %9000L + 1000L));

          setLayout(null);
         JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
         formno.setFont(new Font("Railway", Font.BOLD,35));
         formno.setBounds(140,20,600,40);
        add(formno);

          JLabel personalDetails = new JLabel("Page 1: Personal Details");
         personalDetails.setFont(new Font("Railway", Font.BOLD,25));
         personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
         name.setFont(new Font("Railway", Font.BOLD,20));
         name.setBounds(200,150,400,30);
        add(name);
    }

    public static void main(String[] args) {
        new signUpOne();
    }

}