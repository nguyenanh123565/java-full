package learn.compose;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCountRepository {
    private final JdbcTemplate jdbc;

    public ProductCountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public long count() {
        // Fixed SQL: there is no client input to concatenate into this query.
        return jdbc.queryForObject("SELECT COUNT(*) FROM products", Long.class);
    }
}
