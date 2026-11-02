import java.sql.*;
import java.math.BigDecimal;
import java.util.*;

public class ProductDao {
    public Product add(String name, BigDecimal price, int stock) throws SQLException {
        try (Connection c = Database.open(); PreparedStatement ps = c.prepareStatement(
                "INSERT INTO learning_jdbc.products(name, price, stock) VALUES (?, ?, ?) RETURNING id")) {
            ps.setString(1, name); ps.setBigDecimal(2, price); ps.setInt(3, stock);
            try (ResultSet rs = ps.executeQuery()) { rs.next(); return new Product(rs.getLong("id"), name, price, stock); }
        }
    }
    public List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection c = Database.open(); PreparedStatement ps = c.prepareStatement(
                "SELECT id, name, price, stock FROM learning_jdbc.products ORDER BY id"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) products.add(map(rs));
        }
        return products;
    }
    public Optional<Product> find(long id) throws SQLException {
        try (Connection c = Database.open(); PreparedStatement ps = c.prepareStatement(
                "SELECT id, name, price, stock FROM learning_jdbc.products WHERE id = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? Optional.of(map(rs)) : Optional.empty(); }
        }
    }
    public boolean update(long id, String name, BigDecimal price, int stock) throws SQLException {
        try (Connection c = Database.open(); PreparedStatement ps = c.prepareStatement(
                "UPDATE learning_jdbc.products SET name = ?, price = ?, stock = ? WHERE id = ?")) {
            ps.setString(1, name); ps.setBigDecimal(2, price); ps.setInt(3, stock); ps.setLong(4, id);
            return ps.executeUpdate() == 1;
        }
    }
    public boolean delete(long id) throws SQLException {
        try (Connection c = Database.open(); PreparedStatement ps = c.prepareStatement(
                "DELETE FROM learning_jdbc.products WHERE id = ?")) {
            ps.setLong(1, id); return ps.executeUpdate() == 1;
        }
    }
    private Product map(ResultSet rs) throws SQLException {
        return new Product(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price"), rs.getInt("stock"));
    }
}
