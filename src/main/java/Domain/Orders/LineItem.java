package Domain.Orders;

import java.util.Objects;
import java.util.UUID;

import Shared.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/**
 * Represents a line item.
 */
@Entity
public class LineItem {

    /**
     * The unique identifier for the line item.
     */
    @Id
    private UUID id;

    /**
     * The unique identifier for the order to which the line item belongs.
     */
    private UUID orderId;

    /**
     * The unique identifier for the product associated with the line item.
     */
    private UUID productId;

    /**
     * The price of the line item, represented as a Money object.
     */
    @Transient
    private Money price;

    /**
     * Default constructor required by JPA.
     */
    protected LineItem() {
    }

    /**
     * Initializes a new instance of the LineItem class with the specified ID, order ID, product ID, and price.
     *
     * @param id the unique identifier for the line item
     * @param orderId the unique identifier for the order to which the line item belongs
     * @param productId the unique identifier for the product associated with the line item
     * @param price the price of the line item, represented as a Money object
     */
    public LineItem(UUID id, UUID orderId, UUID productId, Money price) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
    }

    // Getters

    /**
     * Gets the unique identifier for the line item.
     *
     * @return the unique identifier
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the unique identifier for the order in a line item.
     *
     * @return the unique identifier for the order
     */
    public UUID getOrderId() {
        return orderId;
    }

    /**
     * Gets the unique identifier for the product in a line item.
     *
     * @return the unique identifier for the product
     */
    public UUID getProductId() {
        return productId;
    }

    /**
     * Gets the price for the order in a line item.
     *
     * @return the price
     */
    public Money getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, productId, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LineItem lineItem))
            return false;
        return Objects.equals(id, lineItem.id) && Objects.equals(orderId, lineItem.orderId)
                && Objects.equals(productId, lineItem.productId) && Objects.equals(price, lineItem.price);
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", price=" + price +
                '}';
    }
}
