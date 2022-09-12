/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sangtm
 */
public class UserDAO {

    public static void changePass(String user, String pass) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE dbo.[USER] SET Password = ? WHERE Username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pass);
            ps.setString(2, user);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<User> getList() {
        try {
            ArrayList<User> list = new ArrayList<>();
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM [USER]";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

            conn.close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertUser(String user, String pass) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "INSERT INTO [USER] VALUES ( ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, "user");

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
   public static void deleteUser(String user) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "DELETE FROM [dbo].[USER] WHERE Username = ? AND Role != 'admin'";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ArrayList<User> list = getList();
        for (User l : list) {
            System.out.println(l.toString());
        }
    }
}
