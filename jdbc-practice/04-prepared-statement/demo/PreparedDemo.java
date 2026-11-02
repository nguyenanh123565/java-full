import java.sql.*;
public class PreparedDemo {
    public static void main(String[] args) throws SQLException {
        String name = args.length == 0 ? "O'Reilly" : args[0];
        try (Connection c = JdbcSupport.open();
             PreparedStatement ps = c.prepareStatement("SELECT id, name, price, stock FROM learning_jdbc.products WHERE name = ? ORDER BY id")) {
            ps.setString(1, name); // Value binding, NOT SQL string concatenation.
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) System.out.println(JdbcSupport.map(rs));
            }
        }
    }
}
