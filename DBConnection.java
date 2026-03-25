package com.karthik.event;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/event_db",
                "root",
                "9481566730"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}