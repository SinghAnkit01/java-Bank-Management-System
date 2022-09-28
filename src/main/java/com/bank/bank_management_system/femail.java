package com.bank.bank_management_system;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.*;

public class femail extends JFrame {
    String pin,card,email,amount,name2;
   static int balance;
    femail(String card,String pin,String email,String amount,String name2,int balance){
        this.pin = pin;
        this.card=card;
        this.email=email;
        this.amount=amount;
        this.name2=name2;
        this.balance=balance;

        String message = pin;
        String message1 = card;
        // String bank ="Bank Name: UK BANK OF INDIA";
        // String branch ="Branch Name: Vartak Nagar Thane(w)-06";

        // String message = "pinnumber";
        // String message1 = "cardnumber";

        String subject = " MONEY WITHDRAWL FROM FASTCASH MESSAGE FROM UK BANK OF INDIA";
        String to = email;
        String from = "noreplyukbank@gmail.com";

        sendEmail(message,message1,subject,to,from);
    }
    // this message is responsible to send email
    private void sendEmail(String message,String message1, String subject, String to, String from) {
        // variable for gmail host = smtp.gmail.com
        String host ="smtp.gmail.com";
        // important hostname

        // gettting system properties

       Properties properties =  System.getProperties();
       System.out.println(properties);

    //    setting important information to properties object

    // host set
        properties.put("mail.smtp.host", host);
    // api will use key as mail.smtp.host and its value as smtp.gmail.com

    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    // enabling ssl for security reason

    properties.put("mail.smtp.auth", "true");

    // step 1:to get the session object..
    Session session = Session.getInstance(properties, new Authenticator() {
        // this method will return session object
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            
           return new PasswordAuthentication("noreplyukbank@gmail.com", "xjymkibxmzyosiug");
        //    return new PasswordAuthentication("noreplyukbank@gmail.com")
        }
        // compose the message[text,attachment,multimedia];




        
        
    });
    session.setDebug(true);
    // to know if there is some error in session class

    MimeMessage m = new MimeMessage(session);
    // mimemessage is a child class of message class we can access message class directly because message class is an abstract class;
    
  

    try {
          // from email id
        m.setFrom(from);
        // adding recipient
        m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        // sending mail to single receipient
        // for multiple receipient
    //   m.addRecipients(arg0, arg1);

    // adding subject to message

    m.setSubject(" Security alerts From : " +" " +subject);

    // adding text to message
    String email = "noreplyindianrailwaysirctc@gmail.com";
    // m.setText("For more details E-Mail here :" + email);

    m.setText("Amount of Rs" + " " + amount + " has been withdrawl from fastcash to your account with" + " " + "Card-number : " + " " + message1 + "\n " + " Total balance is of Rs :" + balance + "\n" + "Note : Please Dont share this cardnumber and pinnumber to anyone regards Uk Bank policy"
        + "\n" + "Regards," + "\n" + "Uk Bank of India Team" + "\n" + "For more details E-Mail here :" + email + " \n" + "Login to view Passbook page");

    // m.setText("\n");
    // m.setText("Pin-number : " + " "+message1);
    // m.setText("Note : Please Dont share this cardnumber and pinnumber to anyone regards Uk bank policy");
    
    // m.setText("\n");

    // m.setText("Regards," + "\n" + "Uk Bank Of India Team");

    // m.setText("\n");
    


    // send 
    // step 3:send the message using transport class

    Transport.send(m);

    System.out.println("Send Successfully");
    Date date = new Date();
    conn conn = new conn();
    String query = "Insert into emailstat(pin,date,type,amount,status)values('"+pin+"','"+date+"','withdraw-FastCash','"+amount+"','success')";
    conn.s.executeUpdate(query);
    JOptionPane.showConfirmDialog(null, "Check your Gmail..");
    // new BankManagementSystemApplication();
    new Transaction("", "", card, "", name2);

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("cannot send the message");
        // to get the proper exception error with the help of e.printStackTrace.
        new BankManagementSystemApplication().setVisible(true);
    }
   









    }

    public static void main(String[] args) {
        new femail("","","","","",balance);
    }
}


