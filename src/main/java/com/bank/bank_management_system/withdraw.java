package com.bank.bank_management_system;

import javax.swing.JFrame;

// import javafx.scene.image.Image;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class withdraw extends JFrame implements ActionListener {

    JTextField amounts;
    JButton withdraw, back;
    String card, pin, name2, account;

    // static int balance;
    withdraw(String card, String pin, String name2, String account) {
        this.card = card;
        this.pin = pin;
        this.name2 = name2;
        this.account = account;
        // this.balance = balance;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("static/atm-machine.jpg"));
        // comes from ClassLoader.class file
        Image i2 = i1.getImage().getScaledInstance(680, 680, Image.SCALE_DEFAULT);
        // scaling image width and height
        ImageIcon i3 = new ImageIcon(i2);
        // converting image to imageicon
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0, 0, 680, 680);

        JLabel text = new JLabel("Selected Transaction : Cash withdrawl");
        // JOptionPane.showMessageDialog(null, "Verify its you with your card-number");
        JLabel text1 = new JLabel("Account Holder Name : " + " " + name2);
        // text1.setBounds(170, 395, 500, 35);
        text1.setBounds(120, 385, 500, 35);
        text.setBounds(120, 355, 700, 35);
        text.setFont(new Font("Railway", Font.BOLD, 14));
        text.setForeground(Color.white);
        text1.setFont(new Font("Railway", Font.BOLD, 14));
        text1.setForeground(Color.white);
        image.add(text);
        image.add(text1);

        JLabel text2 = new JLabel("Enter the amount you want to withdraw");
        text2.setBounds(130, 435, 900, 35);
        text2.setFont(new Font("Railway", Font.BOLD, 13));
        text2.setForeground(Color.white);
        image.add(text2);

        amounts = new JTextField();
        amounts.setFont(new Font("Railway", Font.BOLD, 22));
        amounts.setBounds(130, 475, 150, 30);
        image.add(amounts);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(260, 555, 120, 30);
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(260, 595, 120, 30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        setSize(680, 680);
        setLocation(360, 20);
        setLayout(null);
        setTitle("Withdraw Cash");
        setUndecorated(true);
        // this method is used to delete unused frame on upper-side on java frame
        setVisible(true);

    }

    // public withdraw(String card2, String pin2, String name22, String account2,
    // String string) {
    // }

    public static void main(String[] args) {
        new withdraw("", "", "", "");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == withdraw) {

            String number = amounts.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withraw");

            } else {

                try {
                    conn c = new conn();

                    JOptionPane.showMessageDialog(null, "Please wait while your Transaction is being processed");
                    // JOptionPane.showMessageDialog(null, "Rs" + " " + number + " Withdrawl
                    // Successfully");
                    JOptionPane.showMessageDialog(null, "Do you need Printed Slip.");

                    // try {
                    // ResultSet rs3 = c.s.executeQuery("select * from bank where pin ='" + pin + "'
                    // ");

                    // while (rs3.next()) {
                    // int balance1=0;
                    // // rs.next() use to loop single row
                    // if (rs3.getString("type").equals("withdrawl")) {
                    // balance1 += Integer.parseInt(rs3.getString("amount"));
                    // } else {
                    // balance1 -= Integer.parseInt(rs3.getString("amount"));
                    // }
                    // if (ae.getSource() != back && balance1 < Integer.parseInt(number)) {
                    // JOptionPane.showConfirmDialog(null, "Insufficient Balance");
                    // return;
                    // }
                    // }
                    // }catch(Exception e3){
                    // System.out.println(e3);
                    // }
                    int i = Integer.parseInt(number);
                    if (i < 1000 || i > 25000) {
                        JOptionPane.showMessageDialog(null, "Minimum withdrawl is Rs.1000 to 25000");
                    } else {

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

                                        int balance = 0;
                                        try {
                                            ResultSet rs = c.s
                                                    .executeQuery("select * from bank where pin ='" + pin + "' ");

                                            while (rs.next()) {
                                                // rs.next() use to loop single row
                                                if (rs.getString("type").equals("Deposit")) {
                                                    balance += Integer.parseInt(rs.getString("amount"));
                                                    // System.out.println(balance);
                                                } else {
                                                    balance -= Integer.parseInt(rs.getString("amount"));
                                                    // System.out.println(balance);
                                                }
                                            }
                                            String number1 = amounts.getText();
                                            int i1 = Integer.parseInt(number1);
                                                if (i1 > balance) {
                                                    JOptionPane.showMessageDialog(null,
                                                            "Insufficient balance you cant withdraw.");
                                                            
                                                } else {
                                                    String query = "Insert into bank(pin,date,type,amount)values('"+ pin + "','" + date + "','withdrawl','" + number + "')";
                                                    c.s.executeUpdate(query);
                                                    System.out.println("Data Inserted Successfully in bank table");
                                                    setVisible(false);
                                                new wemail(card, pin, email, number, name2, " ", " ", balance, account).setVisible(true);
                                                }

                                            
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }

                                        

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
            // new demail(card, pin, "", "", "", "", name2, "",account);
        }

    }
}
