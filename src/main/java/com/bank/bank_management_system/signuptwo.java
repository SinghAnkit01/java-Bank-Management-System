package com.bank.bank_management_system;
import java.awt.Color;
import java.awt.Font;
// contains part of css

// import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
// contains part of html

// import javax.swing.JList;
// import javax.swing.JOptionPane;
// import javax.swing.JRadioButton;
// import javax.swing.JTextField;
// import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.ResultSet;

// contains parts of javascript
import javax.swing.JTextField;



public class signuptwo extends JFrame implements ActionListener{

    // Long Random;
    JTextField textfield,textfield1;
    // JButton next;
    // JDateChooser jdc;
    JRadioButton yes,no,eyes,eno;
    JComboBox cat,rel,inc,edu,occupa;
    JButton next;
    String formno,name,email;
    signuptwo(String formno,String name,String email) {
        this.formno=formno;
        this.name=name;
        this.email=email;
        // getting values from signup page and setting in into constructor.

        // Additional details
        setLayout(null);
        JLabel additionaldetail = new JLabel("Page 2: Additional Details");
        additionaldetail.setFont(new Font("Railway",Font.BOLD,23));
        additionaldetail.setBounds(250, 60,400, 30);
        add(additionaldetail);

        JLabel cname = new JLabel("Customer Name:" + " " + name);
        cname.setFont(new Font("Railway",Font.BOLD,18));
        cname.setBounds(450, 100,280, 30);
        add(cname);

        JLabel religion= new JLabel("Religion:");
        religion.setFont(new Font("Railway",Font.BOLD,23));
        religion.setBounds(100, 140,200, 30);
        add(religion);
        String valreligion[] = {"Select","Hindu","Muslim","Sikh","Christian","Others"};
         rel = new JComboBox<>(valreligion);
        rel.setBounds(310, 146, 400, 26);
        rel.setBackground(Color.WHITE);
        add(rel);

       
        JLabel category= new JLabel("Category:");
        category.setFont(new Font("Railway",Font.BOLD,23));
        category.setBounds(100, 190,200, 30);
        add(category);
        String valcategory[] = {"Select","General","OBC","SC","NT","Others"};
         cat = new JComboBox<>(valcategory);
        cat.setBounds(310, 192, 400, 26);
        cat.setBackground(Color.WHITE);
        add(cat);

        JLabel income= new JLabel("Income:");
        income.setFont(new Font("Railway",Font.BOLD,23));
        income.setBounds(100, 240,200, 30);
        add(income);
        String incategory[] = {"Select","10,000 to 1,00,000","< 1,00,000","< 2,00,000","< 3,50,000","< 5,00,000","5,00,000 to 10,00,000","Others"};
         inc = new JComboBox<>(incategory);
        inc.setBounds(310, 244, 400, 26);
        inc.setBackground(Color.WHITE);
        add(inc);

        JLabel education= new JLabel("Educational");
        education.setFont(new Font("Railway",Font.BOLD,23));
        education.setBounds(100, 300,200, 30);
        add(education);
        JLabel qualification= new JLabel("Qualification:");
        qualification.setFont(new Font("Railway",Font.BOLD,23));
        qualification.setBounds(100, 340,200, 30);
        add(qualification);
        String eduqu[] = {"Select","Non-Graduate","Graduate","Diploma","Post-Graduation","Doctrate","Others"};
         edu = new JComboBox<>(eduqu);
        edu.setBounds(310, 342, 400, 26);
        edu.setBackground(Color.WHITE);
        add(edu);


        JLabel occupation= new JLabel("Occupation:");
        occupation.setFont(new Font("Railway",Font.BOLD,23));
        occupation.setBounds(100, 390,200, 30);
        add(occupation);
        String occ[] = {"Select","Employed","Self-Employed","Student","Salaried","Retired","Others"};
         occupa = new JComboBox<>(occ);
        occupa.setBounds(310, 392, 400, 26);
        occupa.setBackground(Color.WHITE);
        add(occupa);


        JLabel pan= new JLabel("PAN No:");
        pan.setFont(new Font("Railway",Font.BOLD,23));
        pan.setBounds(100, 440,200, 30);
        add(pan);
         textfield = new JTextField();
        textfield.setFont(new Font("Arial",Font.BOLD,14));
        textfield.setBounds(310, 442, 400, 26);
        textfield.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String name2 = textfield.getText();
                if (name2.length() > 9) {
                    JOptionPane.showMessageDialog(null, "Maximum 10 digits are allowed");
                    textfield.setText("");
                }
            }
        });
        add(textfield);

        JLabel aadhar= new JLabel("Aadhar No:");
        aadhar.setFont(new Font("Railway",Font.BOLD,23));
        aadhar.setBounds(100, 490,200, 30);
        add(aadhar);
        textfield1 = new JTextField();
        textfield1.setFont(new Font("Arial",Font.BOLD,14));
        textfield1.setBounds(310, 492, 400, 26);
        textfield1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String name3 = textfield1.getText();

                char[] chars = name3.toCharArray();
                for (char c : chars) {
                    if ((!Character.isDigit(c))) {
                        JOptionPane.showMessageDialog(null, "Only digits are allowed");
                        textfield1.setText("");
                    }
        
                }

                if (name3.length() > 11) {
                    JOptionPane.showMessageDialog(null, "Maximum 12 digits are allowed");
                    textfield1.setText("");
                }
            }
        });
        add(textfield1);

        JLabel sc= new JLabel("Senior Citizen:");
        sc.setFont(new Font("Railway",Font.BOLD,23));
        sc.setBounds(100, 540,200, 30);
        add(sc);
         yes= new JRadioButton("Yes");
        yes.setBounds(310, 542, 160, 30);
        yes.setBackground(Color.WHITE);
        yes.setFont(new Font("Arial",Font.BOLD,18));
        add(yes);
         no = new JRadioButton("No");
        no.setBounds(490, 542, 200, 30);
        no.setBackground(Color.WHITE);
        no.setFont(new Font("Arial",Font.BOLD,18));
        add(no);
        ButtonGroup sc1 = new ButtonGroup();
        // class exist in java.swing package
        sc1.add(yes);
        sc1.add(no);

        JLabel ea= new JLabel("Existing Account:");
        ea.setFont(new Font("Railway",Font.BOLD,23));
        ea.setBounds(100, 590,200, 30);
        add(ea);
         eyes= new JRadioButton("Yes");
        eyes.setBounds(310, 592, 160, 30);
        eyes.setBackground(Color.WHITE);
        eyes.setFont(new Font("Arial",Font.BOLD,18));
        add(eyes);
         eno = new JRadioButton("No");
        eno.setBounds(490, 592, 200, 30);
        eno.setBackground(Color.WHITE);
        eno.setFont(new Font("Arial",Font.BOLD,18));
        add(eno);
        ButtonGroup sc2 = new ButtonGroup();
        // class exist in java.swing package
        sc2.add(eyes);
        sc2.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(570, 636, 100, 35);
        next.addActionListener(this);
        add(next);

       





        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,730);
        setLocation(350,10);
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
       

    }

    // signuptwo(){
        
    // }

    public static void main(String[] args) {
        new signuptwo(" "," "," ");
        // String formno data is coming from signup class as a session variable but you can see the time we are  
        // creating object constructor will call itself but constructor-signuptwo have arguments which is coming from 
        // signup so create default constructor or pass space while creating object. 
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        //  String formno = " " + Random;
         String religion = (String) rel.getSelectedItem();
         String category = (String) cat.getSelectedItem();
         String income = (String) inc.getSelectedItem();
         String education = (String) edu.getSelectedItem();
         String occupation = (String) occupa.getSelectedItem();
         String pan= textfield.getText();
         String aadhar = textfield1.getText();
         
        // getting values from JDateChooser class.
        String sc = null;
        if(yes.isSelected()){
            sc = "YES";
        }else if(no.isSelected()){
            sc = "No";
        }
      
         
         String ea = null;
         if(eyes.isSelected()){
             ea = "YES";
         }else if(eno.isSelected()){
             ea = "NO";
        
         } 
         try {
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null, "Religion is Required");
                // this method is use to pop-up dialog box in windows
            }else if(category.equals("")){
                JOptionPane.showMessageDialog(null, "Category is Required");
            }else if(income.equals("")){
                JOptionPane.showMessageDialog(null, "Income is Required");
            }else if(education.equals("")){
                JOptionPane.showMessageDialog(null, "Educational Qualification is Required");
            }else if(occupation.equals("")){
                JOptionPane.showMessageDialog(null, "Occupation is Required");
            }else if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "Pan-Card No. is Required");
            }else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar-Card No. is Required");
            }else if(sc.equals("")){
                JOptionPane.showMessageDialog(null, "Click 'Yes' if you are a senior citizen otherwise 'No'");
            }
            else if(ea.equals("")){
                JOptionPane.showMessageDialog(null, "Click 'Yes' if you have an account in this bank otherwise 'No'");
            } else{

                try {
                    conn c = new conn();
                    String query1 ="select * from signuptwo where aadhar ='"+ aadhar +"' or pan ='"+ pan +"' ";
                   ResultSet rs = c.s.executeQuery(query1);
                   if(rs.next()){
                    JOptionPane.showMessageDialog(null,"user already registered with this aadhar no");
                   }else{
                    // conn c =new conn();
                String query = "Insert into signuptwo(formno,religion,category,income,education,occupation,pan,aadhar,seniorcitizen,existingaccount)values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+sc+"','"+ea+"')";
                c.s.executeUpdate(query);
                System.out.println("Data Inserted Successfully in signuptwo table");
                // connection.statement.executequery
                // if(e.getSource() == next){
                //     System.out.println("next is available...");
                //     setVisible(false);
                //     // this will close the current form.
                //     // current form will be invisible.
                //     // start signup form.............
                //     new signuptwo().setVisible(true);
                //     // if we want to open signup page we have to create object of that class
                if(e.getSource() == next){
                    System.out.println("next is available...");
                    setVisible(false);
                    // this will close the current form.
                    // current form will be invisible.
                    // start signup form.............
                    new signupthree(formno,name,email).setVisible(true);
                    // if we want to open signup page we have to create object of that class
                }
                }
         }catch(Exception e1){
            System.out.println("Database not Connected."+e1);
         }
                   }
                
                } catch (Exception e1) {
                   System.out.println(e1);
                }

                
         
        }
    }
    
   

   



