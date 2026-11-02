package learning.testing;
import java.math.BigDecimal;
import java.sql.DriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import static org.junit.jupiter.api.Assertions.*;

@EnabledIfEnvironmentVariable(named = "TEST_DB_URL", matches = ".+")
class JdbcIntegrationTest {
    @Test
    void numericRoundTripUsesRealPostgres() throws Exception {
        try (var c = DriverManager.getConnection(System.getenv("TEST_DB_URL"),
                System.getenv("TEST_DB_USER"), System.getenv("TEST_DB_PASSWORD"))) {
            c.setAutoCommit(false);
            try {
                try (var s = c.createStatement()) {
                    s.execute("CREATE TEMP TABLE test_price (price NUMERIC(10,2) NOT NULL) ON COMMIT DROP");
                }
                try (var s = c.prepareStatement("INSERT INTO test_price(price) VALUES (?)")) {
                    s.setBigDecimal(1, new BigDecimal("12.30"));
                    assertEquals(1, s.executeUpdate());
                }
                try (var s = c.prepareStatement("SELECT price FROM test_price"); var rs = s.executeQuery()) {
                    assertTrue(rs.next());
                    assertEquals(0, new BigDecimal("12.30").compareTo(rs.getBigDecimal("price")));
                    assertFalse(rs.next());
                }
            } finally {
                c.rollback();
            }
        }
    }
}
