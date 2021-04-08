package ro.fasttrackit.tema6.products.client.entity;

import java.util.Optional;
import java.util.stream.Stream;

public enum Category {
    FOOD,
    ELECTRONICS;

    public static Optional<Category> of(String productName) {
        return Stream.of(values())
                .filter(val -> val.name().equalsIgnoreCase(productName))
                .findFirst();
    }
}
