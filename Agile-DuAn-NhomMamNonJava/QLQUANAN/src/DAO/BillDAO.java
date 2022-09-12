/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Models.Bill;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


/**
 *
 * @author sangtm
 */
public class BillDAO {

    public static ArrayList<Bill> getList() {
        try {
            ArrayList<Bill> list = new ArrayList<>();
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM dbo.BILL";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Bill(rs.getInt(1), rs.getInt(5), rs.getInt(4), rs.getDate(2), rs.getDouble(3)));
            }

            conn.close();
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static void insertBill(double thanhtoan, int id_staff, int id_cus) {
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Connection conn = DatabaseHelper.getConnection();
            String sql = "INSERT INTO BILL VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, sqlDate);
            ps.setDouble(2, thanhtoan);
            ps.setInt(3, id_staff);
            ps.setInt(4, id_cus);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
