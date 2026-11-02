package learning.jpa;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories", schema = "learning_jpa")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    protected Category() { }
    public Category(String name) {
        if (name == null || name.isBlank() || name.length() > 120)
            throw new IllegalArgumentException("category name length must be 1..120");
        this.name = name.trim();
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }
}
