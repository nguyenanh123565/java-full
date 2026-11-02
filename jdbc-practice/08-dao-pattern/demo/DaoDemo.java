import java.sql.*;
import java.util.Optional;
public class DaoDemo {
    // Caller owns the Connection. DAO closes only its own statement/result set.
    static class ProductDao {
        Optional<JdbcProduct> findById(Connection c, long id) throws SQLException {
            try (PreparedStatement ps = c.prepareStatement("SELECT id, name, price, stock FROM learning_jdbc.products WHERE id = ?")) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next() ? Optional.of(JdbcSupport.map(rs)) : Optional.empty();
                }
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        long id = args.length == 0 ? 1 : Long.parseLong(args[0]);
        try (Connection c = JdbcSupport.open()) {
            System.out.println(new ProductDao().findById(c, id));
        }
    }
}
