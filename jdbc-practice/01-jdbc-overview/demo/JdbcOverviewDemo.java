import java.sql.*;
public class JdbcOverviewDemo {
    public static void main(String[] args) throws SQLException {
        try (Connection c = JdbcSupport.open();
             PreparedStatement ps = c.prepareStatement("SELECT 1 AS value");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) System.out.println(rs.getInt("value"));
        }
    }
}
