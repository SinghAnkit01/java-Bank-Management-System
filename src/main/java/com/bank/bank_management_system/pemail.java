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

public class pemail extends JFrame {
    String formno,name2,pin,card,email,account,ifsc;
    pemail(String formno,String name2,String card,String pin,String email,String account,String ifsc){
        this.pin = pin;
        this.card=card;
        this.email=email;
        this.formno=formno;
        this.name2=name2;
        this.account=account;
        this.ifsc=ifsc;

        String message = pin;
        String message1 = card;
        String message2 = account;
        String message3 = ifsc;
        String bank ="Bank Name: UK BANK OF INDIA";
        String branch ="Branch Name: Vartak Nagar Thane(w)-06";

        // String message = "pinnumber";
        // String message1 = "cardnumber";

        String subject = "PASSBOOK DETAILS FROM UK BANK OF INDIA";
        String to = email;
        String from = "noreplyukbank@gmail.com";

        sendEmail(message2,message3,message,message1,subject,to,from);
    }
    // this message is responsible to send email
    private void sendEmail(String message,String message1,String message2,String message3, String subject, String to, String from) {
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

    m.setText("Card-Number : " + " "+ message1 + "\n " +  "Pin-Number : " + " " + message + "\n" + " Account no : " + message2  + "\n" + " IFSC Code : " + message3 + "\n" +"Note : Please Dont share this cardnumber and pinnumber along with account no. and ifsc code  to anyone regards Uk Bank policy"
        + "\n" + "Regards," + "\n" + "Uk Bank of India Team" + "\n" + "For more details E-Mail here :" + email + " \n" + "Login to view Passbook page"  );

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
    JOptionPane.showConfirmDialog(null, "Check your Gmail..");
    // new BankManagementSystemApplication();
    new Transaction(formno, name2, card, pin, "");

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("cannot send the message");
        // to get the proper exception error with the help of e.printStackTrace.
        // new passbook("","","","","","","").setVisible(false);
        new BankManagementSystemApplication().setVisible(true);
    }
   









    }

    public static void main(String[] args) {
        new pemail("","","","","","","");
    }
}

