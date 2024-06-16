package Application.Controllers;

import Application.DTO.CustomerDTO;
import Application.Services.CustomerService;
import Common.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Handles GET requests to retrieve a customer by their ID.
     *
     * @param id The UUID of the customer to be retrieved.
     * @return A CompletableFuture containing a BasicResponse with an Optional CustomerDTO.
     */
    @GetMapping("/{id}")
    public CompletableFuture<BasicResponse<Optional<CustomerDTO>>> getCustomerById(@PathVariable UUID id) {
        return customerService.findCustomerById(id);
    }

    /**
     * Handles GET requests to retrieve a customer by their email.
     *
     * @param email The email of the customer to be retrieved.
     * @return A CompletableFuture containing a BasicResponse with an Optional CustomerDTO.
     */
    @GetMapping("/email/{email}")
    public CompletableFuture<BasicResponse<Optional<CustomerDTO>>> getCustomerByEmail(@PathVariable String email) {
        return customerService.findCustomerByEmail(email);
    }
}
