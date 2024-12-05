package commerce.candle_shop.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customer")
    public ResponseEntity<Customer> createEntityCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
