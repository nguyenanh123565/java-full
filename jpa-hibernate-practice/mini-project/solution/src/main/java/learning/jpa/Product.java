package learning.jpa;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products", schema = "learning_jpa")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String name;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    private int stock;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    protected Product() { }
    public Product(String name, BigDecimal price, int stock) { updateDetails(name, price, stock); }
    public void updateDetails(String name, BigDecimal price, int stock) {
        if (name == null || name.isBlank() || name.length() > 120)
            throw new IllegalArgumentException("name length must be 1..120");
        if (price == null || price.signum() < 0 || Math.max(price.scale(), 0) > 2 || price.compareTo(new BigDecimal("9999999999.99")) > 0)
            throw new IllegalArgumentException("price must fit non-negative NUMERIC(12,2)");
        if (stock < 0) throw new IllegalArgumentException("stock must be non-negative");
        this.name = name.trim(); this.price = price; this.stock = stock;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public int getStock() { return stock; }
    public Category getCategory() { return category; }
    void setCategory(Category category) { this.category = category; }
}
