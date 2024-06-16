package Application.DTO;

import java.util.UUID;

/**
 * Data Transfer Object for Customer.
 * This class is used to transfer customer data between layers of the application.
 */
public class CustomerDTO {
    private UUID id;
    private String name;
    private String email;

    /**
     * Constructor to create a CustomerDTO.
     *
     * @param id    The UUID of the customer.
     * @param name  The name of the customer.
     * @param email The email of the customer.
     */
    public CustomerDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and setters

    /**
     * Gets the UUID of the customer.
     *
     * @return The UUID of the customer.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the UUID of the customer.
     *
     * @param id The UUID to set.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the customer.
     *
     * @return The email of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
