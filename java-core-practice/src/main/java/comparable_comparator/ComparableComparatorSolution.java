package comparable_comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableComparatorSolution {
    public static final class Product implements Comparable<Product> {
        private final String id;
        private final long price;
        public Product(String id, long price) { this.id = id; this.price = price; }
        public String getId() { return id; }
        public long getPrice() { return price; }
        @Override public int compareTo(Product other) { return id.compareTo(other.id); }
        @Override public String toString() { return id + "=" + price; }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product("P03", 10), new Product("P01", 20), new Product("P02", 20)));
        // Bài 1: thứ tự tự nhiên là id.
        products.sort(Comparator.naturalOrder());
        System.out.println(products);
        // Bài 2: comparingLong tránh phép trừ có thể tràn.
        Comparator<Product> byPrice = Comparator.comparingLong(Product::getPrice);
        products.sort(byPrice.thenComparing(Product::getId));
        System.out.println(products);
        // Bài 3: đảo tiêu chí giá trước khi thêm tie-break id.
        products.sort(byPrice.reversed().thenComparing(Product::getId));
        System.out.println(products);
    }
}
