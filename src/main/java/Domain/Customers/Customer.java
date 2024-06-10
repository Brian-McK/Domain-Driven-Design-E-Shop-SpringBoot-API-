package Domain.Customers;

import java.util.Objects;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Represents a customer.
 */
@Entity
public class Customer {

    /**
     * The unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The email of the customer.
     */
    private String email;

    /**
     * Default constructor initializing name and email to empty strings.
     */
    public Customer() {
        this.name = "";
        this.email = "";
    }

    /**
     * Gets the unique identifier for the customer.
     *
     * @return the unique identifier
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the customer.
     *
     * @param id the unique identifier to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the name of the customer.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the customer.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Generates a hash code for the customer.
     *
     * @return a hash code value for this customer
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.email);
    }

    /**
     * Compares this customer to the specified object.
     *
     * @param o the object to compare
     * @return true if the given object represents a Customer equivalent to this customer, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Customer customer))
            return false;
        return Objects.equals(this.id, customer.id) && Objects.equals(this.name, customer.name)
                && Objects.equals(this.email, customer.email);
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return a string representation of the customer
     */
    @Override
    public String toString() {
        return "Customer{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + '}';
    }
}
