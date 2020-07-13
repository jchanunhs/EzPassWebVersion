package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
            Statement Stmt = DBConn.createStatement();
            String SQL_Command = "SELECT * FROM Admin WHERE AdminID ='" + AdminID + "' AND Name = '" + Name + "' AND Password ='" + Password + "'"; //SQL query command
            ResultSet Rslt = Stmt.executeQuery(SQL_Command);
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
            Statement Stmt = DBConn.createStatement();
            String SQL_Command = "SELECT * FROM Account WHERE CustomerID ='" + CID + "' AND Username = '" + UName + "'"; //SQL query command
            ResultSet Rslt = Stmt.executeQuery(SQL_Command);
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
    
}
