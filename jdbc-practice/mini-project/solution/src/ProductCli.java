import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductCli {
    private final Scanner input;
    private final ProductDao dao = new ProductDao();
    public ProductCli(Scanner input) { this.input = input; }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) { new ProductCli(input).run(); }
    }
    private void run() {
        while (true) {
            System.out.println("add | list | find | update | delete | exit");
            if (!input.hasNextLine()) return;
            String command = input.nextLine().trim();
            try {
                switch (command) {
                    case "add" -> {
                        String name = name(); BigDecimal price = price(); int stock = stock();
                        System.out.println("Added: " + dao.add(name, price, stock));
                    }
                    case "list" -> {
                        List<Product> products = dao.list();
                        if (products.isEmpty()) System.out.println("No products.");
                        else products.forEach(System.out::println);
                    }
                    case "find" -> System.out.println(dao.find(id()).map(Product::toString).orElse("Not found."));
                    case "update" -> {
                        long id = id(); String name = name(); BigDecimal price = price(); int stock = stock();
                        System.out.println(dao.update(id, name, price, stock) ? "Updated." : "Not found.");
                    }
                    case "delete" -> System.out.println(dao.delete(id()) ? "Deleted." : "Not found.");
                    case "exit" -> { return; }
                    default -> System.out.println("Unknown command.");
                }
            } catch (SQLException failure) {
                // SQLState is useful for diagnosis without printing credentials or the JDBC URL.
                System.out.println("Database operation failed. SQLState=" + failure.getSQLState());
            } catch (IllegalArgumentException | IllegalStateException failure) {
                System.out.println("Input/configuration error: " + failure.getMessage());
            }
        }
    }
    private String read(String prompt) {
        System.out.print(prompt);
        if (!input.hasNextLine()) throw new IllegalStateException("End of input");
        return input.nextLine().trim();
    }
    private long id() {
        long value = Long.parseLong(read("id: "));
        if (value <= 0) throw new IllegalArgumentException("id must be positive");
        return value;
    }
    private String name() {
        String value = read("name: ");
        if (value.isBlank() || value.length() > 120) throw new IllegalArgumentException("name length must be 1..120");
        return value;
    }
    private BigDecimal price() {
        BigDecimal value = new BigDecimal(read("price: "));
        if (value.signum() < 0 || value.compareTo(new BigDecimal("9999999999.99")) > 0 || Math.max(value.scale(), 0) > 2)
            throw new IllegalArgumentException("price must fit non-negative NUMERIC(12,2)");
        return value;
    }
    private int stock() {
        int value = Integer.parseInt(read("stock: "));
        if (value < 0) throw new IllegalArgumentException("stock must be non-negative");
        return value;
    }
}
