import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    //global declare
    JButton login, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;

    //constructor
    public Login() {
        setTitle("BIG BANK");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("banklogo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(100,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,34));
        add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setBounds(120,150,200,40);   //x,y,width,height;
        cardNo.setFont(new Font("Railway",Font.BOLD,20));
        add(cardNo);

        cardTextField= new JTextField();
        cardTextField.setBounds(220,155,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120,220,200,40);
        pin.setFont(new Font("Railway",Font.BOLD,20));
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(220,225,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login =new JButton("Sign in");
        login.setBounds(220,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear =new JButton("Clear");
        clear.setBounds(350,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp =new JButton("Sign Up");
        signUp.setBounds(220,350,230,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);
        setSize(700,500);
        setVisible(true);
        setLocation(500,200);
    }

    public static void main (String args[]){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear){
            cardTextField.setText(""); //setText to set values
            pinTextField.setText("");
        }
        else if (e.getSource() == login){

        }
        else if(e.getSource() == signUp){
         setVisible(false);   // login frame close
         new signUpOne().setVisible(true);   //signup window opens
        }
    }

}