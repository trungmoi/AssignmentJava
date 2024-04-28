/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASMGD2;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mxtru
 */
public class DB_Connect {
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "ASMGĐ2Java";
    private static final boolean USING_SSL = true;
   
    private static String CONNECT_STRING;
   
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           
            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";")
                    ;
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(DB_Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static Connection getConnection()  {
         try {
             return DriverManager.getConnection(CONNECT_STRING);
         } catch (SQLException ex) {
             ex.printStackTrace();
             Logger.getLogger(DB_Connect.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
   
    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();
        DatabaseMetaData dbmt = conn.getMetaData();
        System.out.println(dbmt.getDriverName());
        System.out.println(dbmt.getDatabaseProductName());
        System.out.println(dbmt.getDatabaseProductVersion());
}
}
