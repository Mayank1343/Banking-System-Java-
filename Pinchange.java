import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {

    JButton change,back;
    JPasswordField pin,rePinText;
    String pinnumber;
    Pinchange(String pinnumber){
      this.pinnumber=pinnumber;

        setLayout(null);

      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        setFont(new Font("System", Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pinText = new JLabel("Enter new PIN:");
        pinText.setForeground(Color.WHITE);
        setFont(new Font("System", Font.BOLD,16));
        pinText.setBounds(165,320,180,25);
        image.add(pinText);

         pin= new JPasswordField();
        pin.setFont(new Font("System",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel rePin = new JLabel("Re-Enter PIN:");
        rePin.setForeground(Color.WHITE);
        setFont(new Font("System", Font.BOLD,16));
        rePin.setBounds(165,360,500,35);
        image.add(rePin);

         rePinText= new JPasswordField();
        rePinText.setFont(new Font("System",Font.BOLD,25));
        rePinText.setBounds(330,360,180,25);
        image.add(rePinText);

          change = new JButton("Change");
        change.setBounds(350,485,150,30);
        change.addActionListener(this);
        add(change);

         back = new JButton("Back");
        back.setBounds(350,520,150,30);
        back.addActionListener(this);
        add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = rePinText.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }


                Conn conn = new Conn();
                String query1 ="update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query2 ="update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query3 ="update signUpThree set pinNumber = '"+rpin+"' where pinNumber ='"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed succesfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Pinchange("").setVisible(true);
    }
}
