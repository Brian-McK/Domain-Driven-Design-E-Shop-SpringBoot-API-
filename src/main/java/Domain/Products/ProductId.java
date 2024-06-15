package Domain.Products;

import Common.Identifier;

import java.util.UUID;

/**
 * The ProductId class represents a unique identifier for a Product.
 * It extends the generic Identifier class with UUID as the type.
 */
public class ProductId extends Identifier<UUID> {

    /**
     * Constructor for creating a ProductId with a specified UUID.
     *
     * @param id the UUID to be assigned as the product ID.
     */
    public ProductId(UUID id) {
        super(id);
    }

    /**
     * Generates a new ProductId with a randomly generated UUID.
     *
     * @return a new ProductId instance with a random UUID.
     */
    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }
}
