import java.sql.*;
import java.util.*;
public class ResultSetDemo {
    public static void main(String[] args) throws SQLException {
        List<JdbcProduct> products = new ArrayList<>();
        try (Connection c = JdbcSupport.open();
             PreparedStatement ps = c.prepareStatement("SELECT id, name, price, stock FROM learning_jdbc.products ORDER BY id");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) products.add(JdbcSupport.map(rs));
        }
        products.forEach(System.out::println); // Objects survive after JDBC resources close.
        System.out.println("Count: " + products.size());
    }
}
