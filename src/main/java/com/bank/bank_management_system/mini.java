package com.bank.bank_management_system;
import javax.swing.*;

// import javafx.print.PrinterJob;

// import javafx.print.*;

import java.awt.*;
import java.awt.print.*;
import java.sql.ResultSet;
import java.awt.event.*;
public class mini extends JFrame implements ActionListener, Printable{
    String card,pin,name2;
    JButton print;
    mini(String card, String pin,String name2){
        this.card=card;
        this.pin=pin;
        this.name2=name2;
        
        setTitle("Mini Statement");
        setLayout(null);
        JLabel text = new JLabel();
        add(text);
        JLabel bank = new JLabel("Uk Bank of India");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel name = new JLabel("Account Holder Name : " +name2);
        name.setBounds(20, 50, 500, 20);
        name.setFont(new Font("Railway",Font.BOLD,16));
        add(name);

        JLabel mini = new JLabel();
        add(mini);
        // creating label for displaying last five statement
        // eq no 1.................
        // JLabel bank = new JLabel();
        // bank.setBounde();
        // add(bank);
        // try {
        //     conn conn = new conn();
        //     ResultSet rs = conn.s.executeQuery("select * from login where pin ='"+ pin +"' ");

        //     while (rs.next()) {
        //        bank.setText("Card Number :" + rs.getString("cardnumber").substring(0,4) + "XXXXXXXXXXX")
        //      output will be Card Number : 2423XXXXXXXXXX
        //     }
        // } catch (Exception e) {
           
        // }
            

            // conn conn = new conn();
			// try {
            //     String url = "select cardnumber from login where cardnumber = '"+ card + "' and pin = '"+ pin +"' ";
            //     ResultSet rs1 =  conn.s.executeQuery(url);
    
            //     if(rs1.next()){
            //         String name1 = rs1.getString("cardnumber");
            //         System.out.println(name1);
            //     }

            // }


        // 2nd method
        String card1 = card;
        String firsttenchar = card1.substring(4,12);
        String newstr = card1.replaceFirst(firsttenchar, "XXXXXXXX");
        // or
        // go to eq no 1
        
        JLabel cardno = new JLabel("CARD NO : " + newstr);
        cardno.setBounds(20, 90, 300,20);
        cardno.setFont(new Font("Railway",Font.BOLD,16));
        add(cardno);
        // balance label
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        balance.setFont(new Font("Railway",Font.BOLD,16));
        add(balance); 

        // accessing all the statements from bank table
        try {   
            conn conn = new conn();
            int bal = 0;
            ResultSet rs =conn.s.executeQuery("select * from bank where pin = '" + pin + "' ");
            while (rs.next()) {
               mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  rs.getString("amount") + "<br>");
                // setText method overrides text;
                // but in this case we have to access values from bank and print it to label();
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                    System.out.println(bal);
                    
                }
                
            }
            balance.setText("Current balance is of Rs." + bal);
        } catch (Exception e) {
            // creating object of exception class.
           System.out.println(e);
        }
        mini.setFont(new Font("Railway",Font.BOLD,15));
        mini.setBounds(20, 100, 500, 300);

        // JLabel balance = new JLabel("Current Balance is of Rs." + bal);
        // balance.setBounds(100, 600, 100, 20);
        // add(balance);        
            



        // String card1 = card;
        // String firsttenchar = card1.substring(0,12);
        // String newstr = card1.replaceFirst(firsttenchar, "XXXXXXXXXXXX");
       


        print = new JButton("Print");
        print.setBounds(145, 500, 100, 30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        setSize(440,600);
        setLocation(120, 20);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new mini("","","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource() == print){
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            boolean ok = job.printDialog();
            if(ok){
                try {
                    job.print();
                    System.out.println("print successfully...");
                } catch (Exception e1) {
                    System.out.println("cannot print");
                }
            }
            
            // PageFormat pf = new PageFormat();
            // JFrame jInternalFrame2 = null;
            // Graphics Graphic = jInternalFrame2.getGraphics();
            // Graphics2D g2d = (Graphics2D)Graphic.create();
            // g2d.translate(pf.getImageableX(),pf.getImageableY());
            // print(g2d.create());

              System.out.println("print has been pressed");

            }

        }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
       
        return 0;
    }
        
    

  
}
