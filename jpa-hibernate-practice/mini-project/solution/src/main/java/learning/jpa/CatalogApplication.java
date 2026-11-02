package learning.jpa;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

@SpringBootApplication
public class CatalogApplication implements CommandLineRunner {
    private final CatalogService catalog;
    public CatalogApplication(CatalogService catalog) { this.catalog = catalog; }

    public static void main(String[] args) {
        // Console use case: close EntityManagerFactory/pool after one command.
        try (ConfigurableApplicationContext context = SpringApplication.run(CatalogApplication.class, args)) { }
    }
    @Override
    public void run(String... args) {
        if (args.length == 0) { usage(); return; }
        try {
            switch (args[0]) {
                case "add-category" -> { require(args, 2); System.out.println("Category id: " + catalog.addCategory(args[1])); }
                case "add" -> {
                    if (args.length != 4 && args.length != 5) throw new IllegalArgumentException("add requires name price stock [categoryId]");
                    System.out.println(catalog.add(args[1], new BigDecimal(args[2]), Integer.parseInt(args[3]), args.length == 5 ? positiveId(args[4]) : null));
                }
                case "list" -> { require(args, 1); catalog.list(false).forEach(System.out::println); }
                case "list-details" -> { require(args, 1); catalog.list(true).forEach(System.out::println); }
                case "find" -> { require(args, 2); System.out.println(catalog.find(positiveId(args[1])).map(ProductView::toString).orElse("Not found.")); }
                case "update" -> {
                    require(args, 5);
                    System.out.println(catalog.update(positiveId(args[1]), args[2], new BigDecimal(args[3]), Integer.parseInt(args[4])) ? "Updated." : "Not found.");
                }
                case "delete" -> { require(args, 2); System.out.println(catalog.delete(positiveId(args[1])) ? "Deleted." : "Not found."); }
                case "fail-add" -> { require(args, 1); catalog.failAdd(); }
                default -> usage();
            }
        } catch (IllegalArgumentException | IllegalStateException expected) {
            System.out.println("Input/demo result: " + expected.getMessage());
        } catch (DataAccessException failure) {
            System.out.println("Database operation failed: " + failure.getClass().getSimpleName());
        }
    }
    private static void require(String[] args, int count) {
        if (args.length != count) throw new IllegalArgumentException("Wrong argument count; read README usage");
    }
    private static long positiveId(String raw) {
        long id = Long.parseLong(raw);
        if (id <= 0) throw new IllegalArgumentException("id must be positive");
        return id;
    }
    private static void usage() {
        System.out.println("add-category name | add name price stock [categoryId] | list | list-details | find id | update id name price stock | delete id | fail-add");
    }
}
