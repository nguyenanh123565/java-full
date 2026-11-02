import java.math.BigDecimal;
import java.sql.*;
public class TransactionDemo {
    public static void main(String[] args) throws SQLException {
        long id = -1;
        try (Connection c = JdbcSupport.open()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("INSERT INTO learning_jdbc.products(name, price, stock) VALUES (?, ?, ?) RETURNING id")) {
                    ps.setString(1, "Rollback demo"); ps.setBigDecimal(2, new BigDecimal("20.00")); ps.setInt(3, 1);
                    try (ResultSet rs = ps.executeQuery()) { rs.next(); id = rs.getLong("id"); }
                }
                try (PreparedStatement ps = c.prepareStatement("INSERT INTO learning_jdbc.stock_movements(product_id, quantity) VALUES (?, ?)")) {
                    ps.setLong(1, id); ps.setInt(2, 1); ps.executeUpdate();
                }
                // Switch to the explicit argument "commit" only in your NEW learning DB.
                if (args.length == 0 || !args[0].equals("commit")) throw new SQLException("Intentional demo failure");
                c.commit();
                System.out.println("Committed id " + id);
            } catch (SQLException | RuntimeException failure) {
                try { c.rollback(); } catch (SQLException rollbackFailure) { failure.addSuppressed(rollbackFailure); throw failure; }
                System.out.println("Rolled back transaction; SQLState=" + (failure instanceof SQLException sql ? sql.getSQLState() : "n/a"));
            }
            try (PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM learning_jdbc.products WHERE id = ?")) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); System.out.println("Remaining rows for id: " + rs.getInt(1)); }
            }
            c.rollback(); // End the read transaction explicitly before closing.
        }
    }
}
