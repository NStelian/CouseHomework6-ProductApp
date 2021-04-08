package ro.fasttrackit.tema6.products.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.tema6.products.client.entity.Category;
import ro.fasttrackit.tema6.products.client.entity.Product;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ProductService {
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                "http://localhost:8080/products",
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product getProductById(int productId) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://localhost:8080/products/" + productId, Product.class);
    }

    public List<Product> getProductsByCategory(Category category) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                "http://localhost:8080/products/category/" + category,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByMaxPrice(double maxPrice) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                "http://localhost:8080/products/maxPrice/" + maxPrice,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://localhost:8080/products", newProduct, Product.class);
    }

    public void deleteProductById(int productId) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete("http://localhost:8080/products/" + productId, Product.class);
    }
}
