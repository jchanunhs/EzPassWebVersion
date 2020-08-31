package com.example.service;

import com.example.dao.AdminDAO;
import com.example.model.Account;
import com.example.model.Admin;
import com.example.model.EzTag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminService implements AdminDAO{

    public AdminService() {

    }

    @Override
    public boolean login(Admin admin) {
        boolean done = false;
        try {
            DBConnection ToDB = new DBConnection();
            Connection DBConn = ToDB.openConn();
            PreparedStatement Stmt = DBConn.prepareStatement("SELECT * FROM Admin WHERE AdminID = ? AND Name = ? AND Password = ?");
            Stmt.setString(1, admin.getAdminID());
            Stmt.setString(2, admin.getName());
            Stmt.setString(3, admin.getPassword());
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

    @Override
    public boolean VerifyCustomerInfo(Account account) {
        boolean done = false;
        try {
            DBConnection ToDB = new DBConnection();
            Connection DBConn = ToDB.openConn();
            PreparedStatement Stmt = DBConn.prepareStatement("SELECT * FROM Account WHERE CustomerID = ? AND Username = ?");
            Stmt.setString(1, account.getCustomerID());
            Stmt.setString(2, account.getUsername());
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
    
    //check whether tag code belongs to customer regardless if it's invalid
    @Override
    public boolean checkCustomerTag(EzTag eztag) {
        boolean done = false;
        try {
            DBConnection ToDB = new DBConnection();
            Connection DBConn = ToDB.openConn();
            PreparedStatement Stmt = DBConn.prepareStatement("SELECT * FROM EzTag WHERE CustomerID = ? AND TagCode = ?");
            Stmt.setString(1, eztag.getCustomerID());
            Stmt.setString(2, eztag.getTagCode());
            ResultSet Rslt = Stmt.executeQuery(); //if there is a row, that means tag code and customer id are a match
            done = Rslt.next();
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
        }
        return done;
    }

}
