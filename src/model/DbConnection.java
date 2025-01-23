package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DbConnection {

    private static Connection conn = null;

    // Define JDBC driver
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    // Database credentials
    private static final String DB_USER_NAME = "root";
    private static final String DB_PASSWORD = "root123";

    // Database details
    private static final String DB_NAME = "payroll";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";

    public static Connection getDbConnection() {
        try {
            // Load MySQL JDBC Driver
            Class.forName(JDBC_DRIVER);

            // Establish Connection
            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            System.out.println("Database Connected Successfully!");
            return conn;

        } catch (ClassNotFoundException ex1) {
            JOptionPane.showMessageDialog(null, "Error! MySQL Driver Not Found!\n\n" + ex1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;

        } catch (SQLException ex2) {
            JOptionPane.showMessageDialog(null, "Error! Database Connection Failed!\n\n" + ex2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;

        } catch (Exception ex3) {
            JOptionPane.showMessageDialog(null, "Unexpected Error!\n\n" + ex3.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
