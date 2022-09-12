/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Models.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sangtm
 */
public class CustomerDAO {

    public static ArrayList<Customer> getList() {
        try {
            ArrayList<Customer> list = new ArrayList<>();
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM dbo.CUSTOMER WHERE Trangthai = N'Đang hoạt động'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Customer(rs.getInt("Id"), rs.getString("Hoten"), rs.getString("Sdt"), rs.getInt("Gioitinh"), rs.getString("Diachi"), rs.getString("Trangthai")));
            }

            conn.close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertCustomer(String hoten, String sdt, int gioitinh, String diachi) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, N'Đang hoạt động');";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hoten);
            ps.setString(2, sdt);
            ps.setInt(3, gioitinh);
            ps.setString(4, diachi);

            int rs = ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateCustomer(String hoten, String sdt, int gioitinh, String diachi, String trangthai, int id) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE dbo.CUSTOMER SET Hoten = ?, Sdt = ?, Gioitinh = ?, Diachi = ?, Trangthai = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hoten);
            ps.setString(2, sdt);
            ps.setInt(3, gioitinh);
            ps.setString(4, diachi);
            ps.setString(5, trangthai);
            ps.setInt(6, id);

            int rs = ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
