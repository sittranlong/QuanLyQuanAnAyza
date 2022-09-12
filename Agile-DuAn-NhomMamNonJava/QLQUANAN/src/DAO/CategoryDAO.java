/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Models.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sangtm
 */
public class CategoryDAO {

    public static ArrayList<Category> getList() {
        try {
            ArrayList<Category> list = new ArrayList<>();
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM dbo.CATEGORY WHERE Trangthai = N'Đang hoạt động'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

            conn.close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertCategory(String tendanhmuc) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "INSERT INTO CATEGORY VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, tendanhmuc);
            ps.setString(2, "Đang hoạt động");

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void updateCategory(int id, String tendanhmuc, String trangthai) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE dbo.CATEGORY SET Tendanhmuc = ?, Trangthai = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, tendanhmuc);
            ps.setString(2, trangthai);
            ps.setInt(3, id);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void deleteCategory(int id, String trangthai) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE dbo.CATEGORY SET Trangthai = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, trangthai);
            ps.setInt(2, id);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
