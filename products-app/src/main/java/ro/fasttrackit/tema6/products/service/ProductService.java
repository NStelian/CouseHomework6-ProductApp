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

    public List<Product> getAllProducts(Category category, Double maxPrice) {
        List<Product> products = repository.findAll();

        if (category != null) {
            products = products.stream()
                    .filter(product -> product.getCategory().equals(category))
                    .collect(toList());
        }

        if (maxPrice != null) {
            products = products.stream()
                    .filter(product -> product.getPrice() <= maxPrice)
                    .collect(toList());
        }

        return products;
    }

    public Optional<Product> getProductById(long productId) {
        return repository.findById(productId);
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProductByID(long productId) {
        repository.deleteById(productId);
    }
}
