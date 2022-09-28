package com.bank.bank_management_system;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.*;
import java.sql.ResultSet;
// import java.security.Provider.Service;
import java.util.Random;
// import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

// import java.awt.*;



public class signupthree extends JFrame implements ActionListener {
    // ActionListener comes from java.awt.event.* package 

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno,name,email;
    signupthree(String formno,String name,String email){
        this.formno = formno;
        this.name = name;
        this.email = email;

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel cname = new JLabel("Customer Name:" + " " + name);
        cname.setFont(new Font("Railway",Font.BOLD,18));
        cname.setBounds(420, 80,280, 30);
        add(cname);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100, 120, 200, 30);
        add(type);

        // savings
        r1= new JRadioButton("Savings-account");
        r1.setBounds(100, 170, 200, 20);
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Arial",Font.BOLD,16));
        add(r1);
        // current
        r2= new JRadioButton("Current-account");
        r2.setBounds(310, 170, 360, 20);
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Arial",Font.BOLD,16));
        add(r2);
         // fixed-deposit
         r3= new JRadioButton("Fixed Deposit Account");
         r3.setBounds(100, 210, 200, 20);
         r3.setBackground(Color.WHITE);
         r3.setFont(new Font("Arial",Font.BOLD,16));
         add(r3);
          // Recurring deposit account
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setBounds(310, 210, 360, 20);
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Arial",Font.BOLD,16));
        add(r4);

        ButtonGroup atype = new ButtonGroup();
        atype.add(r1);
        atype.add(r2);
        atype.add(r3);
        atype.add(r4);

        // card-type
        JLabel cno = new JLabel("Card Number:");
        cno.setFont(new Font("Railway",Font.BOLD,22));
        cno.setBounds(100, 260, 200, 30);
        add(cno);

        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-4143");
        cnumber.setFont(new Font("Railway",Font.BOLD,22));
        cnumber.setBounds(300, 260, 400, 30);
        add(cnumber);

        JLabel detail = new JLabel("Your 16 Digit Card Number");
        detail.setFont(new Font("Railway",Font.BOLD,12));
        detail.setBounds(100, 290, 400, 20);
        add(detail);
        // this is ia message to show above is a card number
        // pin
        JLabel pno = new JLabel("PIN:");
        pno.setFont(new Font("Railway",Font.BOLD,22));
        pno.setBounds(100, 330, 200, 30);
        add(pno);

        JLabel detail1= new JLabel("Your 4 Digit Password");
        detail1.setFont(new Font("Railway",Font.BOLD,12));
        detail1.setBounds(100, 360, 400, 20);
        add(detail1);
        // this is ia message to show above is a pin number
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Railway",Font.BOLD,22));
        pnumber.setBounds(300, 330, 200, 30);
        add(pnumber);

        // services required
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Railway",Font.BOLD,22));
        services.setBounds(100, 400, 200, 30);
        add(services);

        // atm-card using checkbox
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(100, 440, 200, 30);
        add(c1);
        // internet banking
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(100, 470, 200, 30);
        add(c2);
        // mobile banking
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(100, 500, 200, 30);
        add(c3);
        //email and sms alerts
        c4= new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(310, 440, 200, 30);
        add(c4);

        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(310, 470, 200, 30);
        add(c5);

        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(310, 500, 200, 30);
        add(c6);

        // declaration    
        c7= new JCheckBox("I herby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Railway",Font.BOLD,12));
        c7.setBounds(100, 560, 600, 30);
        add(c7);
       
        // submit button

        submit = new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Railway",Font.BOLD,14));
        submit.setBounds(200, 620, 100, 30);
        submit.addActionListener(this);
        add(submit);

        // cancel button

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway",Font.BOLD,14));
        cancel.setBounds(350, 620, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,730);
        setLocation(350,10);
        setVisible(true);
        setTitle("ACCOUNT DEATILS- PAGE 3");
    }
    public static void main(String[] args) {
        new signupthree("","","");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){

              String type = null;
            //  1) for selecting single option
              if(r1.isSelected()){
                // getting values from radiobutton
                type="Savings-account";
              }else if(r2.isSelected()){
                type="Current-account";
              }else if(r3.isSelected()){
                type="Fixed-Deposit account";
              }else if(r4.isSelected()){
                type="Recurring Deposit account";
              }

              Random random = new Random();
            //   generating random 16 digit card number
              String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            //   cardnumber starting digit will be same as 50409360 + 00000000;
            // changing long to string datatype using ["" + (calculation)]

             String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L) ;
            //  generating random 4 digit pin number 
            // converting that long value to string datatype using ["" + (calculation)]

            // accessing values from  multiple checkbox.
            //  2) for selecting multiple option
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            }else if(c2.isSelected()){
                facility = facility + "Internet Banking";
            }else if(c3.isSelected()){
                facility = facility + "Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + "EMAIL & SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility + "Cheque Book";
            }else if(c6.isSelected()){
                facility = facility + "E-Statement";
            }
            //  String services = "";
           
            // if(c1.isSelected()){
            //     services = services + "ATM Card";
            // }else if(c2.isSelected()){
            //     services = services + "Internet Banking";
            // }else if(c3.isSelected()){
            //     services = services + "Mobile Banking";
            // }else if(c4.isSelected()){
            //     services = services + "EMAIL & SMS Alerts";
            // }else if(c5.isSelected()){
            //     services = services + "Cheque Book";
            // }else if(c6.isSelected()){
            //     services = services + "E-Statement";
            // }

            try {
                if(type.equals("")){
                    JOptionPane.showMessageDialog(null, "Name is Required");
                    // this method is use to pop-up dialog box in windows
                }else if(c7.equals("")){
                    JOptionPane.showMessageDialog(null, "Please click Declaration Type");
                }
            conn c =new conn();
            String query = "Insert into signupthree(formno,accountType,cardnumber,pin,facility)values('"+formno+"','"+type+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
            c.s.executeUpdate(query);
            System.out.println("Data Inserted Successfully in signupthree table");

            String query1 = "Insert into login(formno,cardnumber,pin)values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
            c.s.executeUpdate(query1);
            System.out.println("Data Inserted Successfully in Login table");
                

            // JOptionPane.showMessageDialog(null, "Card Number:" + " " + cardnumber + "\n" + "Pin Number:" + " " + pinnumber);
            JOptionPane.showMessageDialog(null, "You will receive your cardnumber and pin in your registered Gmail");

            // setVisible(false);
            // new Deposit(cardnumber,"").setVisible(true);

            JOptionPane.showMessageDialog(null, " Hii " + " "+ name + " click to Login with this pinnumber and cardnumber"  + " \n" + "sended to your gmail account");

            try {
                String url = "select formno from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "' ";
                ResultSet rs1 = c.s.executeQuery(url);

                if (rs1.next()) {
                    String name1 = rs1.getString("formno");
                    System.out.println(name1);

                    try {
                        String url1 = "select email from signup where formno = '" + name1 + "'";
                        ResultSet rs2 = c.s.executeQuery(url1);

                        if (rs2.next()) {
                            String email = rs2.getString("email");
                            System.out.println(email);
                            new email(formno,name,cardnumber,pinnumber,email);
                            setVisible(false);
                            new Transaction("", "", cardnumber, pinnumber, name).setVisible(true);

                        }
                    } catch (Exception ea) {
                        System.out.println(ea);
                    }

                }
            } catch (Exception ea) {
                System.out.println(ea);
            }

                
            // new Transaction();
                
            } catch (Exception e1) {
               System.out.println("Error....");
               new Transaction(formno,name,cardnumber, pinnumber,"");
                 }


              




            // System.out.println("you have click submit button");
        }else if(e.getSource() == cancel){
            // new signupthree("","","").setVisible(true);
            new BankManagementSystemApplication().setVisible(true);
            // this is use to refresh the form;
            // this.dispose();
            //  System.out.println("you have click cancel button");
        }
        
    }
}

