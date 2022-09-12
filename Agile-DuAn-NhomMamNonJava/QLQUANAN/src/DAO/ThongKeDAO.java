/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author sangtm
 */
public class ThongKeDAO {
    public static void getThongKeThang(int nam) {
        try {
            Connection conn = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM dbo.f_thongkethang(?)";
            CallableStatement cs = conn.prepareCall(sql);
            
            cs.setInt(1, nam);
            
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {                
                System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getDouble(3));
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        getThongKeThang(2019);
    }
}
