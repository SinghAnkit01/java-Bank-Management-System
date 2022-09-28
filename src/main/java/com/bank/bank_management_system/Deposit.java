package com.bank.bank_management_system;

import javax.swing.JFrame;

// import javafx.scene.image.Image;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField amounts;
    JButton deposit, back;
    String card, pin, name2;
    String bank = "Bank Name: UK BANK OF INDIA";
    String branch = "Branch Name: Vartak Nagar Thane(w)-06";

    Deposit(String card, String pin, String name2) {
        this.card = card;
        this.pin = pin;
        this.name2 = name2;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("static/atm-machine.jpg"));
        // comes from ClassLoader.class file
        Image i2 = i1.getImage().getScaledInstance(680, 680, Image.SCALE_DEFAULT);
        // scaling image width and height
        ImageIcon i3 = new ImageIcon(i2);
        // converting image to imageicon
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0, 0, 680, 680);

        JLabel text = new JLabel("Selected Transaction : Deposit");
        // JOptionPane.showMessageDialog(null, "Verify its you with your card-number");
        JLabel text1 = new JLabel("Account Holder Name : " + " " + name2);
        text1.setBounds(120, 385, 500, 35);
        text.setBounds(140, 355, 700, 35);
        text.setFont(new Font("Railway", Font.BOLD, 16));
        text.setForeground(Color.white);
        text1.setFont(new Font("Railway", Font.BOLD, 14));
        text1.setForeground(Color.white);
        image.add(text);
        image.add(text1);

        JLabel text2 = new JLabel("Enter the amount you want to deposit");
        text2.setBounds(130, 435, 900, 35);
        text2.setFont(new Font("Railway", Font.BOLD, 13));
        text2.setForeground(Color.white);
        image.add(text2);

        amounts = new JTextField();
        amounts.setFont(new Font("Railway", Font.BOLD, 22));
        amounts.setBounds(130, 475, 150, 30);
        image.add(amounts);

        deposit = new JButton("Deposit");
        deposit.setBounds(260, 555, 120, 30);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(260, 595, 120, 30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        setSize(680, 680);
        setLocation(360, 20);
        setLayout(null);
        setTitle("Deposit Cash");
        setUndecorated(true);
        // this method is used to delete unused frame on upper-side on java frame
        setVisible(true);

    }

    public static void main(String[] args) {
        new Deposit("", "", "");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == deposit) {

            String number = amounts.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");

            } else {

                try {
                    conn c = new conn();
                    int i = Integer.parseInt(number);
                    if(i<1000 || i>15000){
                        JOptionPane.showMessageDialog(null,"Minimum 1000 and Maximum 15000 can be Deposit");
                    }else{
                    JOptionPane.showMessageDialog(null, "Rs" + " " + number + " Deposited Successfully");
                    String query = "Insert into bank(pin,date,type,amount)values('" + pin + "','" + date
                            + "','Deposit','" + number + "')";
                    c.s.executeUpdate(query);
                    System.out.println("Data Inserted Successfully in bank table");
                    

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

                                    // sending total money after depositing

                                    int balance = 0;
                                    try {
                                        ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pin + "' ");

                                        while (rs.next()) {
                                            // rs.next() use to loop single row
                                            if (rs.getString("type").equals("Deposit")) {
                                                balance += Integer.parseInt(rs.getString("amount"));
                                            } else {
                                                balance -= Integer.parseInt(rs.getString("amount"));
                                            }
                                            System.out.println(balance);

                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    

                                    new demail(card, pin, email, number, bank, branch, name2,balance);
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
                }
                

                } catch (Exception e) {
                    System.out.println("Error occured during connecting Database...");
                    
                }

            }
            
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction("", "", card, pin, "").setVisible(true);
        }

    }
}
