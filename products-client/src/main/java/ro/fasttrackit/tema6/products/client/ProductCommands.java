package ro.fasttrackit.tema6.products.client;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.tema6.products.client.entity.Category;
import ro.fasttrackit.tema6.products.client.entity.Product;
import ro.fasttrackit.tema6.products.client.service.ProductService;

import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {
    private final ProductService productService;

    @ShellMethod("print all products")
    void printAllProducts() {
        System.out.println(productService.getAllProducts());
    }

    @ShellMethod("print product by id")
    void printProductById() {
        System.out.println("id: ");
        Scanner scanner = new Scanner(System.in);
        int lookupId = scanner.nextInt();
        System.out.println(productService.getProductById(lookupId));
    }

    @ShellMethod("print products by category")
    void printProductByCategory() {
        System.out.println("category: ");
        Scanner scanner = new Scanner(System.in);
        Category category = Category.of(scanner.next()).orElse(null);
        System.out.println(productService.getProductsByCategory(category));
    }

    @ShellMethod("print products by maxPrice")
    void printProductByMaxPrice() {
        System.out.println("maxPrice: ");
        Scanner scanner = new Scanner(System.in);
        double maxPrice = scanner.nextDouble();
        System.out.println(productService.getProductsByMaxPrice(maxPrice));
    }

    @ShellMethod("add product")
    void addProduct() {
        System.out.println("product name: ");
        Scanner scanner = new Scanner(System.in);
        String productName = scanner.next();
        System.out.println("product price: ");
        double productPrice = scanner.nextDouble();
        System.out.println("product description: ");
        String productDescription = scanner.next();
        System.out.println("category: ");
        Category category = Category.of(scanner.next()).orElse(null);

        Product product = new Product(0, productName, productPrice, productDescription, category);

        System.out.println(productService.addProduct(product));
    }

    @ShellMethod("delete product")
    void deleteProduct() {
        System.out.println("id: ");
        Scanner scanner = new Scanner(System.in);
        int lookupId = scanner.nextInt();
        productService.deleteProductById(lookupId);
    }
}
