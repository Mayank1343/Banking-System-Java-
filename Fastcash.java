import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date; // Date class is in both sql and util package,
// so we have to explicitly mention from which class we want the date package.

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit, withdraw, fastcash, mini, pinchange, balanceInquery, exit;
    String pinnumber;

    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withdrawl amount:");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Rs 200");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Rs 500");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        mini = new JButton("Rs 1000");
        mini.setBounds(355,450,150,30);
        mini.addActionListener(this);
        image.add(mini);

        pinchange = new JButton("Rs 5,000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceInquery = new JButton("Rs 10,000");
        balanceInquery.setBounds(355,485,150,30);
        balanceInquery.addActionListener(this);
        image.add(balanceInquery);

        exit = new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //Rs 100 - substrings(3) skips first 3 characters
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance =0;
                while(rs.next()){ //rs.next used to loop every row from the database
                  if(rs.getString("type").equals("Deposit")){
                      balance +=Integer.parseInt(rs.getString("amount"));
                  } else {
                      balance -=Integer.parseInt(rs.getString("amount"));
                  }
                }
                if(ae.getSource()!=exit && balance < Integer.parseInt("amount")){  //checking if balance amount exist
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                     return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " +amount+ "Debited Successfully");
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){
        new Fastcash("");
    }
}
