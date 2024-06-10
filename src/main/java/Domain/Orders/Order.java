package Domain.Orders;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import Domain.Customers.Customer;
import Domain.Products.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;

/**
 * Represents a customer order.
 */
@Entity
public class Order {

    @Transient
    private final Set<LineItem> lineItems = new HashSet<>();

    /**
     * Default constructor required by JPA.
     */
    protected Order() {
    }

    /**
     * The unique identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * The unique identifier for the customer who placed the order.
     */
    private UUID customerId;

    /**
     * Creates a new order for the given customer.
     *
     * @param customer the customer placing the order
     * @return a new order instance
     */
    public static Order create(Customer customer) {
        Order order = new Order();
        order.id = UUID.randomUUID();
        order.customerId = customer.getId();
        return order;
    }

    /**
     * Adds the specified product to the collection of line items.
     *
     * @param product the product to add
     */
    public void add(Product product) {
        LineItem lineItem = new LineItem(UUID.randomUUID(), id, product.getId(), product.getPrice());
        lineItems.add(lineItem);
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Order order))
            return false;
        return Objects.equals(id, order.id) && Objects.equals(customerId, order.customerId);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerId=" + customerId + '}';
    }
}
