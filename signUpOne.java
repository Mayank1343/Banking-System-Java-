import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;   // JCalendar
import java.sql.*;                          // JDBC


public class signUpOne extends JFrame implements ActionListener{

    long random;
    JTextField nametTextField,fnameTextField,emailTextField,
            addresstTextField,citytTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried;
    JDateChooser dateChooser;

    signUpOne() {


        getContentPane().setBackground(Color.WHITE);

        setSize (850,800);
        setLocation(350,10);
        setVisible(true);

        Random ran = new Random();
        random = (Math.abs(ran.nextLong() %9000L + 1000L));

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

        nametTextField = new JTextField();
        nametTextField.setFont(new Font("Railway", Font.BOLD, 14));
        nametTextField.setBounds(350,150,200,30);
        add(nametTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Railway", Font.BOLD,20));
        fname.setBounds(200,190,400,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        fnameTextField.setBounds(350,190,200,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Railway", Font.BOLD,20));
        dob.setBounds(200,230,400,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(350,230,200,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);


        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Railway", Font.BOLD,20));
        gender.setBounds(200,270,400,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(350,270,100,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,270,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        // to allow only single button selection
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Railway", Font.BOLD,20));
        email.setBounds(200,310,400,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway", Font.BOLD, 14));
        emailTextField.setBounds(350,310,200,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Railway", Font.BOLD,20));
        marital.setBounds(200,350,400,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(350,350,70,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(430,350,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(530,350,70,30);
        others.setBackground(Color.WHITE);
        add(others);

        // to allow only single button selection
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Railway", Font.BOLD,20));
        address.setBounds(200,390,400,30);
        add(address);

        addresstTextField = new JTextField();
        addresstTextField.setFont(new Font("Railway", Font.BOLD, 14));
        addresstTextField.setBounds(350,390,200,30);
        add(addresstTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Railway", Font.BOLD,20));
        city.setBounds(200,430,400,30);
        add(city);

        citytTextField = new JTextField();
        citytTextField.setFont(new Font("Railway", Font.BOLD, 14));
        citytTextField.setBounds(350,430,200,30);
        add(citytTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Railway", Font.BOLD,20));
        state.setBounds(200,470,400,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Railway", Font.BOLD, 14));
        stateTextField.setBounds(350,470,200,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Railway", Font.BOLD,20));
        pincode.setBounds(200,510,400,30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Railway", Font.BOLD, 14));
        pincodeTextField.setBounds(350,510,200,30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(600,600,80,30);
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; // double quotes concats with any number or long, it converts into a string.
        String name = nametTextField.getText(); //gettext to get data
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(others.isSelected()){
            marital = "Others";
        }

        String address = addresstTextField.getText();
        String city = citytTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try {
            // validation (name not be empty)
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        new signUpOne();
    }

}