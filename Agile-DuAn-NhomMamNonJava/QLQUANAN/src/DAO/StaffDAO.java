/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Models.Staff;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sangtm
 */
public class StaffDAO {

    public static ArrayList<Staff> getList() {
        try {
            ArrayList<Staff> list = new ArrayList<>();
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM dbo.STAFF WHERE Trangthai = N'Đang hoạt động'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getString(7), rs.getString(8), rs.getString(6)));
            }

            conn.close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertStaff(String hoten, String sdt, int gioitinh, String diachi, String taikhoan, String matkhau) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "INSERT INTO dbo.STAFF VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hoten);
            ps.setString(2, sdt);
            ps.setInt(3, gioitinh);
            ps.setString(4, diachi);
            ps.setString(5, "Đang hoạt động");
            ps.setString(6, taikhoan);
            ps.setString(7, matkhau);

            int rs = ps.executeUpdate();
            UserDAO.insertUser(taikhoan, matkhau);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateStaff(int id, String hoten, String sdt, int gioitinh, String diachi, String matkhau) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE dbo.STAFF SET Hoten = ?, Sdt = ?, Gioitinh = ?, Diachi = ?, Matkhau = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hoten);
            ps.setString(2, sdt);
            ps.setInt(3, gioitinh);
            ps.setString(4, diachi);
            ps.setString(5, matkhau);
            ps.setInt(6, id);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteStaff(int id) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "UPDATE dbo.STAFF SET Trangthai = N'Không hoạt động' WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
