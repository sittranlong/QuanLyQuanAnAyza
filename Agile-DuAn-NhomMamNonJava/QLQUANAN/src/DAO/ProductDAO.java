/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Models.Product;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sangtm
 */
public class ProductDAO {

    public static ArrayList<Product> getList() {
        try {
            ArrayList<Product> list = new ArrayList<>();
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM dbo.PRODUCT WHERE Trangthai = N'Đang hoạt động'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }

            conn.close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertProduct(int id_category, String tenmonan, double dongia, String gioithieu, String anh) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "INSERT INTO dbo.PRODUCT VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id_category);
            ps.setString(2, tenmonan);
            ps.setDouble(3, dongia);
            ps.setString(4, gioithieu);
            ps.setString(5, anh);
            ps.setString(6, "Đang hoạt động");

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateProduct(int id, int id_category, String tenmonan, double dongia, String gioithieu, String anh, String trangthai) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE dbo.PRODUCT SET Id_category = ?, Tenmonan = ?, Dongia = ?, Gioithieu = ?, Anh = ?, Trangthai = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id_category);
            ps.setString(2, tenmonan);
            ps.setDouble(3, dongia);
            ps.setString(4, gioithieu);
            ps.setString(5, anh);
            ps.setString(6, trangthai);
            ps.setInt(7, id);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void deleteProduct(int id) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE dbo.PRODUCT SET Trangthai = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, "Không hoạt động");
            ps.setInt(2, id);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
