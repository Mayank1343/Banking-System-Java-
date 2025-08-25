import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;                          // JDBC


public class signUpTwo extends JFrame implements ActionListener{


    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton sYes,sNo,eyes,eno;
    JComboBox religion,category,income,qualification,occupation;
    String formno;

    signUpTwo(String formno) {
        this.formno = formno;

        getContentPane().setBackground(Color.WHITE);

        setSize (850,800);
        setLocation(350,10);
        setVisible(true);



        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD,25));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Railway", Font.BOLD,20));
        name.setBounds(200,150,400,30);
        add(name);

        String valReligion[]= {"Hindu","Muslim","Sikh","Christan","Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(350,150,200,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Railway", Font.BOLD,20));
        fname.setBounds(200,190,400,30);
        add(fname);

        String valCategory[]= {"General","OBC","SC","ST","Others"};
         category = new JComboBox(valCategory);
        category.setBounds(350,190,200,30);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Railway", Font.BOLD,20));
        dob.setBounds(200,230,400,30);
        add(dob);

        String valIncome[]= {"Null","<1,50,000","<2,50,000","<5,00,000","<10,00,000"};
         income = new JComboBox(valIncome);
        income.setBounds(350,230,200,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Railway", Font.BOLD,20));
        gender.setBounds(200,270,400,30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Railway", Font.BOLD,20));
        email.setBounds(200,290,400,30);
        add(email);

        String valQualification[]= {"Non-Graduate","Graduate","Masters","PHD","Others"};
         qualification = new JComboBox(valQualification);
        qualification.setBounds(350,290,200,30);
        qualification.setBackground(Color.WHITE);
        add(qualification);


        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Railway", Font.BOLD,20));
        marital.setBounds(200,350,400,30);
        add(marital);

        String valOccupation[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
         occupation = new JComboBox(valOccupation);
        occupation.setBounds(350,350,200,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);



        JLabel address = new JLabel("PAN no:");
        address.setFont(new Font("Railway", Font.BOLD,20));
        address.setBounds(200,390,400,30);
        add(address);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Railway", Font.BOLD, 14));
        panTextField.setBounds(350,390,200,30);
        add(panTextField);

        JLabel city = new JLabel("Aadhar no:");
        city.setFont(new Font("Railway", Font.BOLD,20));
        city.setBounds(200,430,400,30);
        add(city);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Railway", Font.BOLD, 14));
        aadharTextField.setBounds(350,430,200,30);
        add(aadharTextField);



        JLabel state = new JLabel("Senior citizen:");
        state.setFont(new Font("Railway", Font.BOLD,20));
        state.setBounds(200,470,400,30);
        add(state);

        sYes = new JRadioButton("Yes");
        sYes.setBounds(350,470,50,30);
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("No");
        sNo.setBounds(420,470,50,30);
        sNo.setBackground(Color.WHITE);
        add(sNo);


        // to allow only single button selection
        ButtonGroup seniorCheck = new ButtonGroup();
        seniorCheck.add(sYes);
        seniorCheck.add(sNo);


        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Railway", Font.BOLD,20));
        pincode.setBounds(200,510,400,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(390,510,50,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(470,510,90,30);
        eno.setBackground(Color.WHITE);
        add(eno);



        // to allow only single button selection
        ButtonGroup existCheck = new ButtonGroup();
        existCheck.add(eyes);
        existCheck.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(600,600,80,30);
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent ae){
      //  String formno = null;
        String sreligion =(String) religion.getSelectedItem(); //values from drop down // (String) - to typecast to string
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String squalification = (String) qualification.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String pan = panTextField.getText(); //gettext to get data
        String aadhar = aadharTextField.getText();

        String senior = null;
        if(sYes.isSelected()){
            senior = "Yes";
        }
        else if(sNo.isSelected()){
            senior = "No";
        }

        String existingAcc = null;
        if(eyes.isSelected()){
            existingAcc = "Yes";
        }
        else if(eno.isSelected()){
            existingAcc = "No";
        }


        try {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+pan+"','"+aadhar+"','"+existingAcc+"','"+senior+"')";
                c.s.executeUpdate(query);

                //signUpThree Object
                setVisible(false);
                new signUpThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        new signUpTwo("");
    }

}