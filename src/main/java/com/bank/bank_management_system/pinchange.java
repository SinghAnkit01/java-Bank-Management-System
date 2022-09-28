package com.bank.bank_management_system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class pinchange extends JFrame implements ActionListener {

    JButton back, change;
    JTextField npin;
    JPasswordField rpin;

    String card, pin, name2;

    pinchange(String pin, String card, String name2) {
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

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway", Font.BOLD, 16));
        text.setBounds(170, 355, 200, 30);
        image.add(text);

        JLabel text11 = new JLabel("Account Holder Name : " + " " + name2);
        // text1.setBounds(170, 395, 500, 35);
        text11.setBounds(120, 385, 500, 35);
        text11.setFont(new Font("Railway", Font.BOLD, 14));
        text11.setForeground(Color.white);
        image.add(text11);

        JLabel text1 = new JLabel("NEW PIN:");
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("Railway", Font.BOLD, 16));
        text1.setBounds(130, 475, 200, 30);
        image.add(text1);

        npin = new JTextField();
        npin.setFont(new Font("Railway", Font.BOLD, 25));
        npin.setBounds(230, 475, 150, 25);
        npin.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke) {
                String value = npin.getText();
                // int l = value.length();
                if(value.length() > 3){
                    JOptionPane.showMessageDialog(null, "Maximum four digits are allowed");
                    npin.setText("");
                }
                // System.out.println(l);
                if(ke.getKeyChar() >='0' && ke.getKeyChar() <='9'){
                    npin.setEditable(true);
                    // if(l>4){
                    //     JOptionPane.showMessageDialog(null, "maximum four digits are allowed");
                    // }else{

                    // }
                }else{
                    npin.setEditable(false);
                }

             

            }
        });

        image.add(npin);

        JLabel text2 = new JLabel("RE-ENTER:");
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Railway", Font.BOLD, 16));
        text2.setBounds(130, 515, 200, 30);
        image.add(text2);

        JLabel text3 = new JLabel(" NEW PIN");
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("Railway", Font.BOLD, 14));
        text3.setBounds(130, 540, 110, 25);
        image.add(text3);

        rpin = new JPasswordField();
        rpin.setFont(new Font("Railway", Font.BOLD, 25));
        rpin.setBounds(230, 515, 150, 25);
        rpin.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke) {
                String value = rpin.getText();
                // int l = value.length();
                if(value.length() > 3){
                    JOptionPane.showMessageDialog(null, "Maximum four digits are allowed");
                    rpin.setText("");
                }
                // System.out.println(l);
                if(ke.getKeyChar() >='0' && ke.getKeyChar() <='9')
                {
                    rpin.setEditable(true);
                    // if(l>4){
                    //     JOptionPane.showMessageDialog(null, "maximum four digits are allowed");
                    // }else{

                    // }
                }else{
                    npin.setEditable(false);
                }
            }
        });
            
        image.add(rpin);

        change = new JButton("CHANGE");
        change.setBounds(260, 555, 120, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(260, 595, 120, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(680, 680);
        setLocation(360, 20);
        setLayout(null);
        setTitle("PinChange");
        setUndecorated(true);
        // this method is used to delete unused frame on upper-side on java frame
        setVisible(true);

    }

    public static void main(String[] args) {
        new pinchange("", "", "").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == change) {
            try {

                String text1 = npin.getText();
                // new pin
                String text2 = rpin.getText();
                // reenter new pin

                if (!text1.equals(text2)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }

                if (text1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter pin");
                    return;
                }

                if (text2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new pin");
                    return;
                }
                // database connectivity to change old pin with new pin in login table
                // there are three database which contain pin as column like bank,login,
                // signupthree;
                conn conn = new conn();
                String query1 = "update bank set pin ='" + text1 + "' where pin ='" + pin + "' ";
                String query2 = "update login set pin ='" + text1 + "' where pin ='" + pin + "' ";
                String query3 = "update signupthree set pin ='" + text1 + "' where pin ='" + pin + "' ";
                String query4 = "update passbook set pin ='" + text1 + "' where pin ='" + pin + "' ";

                // update is a dml command so executeUpdate

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                conn.s.executeUpdate(query4);

                JOptionPane.showMessageDialog(null, "Pin change successfully");

                try {
                    String url = "select formno from login where cardnumber = '" + card + "' and pin = '" + pin
                            + "' ";
                    ResultSet rs1 = conn.s.executeQuery(url);

                    if (rs1.next()) {
                        String name1 = rs1.getString("formno");
                        System.out.println(name1);

                        try {
                            String url1 = "select email from signup where formno = '" + name1 + "'";
                            ResultSet rs2 = conn.s.executeQuery(url1);

                            if (rs2.next()) {
                                String email = rs2.getString("email");
                                System.out.println(email);
                                new pcemail("", name2, "", "", email, text1);
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

                

            } catch (Exception e) {

            }
        } else {
            setVisible(false);
            new Transaction("", "", card, pin, "").setVisible(true);
        }
    }
}

