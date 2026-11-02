import java.sql.*;
public class StatementDemo {
    public static void main(String[] args) throws SQLException {
        // Fixed SQL only. Never concatenate user input here.
        try (Connection c = JdbcSupport.open(); Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT current_database() AS db")) {
            if (rs.next()) System.out.println(rs.getString("db"));
        }
    }
}
