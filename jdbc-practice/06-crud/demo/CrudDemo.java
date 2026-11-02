import java.math.BigDecimal;
import java.sql.*;
public class CrudDemo {
    public static void main(String[] args) throws SQLException {
        try (Connection c = JdbcSupport.open()) {
            long id;
            try (PreparedStatement ps = c.prepareStatement("INSERT INTO learning_jdbc.products(name, price, stock) VALUES (?, ?, ?) RETURNING id")) {
                ps.setString(1, "CRUD demo"); ps.setBigDecimal(2, new BigDecimal("100.00")); ps.setInt(3, 2);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); id = rs.getLong("id"); }
            }
            try (PreparedStatement ps = c.prepareStatement("UPDATE learning_jdbc.products SET price = ? WHERE id = ?")) {
                ps.setBigDecimal(1, new BigDecimal("120.00")); ps.setLong(2, id);
                System.out.println("Updated: " + ps.executeUpdate());
            }
            try (PreparedStatement ps = c.prepareStatement("SELECT id, name, price, stock FROM learning_jdbc.products WHERE id = ?")) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) { if (rs.next()) System.out.println(JdbcSupport.map(rs)); }
            }
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM learning_jdbc.products WHERE id = ?")) {
                ps.setLong(1, id); System.out.println("Deleted: " + ps.executeUpdate());
            }
        }
        // Auto-commit demo: a failure halfway can leave the new row behind. See lesson 07.
    }
}
