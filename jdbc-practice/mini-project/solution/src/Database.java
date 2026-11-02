import java.sql.*;
public final class Database {
    private Database() { }
    public static Connection open() throws SQLException {
        return DriverManager.getConnection(required("JDBC_URL"), required("JDBC_USER"), required("JDBC_PASSWORD"));
    }
    private static String required(String key) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) throw new IllegalStateException("Missing environment variable: " + key);
        return value;
    }
}
