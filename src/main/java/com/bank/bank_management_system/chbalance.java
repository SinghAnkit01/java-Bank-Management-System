package com.bank.bank_management_system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class chbalance extends JFrame implements ActionListener {

    JLabel text,text1;
    String card,pin,name2;
    JButton back;
    chbalance(String pin, String card, String name2){
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

        JLabel text = new JLabel("Selected Transaction : Balance Enquiry");
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
        
         back = new JButton("Back");
         back.setBounds(260, 555, 130, 30);
         back.addActionListener(this);
        image.add(back);

        conn c = new conn();
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

                }
        } catch (Exception e) {
            System.out.println(e);
        }

         text = new JLabel("Your current Account");
         text1 = new JLabel("Balance is Rs : " +  balance);
         text.setForeground(Color.WHITE);
         text.setBounds(120, 475, 900, 30);
         text.setFont(new Font("Railway",Font.BOLD,15));
         image.add(text);
         text1.setForeground(Color.WHITE);
         text1.setBounds(120, 500, 900, 30);
         text1.setFont(new Font("Railway",Font.BOLD,15));
         image.add(text1);

         try {
            String url = "select formno from login where cardnumber = '"+ card + "' and pin = '"+ pin +"' ";
            ResultSet rs1 =  c.s.executeQuery(url);

            if(rs1.next()){
                String name1 = rs1.getString("formno");
                System.out.println(name1);

            try {
                String url1 = "select email from signup where formno = '" + name1 + "'";
                ResultSet rs2 =  c.s.executeQuery(url1);
    
                if(rs2.next()){
                           String email = rs2.getString("email");
                           System.out.println(email);
                           setVisible(false);
                     new cbemail(card,"",email,"","","","",balance).setVisible(true);
                           
                   }
            } catch (Exception ea) {
                System.out.println(ea);
            }
            
            }
            } catch (Exception ea) {
                System.out.println(ea);
            }

        

        setSize(680, 680);
        setLocation(360, 20);
        setLayout(null);
        setTitle("Check Balance");
        setUndecorated(true);
        // this method is used to delete unused frame on upper-side on java frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new chbalance("","","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Transaction("", "", card, pin, name2).setVisible(true);;
        
    }
}
