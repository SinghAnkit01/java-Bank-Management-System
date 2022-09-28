package com.bank.bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;
// comes from extended package of java

public class Transaction extends JFrame implements ActionListener {
    JButton deposit, fast, mini, withdraw, pin1, exit, balance, passbook;
    String name, card, pin, formno, name2;

    // always delete local declaration oyherwise global declaration will not accept;
    Transaction(String formno, String name, String card, String pin, String name2) {
        // this.name=name;
        this.card = card;
        this.pin = pin;
        this.formno = formno;
        this.name2 = name2;
        // this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("static/atm-machine.jpg"));
        // comes from ClassLoader.class file
        Image i2 = i1.getImage().getScaledInstance(680, 680, Image.SCALE_DEFAULT);
        // scaling image width and height
        ImageIcon i3 = new ImageIcon(i2);
        // converting image to imageicon
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0, 0, 680, 680);

        JLabel text = new JLabel("Please select Your Transaction");
        // JOptionPane.showMessageDialog(null, "Verify its you with your card-number");
        JLabel text1 = new JLabel("Account Holder Name : " + " " + name2);
        text1.setBounds(120, 415, 500, 35);
        text.setBounds(130, 375, 700, 35);
        text.setFont(new Font("Railway", Font.BOLD, 16));
        text.setForeground(Color.white);
        text1.setFont(new Font("Railway", Font.BOLD, 14));
        text1.setForeground(Color.white);
        image.add(text);
        image.add(text1);
        // this method will add text on frame(add(text)) and then to
        // image(image.add(text))

        // adding buttons

        deposit = new JButton("Deposit");
        deposit.setBounds(120, 475, 110, 30);
        deposit.addActionListener(this);
        // deposit.setBackground(Color.WHITE);
        image.add(deposit);

        withdraw = new JButton("Cash Withdrawl");
        withdraw.setBounds(260, 475, 130, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fast = new JButton("Fast Cash");
        fast.setBounds(120, 515, 110, 30);
        fast.addActionListener(this);
        image.add(fast);

        mini = new JButton("Mini Statement");
        mini.setBounds(260, 515, 130, 30);
        mini.addActionListener(this);
        image.add(mini);

        pin1 = new JButton("Pin Change");
        pin1.setBounds(120, 555, 110, 30);
        pin1.addActionListener(this);
        image.add(pin1);

        passbook = new JButton("Passbook");
        passbook.setBounds(120, 595, 110, 30);
        // passbook.setFont(new Font("Railway",Font.BOLD,16));
        passbook.addActionListener(this);
        image.add(passbook);

        balance = new JButton("Check Balance");
        balance.setBounds(260, 555, 130, 30);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(260, 595, 130, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(680, 680);
        setLocation(360, 20);
        setLayout(null);
        setUndecorated(true);
        // this method is used to delete unused frame on upper-side on java frame
        setVisible(true);

    }

    public static void main(String[] args) {
        new Transaction("", "", "", "", "");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.out.println("exit is selected");
            JOptionPane.showMessageDialog(null, "You have selected Exit");
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            System.out.println("you are clicking on deposit");
            setVisible(false);
            new Deposit(card, pin, name2).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            System.out.println("withdrawl button");

            try {
                conn c = new conn();
                String url = "select accountno from passbook where cardnumber = '" + card + "' and pin = '" + pin
                        + "' ";
                ResultSet rs1 = c.s.executeQuery(url);

                if (rs1.next()) {
                    String account = rs1.getString("accountno");
                    System.out.println(account);
                    setVisible(false);
                     new withdraw(card, pin, name2, account).setVisible(true);
                    }
            }catch(Exception e){
            System.out.println(e);
            }
            

           
        } else if (ae.getSource() == fast) {
            System.out.println("fast cash button");
            setVisible(false);
            new FastCash(card, pin, name2).setVisible(true);
            

        } else if (ae.getSource() == mini) {

            setVisible(false);
            new minstat(card, pin, name2).setVisible(true);


            System.out.println("mini statement button");
        
        } else if (ae.getSource() == pin1) {

            setVisible(false);
            new pinchange(pin, card, name2).setVisible(true);

            System.out.println("pinchange button");
        } else if (ae.getSource() == balance) {

            setVisible(false);
            new chbalance(pin,card,name2).setVisible(true);
            System.out.println("balance button");
        } else if (ae.getSource() == passbook) {

            Random random = new Random();
            // generating random 16 digit card number
            String account = "" + Math.abs((random.nextLong() % 900000L) + 105073600000L);
            // cardnumber starting digit will be same as 50409360 + 00000000;
            // changing long to string datatype using ["" + (calculation)]
            // String uk = "UKIN";
            // String ifsc = "" + Math.abs((random.nextLong() % 90000L) + "UKIN"+ 126456L) ;
            String ifsc = "" + Math.abs((random.nextLong() % 90000L) + 1264500000L);

            if (ae.getSource() == passbook) {

                // to check whether old user or new user
                // if old user than check your gmail for passbook
                // if new than you can visit via new passboob().setVisiblt(true);
                try {
                    conn conn = new conn();
                    String query = "select * from passbook where cardnumber = '" + card + "' and pin = '" + pin + "' ";
                    ResultSet rs = conn.s.executeQuery(query);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Already sended to Your gmail account Gmail");
                        setVisible(false);
                        new Transaction(formno, name, card, pin, name2).setVisible(true);
                        
                    } else {
                        setVisible(false);
                        new passbook(formno, name, card, pin, account, ifsc, name2).setVisible(true);
                        System.out.println("balance button");
                    }
                } catch (Exception e) {
                    System.out.println("Error.....");
                }
            }

        }

    }
}
