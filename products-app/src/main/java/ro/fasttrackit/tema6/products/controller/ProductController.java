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
    List<Product> getProducts(@RequestParam(required=false) Category category, @RequestParam(required=false) Double maxPrice) {
        return service.getAllProducts(category, maxPrice);
    }

    @GetMapping("{productId}")
    Product getProductById(@PathVariable long productId) {
        return service.getProductById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find product with id " + productId));
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
