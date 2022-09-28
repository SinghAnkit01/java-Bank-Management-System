package com.bank.bank_management_system;

// import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
// import javax.swing.JRadioButton;
import java.awt.event.*;
import java.sql.ResultSet;
// import java.security.Provider.Service;
// import java.util.Random;
// import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

// import java.awt.*;

public class passbook extends JFrame implements ActionListener {
    // ActionListener comes from java.awt.event.* package

    // JRadioButton r1,r2,r3,r4;
    JCheckBox c7;
    JButton print;
    String formno, card, pin, name, email,account,ifsc,name2;
    
    passbook(String formno,String name, String card, String pin,String account,String ifsc,String name2) {
        this.pin = pin;
        this.card=card;
        this.name2=name2;
        // this.email=email;
        this.formno=formno;
        this.name=name;
        this.account=account;
        this.ifsc=ifsc;
        // this.bank=bank;
        // this.branch=branch;
        JLabel l1 = new JLabel("Passbook Details");
        l1.setFont(new Font("Railway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        String bank ="Bank Name: UK BANK OF INDIA";
        String branch ="Branch Name: Vartak Nagar Thane(w)-06";


        JLabel cname = new JLabel( bank);
        cname.setFont(new Font("Railway", Font.BOLD, 18));
        cname.setBounds(400, 90, 380, 30);
        add(cname);

        JLabel cname1 = new JLabel(branch);
        cname1.setFont(new Font("Railway", Font.BOLD, 18));
        cname1.setBounds(400, 130, 380, 30);
        add(cname1);

        JLabel text11 = new JLabel("Account Holder Name : " + " " + name2);
        // text1.setBounds(170, 395, 500, 35);
        text11.setBounds(400, 170, 500, 30);
        text11.setFont(new Font("Railway", Font.BOLD, 18));
        // text11.setForeground(Color.white);
        add(text11);

        JLabel type = new JLabel("FormNo : ");
        type.setFont(new Font("Railway", Font.BOLD, 22));
        type.setBounds(100, 210, 200, 30);
        add(type);
        
        JLabel cno1 = new JLabel("As per mention while submitting the online form of UK BANK OF INDIA");
        cno1.setFont(new Font("Railway", Font.BOLD, 17));
        cno1.setBounds(210, 210, 900, 30);
        add(cno1);

        // savings

        // card-type
        JLabel cno = new JLabel("Card Number:");
        cno.setFont(new Font("Railway", Font.BOLD, 22));
        cno.setBounds(100, 260, 200, 30);
        add(cno);

        JLabel cnumber = new JLabel(card);
        cnumber.setFont(new Font("Railway", Font.BOLD, 22));
        cnumber.setBounds(300, 260, 400, 30);
        add(cnumber);

        JLabel detail = new JLabel("Your 16 Digit Card Number");
        detail.setFont(new Font("Railway", Font.BOLD, 12));
        detail.setBounds(100, 290, 400, 20);
        add(detail);
        // this is ia message to show above is a card number
        // pin
        JLabel pno = new JLabel("PIN:");
        pno.setFont(new Font("Railway", Font.BOLD, 22));
        pno.setBounds(100, 330, 200, 30);
        add(pno);

        JLabel detail1 = new JLabel("Your 4 Digit Password");
        detail1.setFont(new Font("Railway", Font.BOLD, 12));
        detail1.setBounds(100, 360, 400, 20);
        add(detail1);
        // this is ia message to show above is a pin number

        JLabel pnumber = new JLabel(pin);
        pnumber.setFont(new Font("Railway", Font.BOLD, 22));
        pnumber.setBounds(300, 330, 200, 30);
        add(pnumber);

        JLabel ant = new JLabel("Account No:");
        ant.setFont(new Font("Railway", Font.BOLD, 22));
        ant.setBounds(100, 400, 200, 30);
        add(ant);

        JLabel ant1 = new JLabel("Your 12 Digit Account No.");
        ant1.setFont(new Font("Railway", Font.BOLD, 12));
        ant1.setBounds(100, 430, 400, 20);
        add(ant1);
      

        JLabel anumber  = new JLabel(account);
        anumber.setFont(new Font("Railway", Font.BOLD, 22));
        anumber.setBounds(300, 400, 200, 30);
        add(anumber);

        JLabel ifscc = new JLabel("IFSC Code:");
        ifscc.setFont(new Font("Railway", Font.BOLD, 22));
        ifscc.setBounds(100, 470, 200, 30);
        add(ifscc);

        JLabel ifsc1 = new JLabel("Your 10 Digit IFSC Code.");
        ifsc1.setFont(new Font("Railway", Font.BOLD, 12));
        ifsc1.setBounds(100, 500, 400, 20);
        add(ifsc1);
      

        JLabel inumber  = new JLabel(ifsc);
        inumber.setFont(new Font("Railway", Font.BOLD, 22));
        inumber.setBounds(300, 470, 200, 30);
        add(inumber);

        // services required

        // declaration
        c7 = new JCheckBox("I herby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Railway", Font.BOLD, 12));
        c7.setBounds(100, 560, 600, 30);
        add(c7);

        // submit button

        // submit = new JButton("submit");
        // submit.setBackground(Color.BLACK);
        // submit.setForeground(Color.WHITE);
        // submit.setFont(new Font("Railway",Font.BOLD,14));
        // submit.setBounds(200, 620, 100, 30);
        // submit.addActionListener(this);
        // add(submit);

        // cancel button

        print = new JButton("Print");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Railway", Font.BOLD, 14));
        print.setBounds(350, 620, 100, 30);
        print.addActionListener(this);
        add(print);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 730);
        setLocation(350, 10);
        setVisible(true);
        setTitle("PASSBOOK DETAILS");
    }

    public static void main(String[] args) {
        new passbook("","", "", "","","","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print) {

            // Random random = new Random();
            // generating random 16 digit card number
            // String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            // // cardnumber starting digit will be same as 50409360 + 00000000;
            // // changing long to string datatype using ["" + (calculation)]

            // String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            try {

                conn c =new conn();
                String query = "Insert into passbook(cardnumber,pin,accountno,ifsccode)values('"+card+"','"+pin+"','"+account+"' , '"+ifsc+"')";
                c.s.executeUpdate(query);
                System.out.println("Data Inserted Successfully in passbook table");

                // JOptionPane.showMessageDialog(null,
                //         "Card Number:" + " " + cardnumber + "\n" + "Pin Number:" + " " + pinnumber);

                // setVisible(false);
                // new Deposit(cardnumber,"").setVisible(true);

                JOptionPane.showMessageDialog(null, 
                         " click to send Details of your" + "\n" +"passbook to your gmail account");

                         try {
                            String url = "select formno from login where cardnumber = '" + card + "' and pin = '" + pin
                                    + "' ";
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
                                        new pemail("",name2,card, pin, email,account,ifsc);
                                        setVisible(false);
                                        new Transaction("", "", card, pin, name2).setVisible(true);
        
                                    }
                                } catch (Exception ea) {
                                    System.out.println(ea);
                                }
        
                            }
                        } catch (Exception ea) {
                            System.out.println(ea);
                        }

                // new pemail("","",card, pin, email,account,ifsc);
                // new Transaction();

            } catch (Exception e1) {
                System.out.println("Error....");
            }

            // System.out.println("you have click submit button");
        } else {
            // new signupthree("","","").setVisible(true);
            new BankManagementSystemApplication().setVisible(true);
            // this is use to refresh the form;
            // this.dispose();
            // System.out.println("you have click cancel button");
        }

    }
}
