import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class JdbcSupport {
    private JdbcSupport() { }

    public static Connection open() throws SQLException {
        return DriverManager.getConnection(required("JDBC_URL"), required("JDBC_USER"), required("JDBC_PASSWORD"));
    }

    private static String required(String key) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) throw new IllegalStateException("Missing environment variable: " + key);
        return value;
    }

    public static JdbcProduct map(ResultSet rs) throws SQLException {
        return new JdbcProduct(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price"), rs.getInt("stock"));
    }
}
