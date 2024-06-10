package Domain.Products;

import java.util.Objects;
import java.util.UUID;

import Shared.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Embedded;

/**
 * Represents a product.
 */
@Entity
public class Product {

    /**
     * The unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The price of the product, represented as a Money object.
     */
    @Embedded
    private Money price;

    /**
     * The SKU of the product.
     */
    @Embedded
    private Sku sku;

    /**
     * Default constructor required by JPA.
     */
    protected Product() {
        this.name = "";
    }

    // Getters
    /**
     * Gets the unique identifier for the product.
     *
     * @return the unique identifier
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price
     */
    public Money getPrice() {
        return price;
    }

    /**
     * Gets the SKU of the product.
     *
     * @return the SKU
     */
    public Sku getSku() {
        return sku;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, sku);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(sku, product.sku);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sku=" + sku +
                '}';
    }
}
