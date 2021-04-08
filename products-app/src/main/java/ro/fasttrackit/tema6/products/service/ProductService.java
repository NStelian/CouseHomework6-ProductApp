package ro.fasttrackit.tema6.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema6.products.entity.Category;
import ro.fasttrackit.tema6.products.entity.Product;
import ro.fasttrackit.tema6.products.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(long productId) {
        return repository.findById(productId);
    }

    public List<Product> getProductsByCategory(Category category) {
        return repository.findAll().stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(toList());
    }

    public List<Product> getProductsWithMaxPrice(double maxPrice) {
        return repository.findAll().stream()
                .filter(product -> product.getPrice() <= maxPrice)
                .collect(toList());
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProductByID(long productId) {
        repository.deleteById(productId);
    }
}
