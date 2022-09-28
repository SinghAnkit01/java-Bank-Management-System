package com.bank.bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class minstat extends JFrame implements ActionListener {

    JButton mini;
    String pin,card,name2;
    minstat(String card, String pin, String name2){
        this.pin=pin;
        this.card=card;
        this.name2=name2;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("static/atm-machine.jpg"));
        // comes from ClassLoader.class file
        Image i2 = i1.getImage().getScaledInstance(680, 680, Image.SCALE_DEFAULT);
        // scaling image width and height
        ImageIcon i3 = new ImageIcon(i2);
        // converting image to imageicon
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0, 0, 680, 680);

        JLabel text = new JLabel("Selected Transaction : Mini Statement");
        // JOptionPane.showMessageDialog(null, "Verify its you with your card-number");
        JLabel text1 = new JLabel("Account Holder Name : " + " " + name2);
        text1.setBounds(120, 385, 500, 35);
        text.setBounds(120, 355, 700, 35);
        text.setFont(new Font("Railway", Font.BOLD, 14));
        text.setForeground(Color.white);
        text1.setFont(new Font("Railway", Font.BOLD, 14));
        text1.setForeground(Color.white);
        image.add(text);
        image.add(text1);

        mini = new JButton("View Statement");
        mini.setBounds(120, 475, 150, 30);
        mini.addActionListener(this);
        // deposit.setBackground(Color.WHITE);
        image.add(mini);

        setSize(680, 680);
        setLocation(360, 20);
        setLayout(null);
        setTitle("Check Balance");
        setUndecorated(true);
        // this method is used to delete unused frame on upper-side on java frame
        setVisible(true);
    }
    public static void main(String[] args) {
       new minstat("","","");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mini){
            System.out.println("you clicked on view statement");
                // setVisible(false);
                new mini(card, pin, name2).setVisible(true);

            }

    }
}
