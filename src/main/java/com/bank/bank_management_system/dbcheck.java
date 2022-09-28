package com.bank.bank_management_system;

import java.sql.ResultSet;

public class dbcheck {

    dbcheck(){
        try {
            conn conn = new conn();
            String url = "select formno from login where pin = 2002";
            // String url1 = "select name from signup where formno = '" + url +"'";
            ResultSet rs =  conn.s.executeQuery(url);
            // ResultSet rs1 =  conn.s.executeQuery(url1);
            if(rs.next()){
                String form = rs.getString("formno");
                System.out.println(form);
               

            

            String url1 = "select name from signup where formno = '" + form + "'";
            ResultSet rs1 =  conn.s.executeQuery(url1);

            if(rs1.next()){
                   String form1 = rs1.getString("name");
   
                  
                   System.out.println(form1);
               }
            }
            
        

        } catch (Exception e) {
           
        }
    }

    public static void main(String[] args) {
        new dbcheck();
    }
}
