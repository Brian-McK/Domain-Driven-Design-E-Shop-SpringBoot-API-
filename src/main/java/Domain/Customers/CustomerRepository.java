package Domain.Customers;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
    // JpaRepository already provides findById(CustomerId id)

    /**
     * Finds a customer by their email.
     *
     * @param email The email of the customer to find.
     * @return An Optional containing the found customer, or empty if no customer was found.
     */
    Optional<Customer> findByEmail(String email);
}
