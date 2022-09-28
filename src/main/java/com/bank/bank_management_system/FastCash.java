package com.bank.bank_management_system;

import javax.swing.JFrame;

// import javafx.scene.image.Image;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class FastCash extends JFrame implements ActionListener {

    // JTextField amounts;
    JButton back, twothousand, twothousand1, twothousand3, twothousand5, twothousand6, twothousand4;
    String card, pin, name2;

    FastCash(String card, String pin, String name2) {
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

        JLabel text = new JLabel("Selected Transaction : Fast Cash");
        // JOptionPane.showMessageDialog(null, "Verify its you with your card-number");
        JLabel text1 = new JLabel("Account Holder Name : " + " " + name2);
        text1.setBounds(120, 385, 500, 35);
        text.setBounds(120, 355, 700, 35);
        text.setFont(new Font("Railway", Font.BOLD, 16));
        text.setForeground(Color.white);
        text1.setFont(new Font("Railway", Font.BOLD, 14));
        text1.setForeground(Color.white);
        image.add(text);
        image.add(text1);

        JLabel text2 = new JLabel("Select Amount for Fast Cash");
        text2.setBounds(130, 435, 900, 35);
        text2.setFont(new Font("Railway", Font.BOLD, 16));
        text2.setForeground(Color.white);
        image.add(text2);

        twothousand = new JButton("Rs.200");
        twothousand.setFont(new Font("Railway", Font.BOLD, 14));
        twothousand.setBounds(130, 475, 120, 30);
        twothousand.setBackground(Color.WHITE);
        twothousand.setForeground(Color.BLACK);
        twothousand.addActionListener(this);
        image.add(twothousand);

        twothousand1 = new JButton("Rs.500");
        twothousand1.setFont(new Font("Railway", Font.BOLD, 14));
        twothousand1.setBounds(130, 515, 120, 30);
        twothousand1.setBackground(Color.WHITE);
        twothousand1.setForeground(Color.BLACK);
        twothousand1.addActionListener(this);
        image.add(twothousand1);

        twothousand3 = new JButton("Rs.100");
        twothousand3.setFont(new Font("Railway", Font.BOLD, 14));
        twothousand3.setBounds(130, 555, 120, 30);
        twothousand3.setBackground(Color.WHITE);
        twothousand3.setForeground(Color.BLACK);
        twothousand3.addActionListener(this);
        image.add(twothousand3);

        twothousand4 = new JButton("Rs.1500");
        twothousand4.setFont(new Font("Railway", Font.BOLD, 14));
        twothousand4.setBounds(260, 475, 120, 30);
        twothousand4.setBackground(Color.WHITE);
        twothousand4.setForeground(Color.BLACK);
        twothousand4.addActionListener(this);
        image.add(twothousand4);

        twothousand5 = new JButton("Rs.2000");
        twothousand5.setFont(new Font("Railway", Font.BOLD, 14));
        twothousand5.setBounds(260, 515, 120, 30);
        twothousand5.setBackground(Color.WHITE);
        twothousand5.setForeground(Color.BLACK);
        twothousand5.addActionListener(this);
        image.add(twothousand5);

        twothousand6 = new JButton("Rs.2500");
        twothousand6.setFont(new Font("Railway", Font.BOLD, 14));
        twothousand6.setBounds(260, 555, 120, 30);
        twothousand6.setBackground(Color.WHITE);
        twothousand6.setForeground(Color.BLACK);
        twothousand6.addActionListener(this);
        image.add(twothousand6);

        // withdraw = new JButton("Withdraw");
        // withdraw.setBounds(280, 555, 110, 30);
        // withdraw.setBackground(Color.WHITE);
        // withdraw.setForeground(Color.BLACK);
        // withdraw.addActionListener(this);
        // image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(260, 595, 120, 30);
        twothousand6.setFont(new Font("Railway", Font.BOLD, 18));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        setSize(680, 680);
        setLocation(360, 20);
        setLayout(null);
        setTitle("FastCash Withdrawl");
        setUndecorated(true);
        // this method is used to delete unused frame on upper-side on java frame
        setVisible(true);

    }

    public static void main(String[] args) {
        new FastCash("", "", "");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {

            setVisible(false);
            new Transaction("", "", card, pin, "").setVisible(true);

        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            // ae.getSource() gives access of button
            // takes access of all the button using ae.gerSource() and .getText() use to get
            // text written on button
            // .substring(3) excluding starting 3 strings of button fo eg (Rs.500) excluding
            // (Rs.)
            try {
                conn c = new conn();

                ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pin + "' ");
                int balance = 0;
                while (rs.next()) {
                    // rs.next() use to loop single row
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showConfirmDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "Insert into bank(pin,date,type,amount)values('" + pin + "','" + date + "','withdrawl','"
                        + amount + "')";
                c.s.executeUpdate(query);
                System.out.println("Data Inserted Successfully in bank table with withdrawl");
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited successfully");

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

                                // int balance1 = 0;
                                try {
                                    ResultSet rs3 = c.s.executeQuery("select * from bank where pin ='" + pin + "' ");

                                    while (rs3.next()) {
                                        // rs.next() use to loop single row
                                        if (rs3.getString("type").equals("Deposit")) {
                                            balance += Integer.parseInt(rs.getString("amount"));
                                        } else {
                                            balance -= Integer.parseInt(rs.getString("amount"));
                                        }
                                        System.out.println(balance);

                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                new femail(card, pin, email, amount,name2,balance);
                                setVisible(false);
                                new Transaction("", "", card, pin, name2).setVisible(true);
                                new drawlslip(card, pin, email, name2, "", "", balance);

                            }
                        } catch (Exception ea) {
                            System.out.println(ea);
                        }

                    }
                } catch (Exception ea) {
                    System.out.println(ea);
                }

                // ResultSet rs1 = c.s.executeQuery("select name from signup where name ='raja'
                // ");
                // if(rs1.next()){
                // int name = Integer.parseInt(rs1.getString(""));
                // System.out.println(name);
                // }

                // JOptionPane.showMessageDialog(null, "Rs" + " " + number + " Deposited
                // Successfully");
                // String query = "Insert into
                // bank(pin,date,type,amount)values('"+pin+"','"+date+"','Deposit','"+number+"')";
                // c.s.executeUpdate(query);
                // System.out.println("Data Inserted Successfully in bank table");
            } catch (Exception e) {
                System.out.println("Cannot insert values in Database");
            }
        }

    }
}
