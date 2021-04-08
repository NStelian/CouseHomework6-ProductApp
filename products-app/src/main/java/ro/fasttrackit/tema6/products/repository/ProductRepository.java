package ro.fasttrackit.tema6.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.tema6.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
