package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
    
    private String AdminID;
    private String Name;
    private String Password;
    
    public Admin(String AID, String NM, String PW){
        AdminID = AID;
        Name = NM;
        Password = PW;
    }
    
    public Admin(String AID){
        AdminID = AID;
    }
    
    public boolean login() {
        boolean done = false;
        try {
            DBConnection ToDB = new DBConnection();
            Connection DBConn = ToDB.openConn();
            PreparedStatement Stmt = DBConn.prepareStatement("SELECT * FROM Admin WHERE AdminID = ? AND Name = ? AND Password = ?"); 
            Stmt.setString(1, AdminID);
            Stmt.setString(2, Name);
            Stmt.setString(3, Password);          
            ResultSet Rslt = Stmt.executeQuery();
            done = Rslt.next();//If there is a row, admin information is correct
            Stmt.close();
            ToDB.closeConn();
        } catch (java.sql.SQLException e) {
            done = false;
            System.out.println("SQLException: " + e);
            while (e != null) {
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Vendor: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        } catch (java.lang.Exception e) {
            done = false;
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
        return done;
    }
    
        public boolean VerifyCustomerInfo(String CID, String UName) {
        boolean done = false;
        try {
            DBConnection ToDB = new DBConnection();
            Connection DBConn = ToDB.openConn();
            PreparedStatement Stmt = DBConn.prepareStatement("SELECT * FROM Account WHERE CustomerID = ? AND Username = ?"); 
            Stmt.setString(1, CID);
            Stmt.setString(2, UName);
            ResultSet Rslt = Stmt.executeQuery();
            done = Rslt.next();//If there is a row, then the customer gave us the correct information
            Stmt.close();
            ToDB.closeConn();
        } catch (java.sql.SQLException e) {
            done = false;
            System.out.println("SQLException: " + e);
            while (e != null) {
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Vendor: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        } catch (java.lang.Exception e) {
            done = false;
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
        return done;
    }
    
}
