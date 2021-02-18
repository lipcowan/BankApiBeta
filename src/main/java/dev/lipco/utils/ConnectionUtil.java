package dev.lipco.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection createConnection() {
        String details = System.getenv("CONN_DETAILS");

        try {
            return DriverManager.getConnection(details);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }
}
