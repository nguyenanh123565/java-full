import java.sql.*;
public class ConnectionDemo {
    public static void main(String[] args) throws SQLException {
        try (Connection c = JdbcSupport.open()) {
            System.out.println("Valid: " + c.isValid(2));
            System.out.println("Auto commit: " + c.getAutoCommit());
        }
    }
}
