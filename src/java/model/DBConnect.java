/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBConnect {
    public Connection conn=null;
   

public DBConnect(){
        try {
            //Call the driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connect
            conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuizOnline","sa","123456");
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public ResultSet getData(String sql){
         ResultSet rs=null;
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs=state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
     }
    public static void main(String[] args) {
        new DBConnect();
    }
    
    
}
