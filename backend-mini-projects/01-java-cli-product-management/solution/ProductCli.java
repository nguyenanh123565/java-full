import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductCli {
    record Product(long id, String name, BigDecimal price, int stock) {
        Product {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
            if (price == null || price.signum() < 0 || stock < 0)
                throw new IllegalArgumentException("price and stock must be non-negative");
        }
    }
    static Product readProduct(long id, String[] parts, int offset) {
        if (parts.length != offset + 3) throw new IllegalArgumentException("wrong number of fields");
        return new Product(id, parts[offset].trim(), new BigDecimal(parts[offset+1].trim()),
                Integer.parseInt(parts[offset+2].trim()));
    }
    public static void main(String[] args) {
        Map<Long, Product> products = new LinkedHashMap<>();
        long nextId = 1;
        System.out.println("add|name|price|stock ; list ; find|id ; update|id|name|price|stock ; delete|id ; quit");
        try (Scanner input = new Scanner(System.in)) {
            while (input.hasNextLine()) {
                String[] parts = input.nextLine().split("[|]", -1);
                String command = parts[0].trim();
                if (command.equals("quit")) break;
                try {
                    switch (command) {
                        case "add" -> {
                            Product p = readProduct(nextId, parts, 1);
                            products.put(nextId, p);
                            nextId++;
                            System.out.println("Created: " + p);
                        }
                        case "list" -> products.values().forEach(System.out::println);
                        case "find", "delete" -> {
                            if (parts.length != 2) throw new IllegalArgumentException("expected id");
                            long id = Long.parseLong(parts[1].trim());
                            Product p = command.equals("find") ? products.get(id) : products.remove(id);
                            System.out.println(p == null ? "Not found" : p);
                        }
                        case "update" -> {
                            if (parts.length != 5) throw new IllegalArgumentException("expected id/name/price/stock");
                            long id = Long.parseLong(parts[1].trim());
                            if (!products.containsKey(id)) System.out.println("Not found");
                            else {
                                Product p = readProduct(id, parts, 2);
                                products.put(id, p);
                                System.out.println("Updated: " + p);
                            }
                        }
                        default -> System.out.println("Unknown command");
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println("Invalid input: " + ex.getMessage());
                }
            }
        }
    }
}
