package Domain.Orders;

import java.util.Objects;

import Domain.Products.ProductId;
import Infrastructure.Persistence.Converters.LineItemIdConverter;
import Infrastructure.Persistence.Converters.OrderIdConverter;
import Infrastructure.Persistence.Converters.ProductIdConverter;
import Shared.Money;
import jakarta.persistence.*;

/**
 * Represents a line item.
 */
@Entity
public class LineItem {

    /**
     * The unique identifier for the line item.
     */
    @Id
    @Convert(converter = LineItemIdConverter.class)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LineItemId id;

    /**
     * The unique identifier for the order to which the line item belongs.
     */
    @Convert(converter = OrderIdConverter.class)
    private OrderId orderId;

    /**
     * The unique identifier for the product associated with the line item.
     */
    @Convert(converter = ProductIdConverter.class)
    private ProductId productId;

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
    public LineItem(LineItemId id, OrderId orderId, ProductId productId, Money price) {
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
    public LineItemId getId() {
        return id;
    }

    /**
     * Gets the unique identifier for the order in a line item.
     *
     * @return the unique identifier for the order
     */
    public OrderId getOrderId() {
        return orderId;
    }

    /**
     * Gets the unique identifier for the product in a line item.
     *
     * @return the unique identifier for the product
     */
    public ProductId getProductId() {
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
