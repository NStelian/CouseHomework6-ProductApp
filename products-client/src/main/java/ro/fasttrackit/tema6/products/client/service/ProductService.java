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
    private final String baseUrl = "http://localhost:8080/products";

    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                baseUrl,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product getProductById(int productId) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(baseUrl + "/" + productId, Product.class);
    }

    public List<Product> getProductsByCategory(Category category) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                baseUrl + "?category=" + category,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByMaxPrice(double maxPrice) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                baseUrl + "?maxPrice=" + maxPrice,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(baseUrl, newProduct, Product.class);
    }

    public void deleteProductById(int productId) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete(baseUrl + "/" + productId, Product.class);
    }
}
