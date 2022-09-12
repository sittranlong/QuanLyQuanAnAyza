/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Models.BillDetail;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sangtm
 */
public class BillDetailDAO {

    public static ArrayList<BillDetail> getList(int id) {
        try {
            ArrayList<BillDetail> list = new ArrayList<>();
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM dbo.BILLDETAIL WHERE Id_bill = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BillDetail(rs.getInt(1), rs.getInt(5), rs.getInt(6), rs.getInt(2), rs.getDouble(3)));
            }

            conn.close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertBD(int soluong, double dongia, double tongtien, int id_bill, int id_product) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "INSERT INTO dbo.BILLDETAIL VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, soluong);
            ps.setDouble(2, dongia);
            ps.setDouble(3, tongtien);
            ps.setInt(4, id_bill);
            ps.setInt(5, id_product);

            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ArrayList<BillDetail> list = getList(2);
        System.out.println(list.get(0).toString());

    }
}
