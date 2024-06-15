package Domain.Orders;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import Domain.Customers.Customer;
import Domain.Customers.CustomerId;
import Domain.Products.Product;
import Infrastructure.Persistence.Converters.CustomerIdConverter;
import Infrastructure.Persistence.Converters.OrderIdConverter;
import jakarta.persistence.*;

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
    @Convert(converter = OrderIdConverter.class)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private OrderId id;

    /**
     * The unique identifier for the customer who placed the order.
     */
    @Convert(converter = CustomerIdConverter.class)
    private CustomerId customerId;

    /**
     * Creates a new order for the given customer.
     *
     * @param customer the customer placing the order
     * @return a new order instance
     */
    public static Order create(Customer customer) {
        Order order = new Order();
        order.id = OrderId.generate();
        order.customerId = customer.getId();
        return order;
    }

    /**
     * Adds the specified product to the collection of line items.
     *
     * @param product the product to add
     */
    public void add(Product product) {
        LineItem lineItem = new LineItem(LineItemId.generate(), id, product.getId(), product.getPrice());
        lineItems.add(lineItem);
    }

    // Getters and Setters
    public OrderId getId() {
        return id;
    }

    public void setId(OrderId id) {
        this.id = id;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
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
