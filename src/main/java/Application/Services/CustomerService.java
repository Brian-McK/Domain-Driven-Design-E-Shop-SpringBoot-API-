package Application.Services;

import Application.DTO.CustomerDTO;
import Common.BasicResponse;
import Domain.Customers.Customer;
import Domain.Customers.CustomerId;
import Domain.Customers.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Finds a customer by their ID asynchronously and returns a BasicResponse containing a CustomerDTO.
     *
     * @param id The UUID of the customer to be found.
     * @return A CompletableFuture containing a BasicResponse with an Optional CustomerDTO.
     */
    @Async
    public CompletableFuture<BasicResponse<Optional<CustomerDTO>>> findCustomerById(UUID id) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Customer> customer = customerRepository.findById(new CustomerId(id));
            if (customer.isPresent()) {
                // Convert the Customer entity to a CustomerDTO and wrap it in a BasicResponse
                return new BasicResponse<>("success", "Customer found", customer.map(this::toDTO));
            } else {
                // Return an error response if the customer is not found
                return new BasicResponse<>("error", "Customer not found", Optional.empty());
            }
        });
    }

    /**
     * Finds a customer by their email asynchronously and returns a BasicResponse containing a CustomerDTO.
     *
     * @param email The email of the customer to be found.
     * @return A CompletableFuture containing a BasicResponse with an Optional CustomerDTO.
     */
    @Async
    public CompletableFuture<BasicResponse<Optional<CustomerDTO>>> findCustomerByEmail(String email) {
        if (email == null || email.isEmpty()) {
            // Return an error response immediately if the email is null or empty
            return CompletableFuture.completedFuture(
                    new BasicResponse<>("error", "Email cannot be null or empty", Optional.empty()));
        }
        return CompletableFuture.supplyAsync(() -> {
            Optional<Customer> customer = customerRepository.findByEmail(email);
            if (customer.isPresent()) {
                // Convert the Customer entity to a CustomerDTO and wrap it in a BasicResponse
                return new BasicResponse<>("success", "Customer found", customer.map(this::toDTO));
            } else {
                // Return an error response if the customer is not found
                return new BasicResponse<>("error", "Customer not found", Optional.empty());
            }
        });
    }

    /**
     * Converts a Customer entity to a CustomerDTO.
     *
     * @param customer The Customer entity to be converted.
     * @return The corresponding CustomerDTO.
     */
    private CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getId().getValue(), customer.getName(), customer.getEmail());
    }
}
