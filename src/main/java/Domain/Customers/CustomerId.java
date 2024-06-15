package Domain.Customers;

import Common.Identifier;

import java.util.UUID;

/**
 * The CustomerId class represents a unique identifier for a Customer.
 * It extends the generic Identifier class with UUID as the type.
 * This class is declared as final to prevent subclassing.
 */
public final class CustomerId extends Identifier<UUID> {

    /**
     * Constructor for creating a CustomerId with a specified UUID.
     *
     * @param value the UUID to be assigned as the customer ID.
     */
    public CustomerId(UUID value) {
        super(value);
    }

    /**
     * Generates a new CustomerId with a randomly generated UUID.
     *
     * @return a new CustomerId instance with a random UUID.
     */
    public static CustomerId generate() {
        return new CustomerId(UUID.randomUUID());
    }
}




