package Domain.Orders;

import Common.Identifier;

import java.util.UUID;

/**
 * The OrderId class represents a unique identifier for an Order.
 * It extends the generic Identifier class with UUID as the type.
 */
public class OrderId extends Identifier<UUID> {

    /**
     * Constructor for creating an OrderId with a specified UUID.
     *
     * @param id the UUID to be assigned as the order ID.
     */
    public OrderId(UUID id) {
        super(id);
    }

    /**
     * Generates a new OrderId with a randomly generated UUID.
     *
     * @return a new OrderId instance with a random UUID.
     */
    public static OrderId generate() {
        return new OrderId(UUID.randomUUID());
    }
}
