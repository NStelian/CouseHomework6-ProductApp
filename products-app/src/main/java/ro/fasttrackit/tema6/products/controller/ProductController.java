package ro.fasttrackit.tema6.products.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.tema6.products.entity.Category;
import ro.fasttrackit.tema6.products.entity.Product;
import ro.fasttrackit.tema6.products.exceptions.ResourceNotFoundException;
import ro.fasttrackit.tema6.products.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    List<Product> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("{productId}")
    Product getProductById(@PathVariable long productId) {
        return service.getProductById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find product with id " + productId));
    }

    @GetMapping("category/{category}")
    List<Product> getProductsByCategory(@PathVariable Category category) {
        return service.getProductsByCategory(category);
    }

    @GetMapping("maxPrice/{maxPrice}")
    List<Product> getProductWithMaxPrice(@PathVariable double maxPrice) {
        return service.getProductsWithMaxPrice(maxPrice);
    }

    @PostMapping
    Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @DeleteMapping("{productId}")
    void deleteProductByID(@PathVariable long productId) {
        service.deleteProductByID(productId);
    }
}
