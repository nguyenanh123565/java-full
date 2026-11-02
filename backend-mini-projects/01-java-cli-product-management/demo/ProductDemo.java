import java.math.BigDecimal;
import java.util.LinkedHashMap;

public class ProductDemo {
    record Product(long id, String name, BigDecimal price) {}
    public static void main(String[] args) {
        var products = new LinkedHashMap<Long, Product>();
        products.put(1L, new Product(1L, "Book", new BigDecimal("12.50")));
        System.out.println(products.get(1L));
        System.out.println(products.size());
        products.remove(1L);
        System.out.println(products.size());
    }
}
