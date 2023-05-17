/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBConnect;

/**
 *
 * @author Admin
 */
public class DAOUsers extends DBConnect{
    public List<Users> getAllUser() {
        String sql = "select * from account";
        List<Users> list = new ArrayList<>();
        String account, password, email;
        int accountID, roleID;
        try {
            Statement state = conn.createStatement();
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                accountID = rs.getInt("accountID");
                account = rs.getString("account");
                password = rs.getString("password");
                email = rs.getString("email");
                roleID = rs.getInt("");
                list.add(new Users(accountID, account, password,email, roleID));
            }
            rs.close();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Users getUser(String password, String account) {
        String sql = "select * from account where password = ? and account = ?";
        Users nu = null;
        int accountID = 0;
        int roleID;
        String email;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre = conn.prepareStatement(sql);
            pre.setString(1, password);
            pre.setString(2, account);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                roleID = rs.getInt("roleID");
                email = rs.getString("email");
                nu = new Users(accountID, account, password,email, roleID);
            }
            rs.close();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nu;
    }
    
     //Kiểm tra xem Email đã tồn tại
    public Users getUserByEmail(String email) {
        String sql = "select * from account where email = ?";
        Users nu = null;
        int roleID, accountID = 0;
        String account, password;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email.trim());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                account = rs.getString("account");
                password = rs.getString("password");
                roleID = rs.getInt("roleID");
                nu = new Users(accountID, account, password,email, roleID);
            }
            rs.close();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nu;
    }
    
    
    // Kiểm tra xem username đã tồn tại
    public Users getUser(String account) {
        String sql = "select * from account where account = ?";
        Users nu = null;
        int roleID, accountID = 0;
        String email, password;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, account);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                roleID = rs.getInt("roleID");
                email = rs.getString("email");
                password = rs.getString("password");
              nu = new Users(accountID, account, password,email, roleID);
            }
            rs.close();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nu;
    }
    
        public void insert(String password, String account, String email) {
//        String sql = "INSERT INTO Users\n"
//                + "           ,[name]\n"
//                + "           ,[email])\n"
//                + "           ,[password])\n"
//                + "           ,[role])\n"
//                + "     VALUES(?,?,?,?)";
        String sql = "insert into account (account, password,email, roleID) values (?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, account);
            pre.setString(2, password);
            pre.setString(3, email);
            pre.setInt(4, 1);
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
