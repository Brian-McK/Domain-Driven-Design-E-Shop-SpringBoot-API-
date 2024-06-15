package Domain.Orders;

import Common.Identifier;

import java.util.UUID;

/**
 * The LineItemId class represents a unique identifier for a Line Item in an order.
 * It extends the generic Identifier class with UUID as the type.
 * This class is declared as final to prevent subclassing.
 */
public final class LineItemId extends Identifier<UUID> {

    /**
     * Constructor for creating a LineItemId with a specified UUID.
     *
     * @param value the UUID to be assigned as the line item ID.
     */
    public LineItemId(UUID value) {
        super(value);
    }

    /**
     * Generates a new LineItemId with a randomly generated UUID.
     *
     * @return a new LineItemId instance with a random UUID.
     */
    public static LineItemId generate() {
        return new LineItemId(UUID.randomUUID());
    }
}
