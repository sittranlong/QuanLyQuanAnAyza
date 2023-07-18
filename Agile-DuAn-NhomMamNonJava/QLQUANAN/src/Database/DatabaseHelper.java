/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author sangtm
 */
public class DatabaseHelper {

    private static String user = "sa";
    private static String pass = "123456";
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=QLQUANAN";

    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }
}
