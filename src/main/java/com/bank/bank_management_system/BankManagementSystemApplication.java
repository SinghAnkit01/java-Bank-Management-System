package com.bank.bank_management_system;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
// import java.sql.*;

// import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// // import org.springframework.http.HttpMethod;
// // import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;


// import javafx.scene.image.Image;

@SpringBootApplication
// @RestController
// @RequestMapping(value = "/uklogin")

public class BankManagementSystemApplication extends JFrame implements ActionListener {
	JButton login,login1,login2;
    JTextField textfield;
    JPasswordField textfield1;
	String formno,name;
	BankManagementSystemApplication(){
			// use to set title of frame
			setTitle("Automatic Teller Machine");
			setLayout(null);
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("static/atm-icon.jpg"));
			// to change image width and height
			Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			// convert Image into ImageIcon;
			ImageIcon i3 = new ImageIcon(i2);
			// we cant place icon directly onto JFrame if we have to place we have to use JLabel;
			// awt package contains image class.
			JLabel label = new JLabel(i3);
			// if you want to add any component into jrame use add function and pass variable into it.
			label.setBounds(70, 10,100, 100);
			//  using custom layout but bydefault property is centered to change bydefault property
			// setLayout(null);
			add(label);
			// we can write text on frame using JLabel class.
			JLabel text = new JLabel("Welcome to ATM");
			text.setFont(new Font("Oswald",Font.BOLD,38));
			text.setBounds(200, 40, 400, 40);
			add(text);
	
			// label for card-number
			JLabel card = new JLabel("Card No.");
			card.setFont(new Font("Railway",Font.BOLD,28));
			card.setBounds(120, 150, 150, 40);
			add(card);
			// creating textboxes
			textfield = new JTextField();
			textfield.setBounds(270, 160, 230, 30);
			textfield.setFont(new Font("Arial",Font.BOLD,14));
			add(textfield);
		
	
			// label for pin
			JLabel pin = new JLabel("PIN");
			pin.setFont(new Font("Oswald",Font.BOLD,28));
			pin.setBounds(120, 220, 400, 40);
			add(pin);
			// creating textboxes
			 textfield1 = new JPasswordField();
			textfield1.setBounds(270, 220, 230, 30);
			textfield.setFont(new Font("Arial",Font.BOLD,14));
			add(textfield1);
	
			// Adding sign-in Button
			login = new JButton("SIGN IN");
			login.setBounds(270, 270, 100, 30);
			login.setBackground(Color.BLACK);
			// background color
			login.setForeground(Color.WHITE);
			// font color
			login.addActionListener(this);
			// this event is use to catch some events which is performing on button.
			add(login);
			// adding clear button
		   login1 = new JButton("CLEAR");
			login1.setBounds(400, 270, 100, 30);
			login1.setBackground(Color.BLACK);
			// backgroung color
			login1.setForeground(Color.WHITE);
			login1.addActionListener(this);
			// this event is use to catch some events which is performing on button.
			// font color
			add(login1);
	
			// adding sign-up button
	
			login2 = new JButton("SIGN UP");
			login2.setBounds(270, 320, 230, 30);
			login2.setBackground(Color.BLACK);
			// backgroung color
			login2.setForeground(Color.WHITE);
			login2.addActionListener(this);
			// this event is use to catch some events which is performing on button.
			// font color
			add(login2);
	
	
			// adding backgroung color
			// get full frame using-:
	
			// getContentPane().setBackground(Color.BLACK);
	
			setSize(800,480);
			// defines dimensions of frame
			// frame bydefault invisible for the user.
			// for visibility
			setUndecorated(true);
			setVisible(true);
			// bydefault frame starts from top-left although we can change the origin of frame
			setLocation(350,180);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BankManagementSystemApplication.class, args);
	
		
		System.out.println("java bank....");
		
		// login login =new login();
		// new BankManagementSystemApplication();
	}
	@Override
public void actionPerformed(ActionEvent e) {
    // if we are creating any interface in java we have to add unimplemented methods and @Override it.
    // e is the object of ActionEvent class

		
    if(e.getSource() == login){
		conn conn = new conn();
		String card = textfield.getText();
		String pin = textfield1.getText();
		String query = "select * from login where cardnumber = '"+ card + "' and pin = '"+ pin +"' ";
		
		
		// // dml query
		
		try {
		ResultSet rs =  conn.s.executeQuery(query);
		
		
		
		if(rs.next()){

			try {
			String url = "select formno from login where cardnumber = '"+ card + "' and pin = '"+ pin +"' ";
			ResultSet rs1 =  conn.s.executeQuery(url);

			if(rs1.next()){
                String name1 = rs1.getString("formno");
                System.out.println(name1);

			try {
				String url1 = "select name from signup where formno = '" + name1 + "'";
				ResultSet rs2 =  conn.s.executeQuery(url1);
	
				if(rs2.next()){
					   	String name2 = rs2.getString("name");
	   					System.out.println(name2);
						   setVisible(false);
						   new Transaction(formno,name,card,pin,name2).setVisible(true);
				   }
			} catch (Exception ea) {
				System.out.println(ea);
			}
            
			}
			} catch (Exception ea) {
				System.out.println(ea);
			}
			

			
			
		}else{
			JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
			// new BankManagementSystemApplication();
		}
       
		
			
		} catch (Exception e1) {
			System.out.println("cannot connect to a database");
		}
		

		
    }else if(e.getSource() == login1){
        textfield.setText("");
        textfield1.setText("");
    }else if(e.getSource() == login2){
        setVisible(false);
        // this will close the current form.
        // current form will be invisible.
        // start signup form.............
        new signup().setVisible(true);
        // if we want to open signup page we have to create object of that class

    }
    
}   

}
