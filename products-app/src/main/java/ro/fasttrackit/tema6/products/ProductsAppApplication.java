package ro.fasttrackit.tema6.products;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.tema6.products.entity.Category;
import ro.fasttrackit.tema6.products.entity.Product;
import ro.fasttrackit.tema6.products.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class ProductsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsAppApplication.class, args);
	}

	@Bean
	CommandLineRunner atStartup(ProductRepository repository) {
		return args -> {
			repository.saveAll(List.of(
					new Product("bread", 2.5, "very good", Category.FOOD),
					new Product("tv", 1999.99, "very good", Category.ELECTRONICS)
			));
		};
	}
}
