package learning.jpa;

import java.util.List;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByIdAsc();

    @Query("select p from Product p left join fetch p.category order by p.id")
    List<Product> findAllWithCategory();

    @Query(value = "select count(*) from learning_jpa.products where price >= :minimum", nativeQuery = true)
    long countExpensiveNative(@Param("minimum") BigDecimal minimum);
}
