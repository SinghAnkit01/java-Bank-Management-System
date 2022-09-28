package com.bank.bank_management_system;

import java.awt.Color;
import java.awt.Font;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

// import javafx.scene.input.KeyEvent;

import java.awt.event.*;

public class signup extends JFrame implements ActionListener {

    Long Random;
    JTextField textfield, textfield1, textfield2, textfield4, textfield6, textfield7, textfield9;
    JButton next;
    JDateChooser jdc;
    JRadioButton male, female, married, unmarried, others;
    JComboBox textfield8;

    signup() {
        Random random = new Random();
        Random = Math.abs(random.nextLong() % 9000L) + 1000L;
        // math.abs method converts negative to positive
        JLabel formno = new JLabel("APPLICATION FORM NO." + " " + Random);
        formno.setFont(new Font("Railway", Font.BOLD, 35));
        // creating object of Font class and passing three arguments such
        // as("Font-Family",Font-Type,Font-Size);
        setLayout(null);
        // if we wont give setLayout as null it will except borderlayout means
        // everything is in center.
        formno.setBounds(140, 10, 600, 100);
        add(formno);
        // personal details
        JLabel personaldetail = new JLabel("Page 1: Personal Details");
        personaldetail.setFont(new Font("Railway", Font.BOLD, 23));
        personaldetail.setBounds(240, 90, 400, 30);
        add(personaldetail);
        // name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Railway", Font.BOLD, 23));
        name.setBounds(100, 140, 100, 30);
        add(name);
        textfield = new JTextField();
        textfield.setFont(new Font("Arial", Font.BOLD, 14));
        textfield.setBounds(270, 146, 400, 26);

        textfield.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String name1 = textfield.getText();

                char[] chars = name1.toCharArray();
                for (char c : chars) {
                    if ((!Character.isLetter(c)) && (!Character.isWhitespace(c))) {
                        JOptionPane.showMessageDialog(null, "Only Characters are allowed");
                        textfield.setText("");
                    }

                }

                // boolean result = name1.matches("[a-zA-Z]+");
                // // System.out.println(result);

                // public static boolean alphabet(){
                // String name1= textfield.getText();
                // for (int i=0 ; i<name1.length() ; i++){
                // if(!Character.isLetter(name1.charAt(i))){
                // // JOptionPane.showMessageDialog(null, "Only Characters are allowed");
                // return false;
                // }
                // }
                // }

                // public static boolean alphabet()

                // char c =ke.getKeyChar();
                // if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) ||
                // (c==KeyEvent.VK_DELETE) )){
                // ke.consume();
                // // }
                // for(int i=0; i<name1.length() ; i++){
                // char ch = name1.charAt(i);
                // if((!(ch >= 'A' && ch <= 'Z' )) && (!(ch >= 'a' && ch <= 'z' && ch <= 'a'))
                // ){
                // JOptionPane.showMessageDialog(null, "Only Characters are allowed");
                // textfield.setText("");
                // // return;
                // }
                // }

                if (name1.length() > 230) {
                    JOptionPane.showMessageDialog(null, "Maximum 30 digits are allowed");
                    textfield.setText("");
                }

            }
        });

        add(textfield);

        // fathers name
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Railway", Font.BOLD, 23));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        textfield1 = new JTextField();
        textfield1.setFont(new Font("Arial", Font.BOLD, 14));
        textfield1.setBounds(270, 196, 400, 26);

        textfield1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String name2 = textfield1.getText();
                char[] chars = name2.toCharArray();
                for (char c : chars) {
                    if ((!Character.isLetter(c)) && (!Character.isWhitespace(c))) {
                        JOptionPane.showMessageDialog(null, "Only Characters are allowed");
                        textfield1.setText("");
                    }

                }
                // if (!(name2.matches("[a-zA-Z]+"))) {
                // JOptionPane.showMessageDialog(null, "only charecter are allowed");
                // textfield1.setText("");
                // }
                // // int l = value.length();
                if (name2.length() > 15) {
                    JOptionPane.showMessageDialog(null, "Maximum 15 digits are allowed");
                    textfield1.setText("");
                }
                // System.out.println(l);

            }
        });

        add(textfield1);

        // dob
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Railway", Font.BOLD, 23));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        jdc = new JDateChooser();
        // add jar file in vs code to access properties of JDateChooser Class.
        jdc.setBounds(270, 246, 400, 26);
        jdc.setFont(new Font("Arial", Font.BOLD, 14));
        // jdc.setForeground(new Color(105,105,100));
        // jdc.setBackground(Color.BLACK);
        add(jdc);

        // gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Railway", Font.BOLD, 23));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(270, 296, 160, 30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Arial", Font.BOLD, 18));
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(430, 296, 100, 30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Arial", Font.BOLD, 18));
        add(female);
        // for only one selection either male or female
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        // male.setBounds(x, y, width, height);

        // email addresss
        JLabel email = new JLabel("email-Id:");
        email.setFont(new Font("Railway", Font.BOLD, 23));
        email.setBounds(100, 340, 200, 30);
        add(email);
        textfield4 = new JTextField();
        textfield4.setFont(new Font("Arial", Font.BOLD, 14));
        textfield4.setBounds(270, 346, 400, 26);
         textfield4.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String name3 = textfield4.getText();
                if (name3.length() > 35) {
                    JOptionPane.showMessageDialog(null, "Maximum 15 digits are allowed");
                    textfield4.setText("");
                }
            }
        });
          
        textfield4.addMouseListener(new MouseListener(){
            String name3 = textfield4.getText();
            @Override
            public void mouseClicked(MouseEvent e) {
              JOptionPane.showMessageDialog(null, "Enter valid emailaddress" + "\n" + "you will receive all your updates on this email-id");
              if (name3.length() > 40) {
                JOptionPane.showMessageDialog(null, "Maximum 30 digits are allowed");
                textfield4.setText("");
            }
            }
            

            @Override
            public void mousePressed(MouseEvent e) {
                
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // JOptionPane.showMessageDialog(null,"you will get;");   
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
                
            }
            
        });
        textfield4.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {

            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                int pos = textfield4.getCaretPosition();
                textfield4.setText(textfield4.getText().toLowerCase());
                textfield4.setCaretPosition(pos);

            }

           

        });
       
        // textfield4.addKeyListener(new KeyListener() {

        // // name3.toLowerCase().toString();

        // // if(name3.contains("@")){
        // // JOptionPane.showMessageDialog(null, "Valid");
        // // textfield4.setText("");
        // // }
        // // char[] chars = name3.toCharArray();
        // // for(char c1 : chars){
        // // if((!Character.isLetter(c1)) && (!Character.isWhitespace(c1)) &&
        // (!Character.isLowerCase(c1)) && (Character.isUpperCase(c1))){
        // // JOptionPane.showMessageDialog(null, "Only Characters are allowed");
        // // textfield4.setText("");
        // // }

        // // }

        // // if(!name3.equals(name3) && name3.equals("@")){
        // // JOptionPane.showMessageDialog(null,"please enter valid email address");
        // // }

        // // List<String> email = new ArrayList<String>();
        // // email.add(name3);
        // // email.contains("@gmail.com");
        // // email.contains("@gmail.org");
        // // email.contains("@gmail.co.on");
        // // JOptionPane.showMessageDialog(null,"valid email");
        // // if (!(name2.matches("[a-zA-Z]+"))) {
        // // JOptionPane.showMessageDialog(null, "only charecter are allowed");
        // // textfield1.setText("");
        // // }
        // // // int l = value.length();

        // // System.out.println(l);

        // }
        // });

       

        add(textfield4);

        // martial_status
        JLabel ms = new JLabel("Martial Status:");
        ms.setFont(new Font("Railway", Font.BOLD, 23));
        ms.setBounds(100, 390, 200, 30);
        add(ms);
        married = new JRadioButton("Married");
        married.setBounds(270, 396, 160, 30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Arial", Font.BOLD, 18));
        add(married);
        unmarried = new JRadioButton("Un-Married");
        unmarried.setBounds(430, 396, 200, 30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFont(new Font("Arial", Font.BOLD, 18));
        add(unmarried);
        others = new JRadioButton("Others");
        others.setBounds(630, 396, 400, 30);
        others.setBackground(Color.WHITE);
        others.setFont(new Font("Arial", Font.BOLD, 18));
        add(others);
        // for only one selection either male or female
        ButtonGroup gendergroup1 = new ButtonGroup();
        gendergroup1.add(married);
        gendergroup1.add(unmarried);
        gendergroup1.add(others);

        // address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Railway", Font.BOLD, 23));
        address.setBounds(100, 440, 200, 30);
        add(address);
        textfield6 = new JTextField();
        textfield6.setFont(new Font("Arial", Font.BOLD, 14));
        textfield6.setBounds(270, 446, 400, 26);
        add(textfield6);

        // state
        JLabel pc = new JLabel("State:");
        pc.setFont(new Font("Railway", Font.BOLD, 23));
        pc.setBounds(100, 490, 200, 30);
        add(pc);
        String occ[] = { "Select", "Jammu-Kashmir", "Delhi", "Maharashtra", "Rajasthsn", "Madhya-Pradesh", "Gujarat",
                "Uttar-Pradesh", "Bihar", "Jharkhand", "Odisha",
                "West-Bengal", "Andra-Pradesh", "Arunachal-Pradesh", "Goa", "Punjab", "Sikkim", "Manipur", "Assam",
                "Mizoram", "Kerala", "Karnataka", "Tamil-Nadu", "Others" };
        textfield8 = new JComboBox<>(occ);
        textfield8.setBounds(270, 496, 400, 26);
        textfield8.setBackground(Color.WHITE);
        add(textfield8);

        // city
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Railway", Font.BOLD, 23));
        city.setBounds(100, 540, 200, 30);
        add(city);
        textfield7 = new JTextField();
        textfield7.setFont(new Font("Arial", Font.BOLD, 14));
        textfield7.setBounds(270, 546, 400, 26);
        add(textfield7);

        // pincode
        JLabel state = new JLabel("Pincode:");
        state.setFont(new Font("Railway", Font.BOLD, 23));
        state.setBounds(100, 590, 200, 30);
        add(state);
        textfield9 = new JTextField();
        textfield9.setFont(new Font("Arial", Font.BOLD, 14));
        textfield9.setBounds(270, 596, 400, 26);


        textfield9.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
        String name5 = textfield9.getText();

        char[] chars = name5.toCharArray();
        for (char c : chars) {
            if ((!Character.isDigit(c))) {
                JOptionPane.showMessageDialog(null, "Only digits are allowed");
                textfield9.setText("");
            }

        }

        if(name5.length()>5){
            JOptionPane.showMessageDialog(null, "Pincode should be maximum of 6 digit");
            textfield9.setText("");
        }
      
        

            }
        });
        add(textfield9);

        

        // adding next button

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(570, 636, 100, 35);
        next.addActionListener(this);
        add(next);

        // Random class comes under util.Random package
        getContentPane().setBackground(Color.WHITE);
        // getContentPane() this will access whole frame.
        // color class comes under aet.Color package
        // create a frame
        setSize(850, 730);
        setLocation(350, 10);
        setVisible(true);
        // this methods belongs to JFrame class comes from javax(extends).swing.JFrame
        // package.
    }

    public static void main(String[] args) {
        new signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = " " + Random;
        // long to string
        String name = textfield.getText();
        // String name1 = textfield.setText("hello");
        // use to set value in textbox
        // getText() will take values from name Textfield.
        String fname = textfield1.getText();
        String dob = ((JTextField) jdc.getDateEditor().getUiComponent()).getText();
        // getting values from JDateChooser class.
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = textfield4.getText();

        String ms = null;
        if (married.isSelected()) {
            ms = "Married";
        } else if (unmarried.isSelected()) {
            ms = "Un-Married";
        } else if (others.isSelected()) {
            ms = "Others";
        }
        String addresss = textfield6.getText();
        String city = textfield7.getText();
        String state = (String) textfield8.getSelectedItem();
        String pincode = textfield9.getText();

        // hit all the values in database using try-catch block
        // adding validation if name is empty then it shows taht plzz enter name...
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
                // this method is use to pop-up dialog box in windows
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Fathername is Required");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date-of-Birth is Required");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is Required");
            } else if (ms.equals("")) {
                JOptionPane.showMessageDialog(null, "Marital-Status is Required");
            } else if (addresss.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required");
            } else if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            } else {
                // if textboxes are not empty then we have to call database
                conn c = new conn();
                String query = "Insert into signup(formno,name,father_name,dob,gender,email,marital_status,address,city,state,pincode)values('"
                        + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','"
                        + ms + "','" + addresss + "','" + city + "','" + state + "','" + pincode + "')";
                c.s.executeUpdate(query);
                System.out.println("Data Inserted Successfully in signup table");
                // connection.statement.executequery
                if (e.getSource() == next) {
                    System.out.println("next is available...");
                    setVisible(false);
                    // this will close the current form.
                    // current form will be invisible.
                    // start signup form.............
                    new signuptwo(formno, name, email).setVisible(true);

                    // new signupthree(name);
                    // if we want to open signup page we have to create object of that class
                }
            }
        } catch (Exception ea) {
            System.out.println("Database not connected....." + ea);
        }

    }
}
