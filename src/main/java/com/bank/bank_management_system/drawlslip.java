package com.bank.bank_management_system;
import javax.swing.*;

// import javafx.print.PrinterJob;

// import javafx.print.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
// import java.awt.print.*;
// import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.*;
public class drawlslip extends JFrame implements ActionListener{
    String card,pin,email,name2,account,number;
    JButton print;
    static int balance;
    drawlslip(String card, String pin,String email,String name2,String account,String number,int balance){
        this.pin=pin;
        this.card=card;
        this.name2=name2;
        this.account=account;
       this.balance=balance;
        this.number=number;
        this.email=email;
        
        setTitle("Transaction Details");
       
        JLabel bank = new JLabel("Welcome to Uk Bank of India");
        JLabel bank1 = new JLabel("---------------------------------------------");
        JLabel bank2 = new JLabel("---------------------------------------------");
        bank.setBounds(70, 45, 900, 20);
        bank.setFont(new Font("Railway",Font.BOLD,16));
        bank1.setFont(new Font("Railway",Font.BOLD,22));
        bank2.setFont(new Font("Railway",Font.BOLD,22));
        bank1.setBounds(30, 30, 350, 20);
        bank2.setBounds(30, 60, 350, 20);
        add(bank);
        add(bank1);
        add(bank2);

        Random random = new Random();
        String txnno = "" + Math.abs((random.nextLong() % 900000L) + 100000L) ;
        System.out.println(txnno);

        // date
        JLabel date2 = new JLabel("DATE");
        JLabel time = new JLabel("TIME");
        date2.setBounds(30, 90, 300, 30);
        time.setBounds(150, 90, 300, 30);
        date2.setFont(new Font("Railway",Font.BOLD,16));
        time.setFont(new Font("Railway",Font.BOLD,16));
        add(date2);
        add(time);
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy          HH:mm:ss");
        Date date = new Date();
        JLabel date1 = new JLabel(df.format(date));
        date1.setBounds(30, 110, 300, 30);
        date1.setFont(new Font("Railway",Font.BOLD,16));
        add(date1);



        JLabel atmno = new JLabel("ATM ID");
        JLabel atmno1 = new JLabel("ATM41410");
        atmno.setBounds(250, 90, 300,30);
        atmno1.setBounds(250, 110, 300,30);
        atmno.setFont(new Font("Railway",Font.BOLD,16));
        atmno1.setFont(new Font("Railway",Font.BOLD,16));
        add(atmno);
        add(atmno1);

        JLabel cwt = new JLabel("CASH WITHDRAWL TRANSACTION");
        cwt.setBounds(30, 150, 300,30);
        cwt.setFont(new Font("Railway",Font.BOLD,16));
        add(cwt);

        String card1 = card;
        String firsttenchar = card1.substring(0,12);
        String newstr = card1.replaceFirst(firsttenchar, "XXXXXXXXXXXX");
        
        JLabel cardno = new JLabel("CARD NO :" + newstr);
        cardno.setBounds(30, 230, 300,30);
        cardno.setFont(new Font("Railway",Font.BOLD,16));
        add(cardno);

        String account2 = account;
        String firsteightchar = account2.substring(0,8);
        String newstr1 = account2.replaceFirst(firsteightchar, "XXXXXXXX");
        
        JLabel accntno = new JLabel("ACCT NO :" + newstr1);
        accntno.setBounds(30, 210, 300,30);
        accntno.setFont(new Font("Railway",Font.BOLD,16));
        add(accntno);
        

        JLabel txn = new JLabel("TXN NO :" + txnno);
        txn.setBounds(30, 190, 300,30);
        txn.setFont(new Font("Railway",Font.BOLD,16));
        add(txn);

        JLabel aw = new JLabel("AMOUNT WITHDRAWN : " +number);
        aw.setBounds(30, 270, 300,30);
        aw.setFont(new Font("Railway",Font.BOLD,16));
        add(aw);
        // available balance
        JLabel available = new JLabel("AVAIL BAL: " + balance);
        available.setBounds(30, 310, 300,30);
        available.setFont(new Font("Railway",Font.BOLD,16));
        add(available);
        // ledger balance
        JLabel ledger = new JLabel("LEDGER BAL : " + balance);
        ledger.setBounds(30, 330, 300,30);
        ledger.setFont(new Font("Railway",Font.BOLD,16));
        add(ledger);
        // response
        JLabel res = new JLabel("RESPONSE : 00");
        res.setBounds(30, 350, 300,30);
        res.setFont(new Font("Railway",Font.BOLD,16));
        add(res);

        // desc
        JLabel desc = new JLabel("DESC : SUCCESSFUL");
        desc.setBounds(30, 370, 300,30);
        desc.setFont(new Font("Railway",Font.BOLD,16));
        add(desc);

        JLabel tk = new JLabel("THANKYOU FOR BANKING WITH US");
        tk.setBounds(30, 410, 300,30);
        tk.setFont(new Font("Railway",Font.BOLD,16));
        add(tk);


        print = new JButton("Print");
        print.setBounds(125, 500, 100, 30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        
        setSize(400,600);
        setLocation(120, 20);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
   

 public static void main(String[] args) {
       
        new drawlslip("","","","","","", balance);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(e.getSource() == print){
         
            // String atmno1 = "ATM41410";
            // String txnno1 = txnno.
            // PrinterJob job = PrinterJob.getPrinterJob();
            // job.setPrintable(this);
            // boolean ok = job.printDialog();
            // if(ok){
            //     try {
            //         job.print();
            //         System.out.println("print successfully...");
            //     } catch (Exception e1) {
            //         System.out.println(e1);
            //     }
            // }
            
            // // PageFormat pf = new PageFormat();
            // // JFrame jInternalFrame2 = null;
            // // Graphics Graphic = jInternalFrame2.getGraphics();
            // // Graphics2D g2d = (Graphics2D)Graphic.create();
            // // g2d.translate(pf.getImageableX(),pf.getImageableY());
            // // print(g2d.create());
          
        System.out.println("print has been pressed");
        JOptionPane.showMessageDialog(null, "Click print to send");
       
        conn conn = new conn();
        try {
        String query = "Insert into withdrawl(atmid,accountno,cardnumber,pin,withdrawl_amount,balance_amount,status)values('ATM41410','"+ account +"','"+ card + "','" + pin +"','" + number +"','" + balance+"','SUCCESS')";
        conn.s.executeUpdate(query);
        setVisible(false);
        new Transaction("", "", card, pin, name2).setVisible(true);

        } catch (Exception e1) {
           System.out.println(e1);
        }
            //   new slipemail(card,pin,email,number,"","",name2,balance,atmno1,account,txnno);
            //   setVisible(false);

            //   new Transaction("", "", card, "", name2).setVisible(true);

            }

        }

    // @Override
    // public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
       
    //     return 0;
    // }
        
    

  
}


