package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
    private static final String HOST = System.getenv("DB_HOST");
    private final static String PORT = System.getenv("DB_PORT");
    private final static String USER = System.getenv("DB_USER");
    private final static String PASSWORD = System.getenv("DB_PASSWORD");
    private final static String DB_NAME = System.getenv("DB_NAME");

    private final static String DB_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;

    private final static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    DB_URL,
                    USER,
                    PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
