import java.sql.*;
public class ResourcesDemo {
    public static void main(String[] args) throws SQLException {
        try (Connection c = JdbcSupport.open();
             PreparedStatement ps = c.prepareStatement("SELECT 1 AS value");
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            System.out.println("Read value " + rs.getInt("value"));
            throw new IllegalStateException("Intentional failure inside resource scope");
        } catch (IllegalStateException expected) {
            System.out.println(expected.getMessage());
            System.out.println("Resource scope has ended; close() ran in reverse order.");
        }
    }
}
