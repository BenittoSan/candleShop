package commerce.candle_shop.customer;



import commerce.candle_shop.jsonToJavaFormater.IJsonToJavaConversion;
import generated.CustomerSchema;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final ICustomerService customerService;


    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;

    }

//    @Operation
//    @GetMapping(value = "/customer", params = "id")
//    public ResponseEntity<Customer> getCustomer(@RequestParam long id) {
//        Optional<Customer> c = customerService.retriveCustomer(id);
//        return new ResponseEntity<>(c.orElse(null), HttpStatus.OK);
//    }
//
//    @Operation
//    @GetMapping(value = "/customer/name", params = "name")
//    public ResponseEntity<List<Customer>> getCustomerWithName(@RequestParam String name){
//
//        return new ResponseEntity<>(customerService.retriveCustomersByName(name), HttpStatus.OK);
//    }

//    @PostMapping(value = "customer")
//    @Transactional
//    public ResponseEntity<Customer>createCustomer(@RequestBody CustomerSchema customerSchema){
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
//        Root<Customer> root = cq.from(Customer.class);
//
//        Customer customer = new Customer();
//        customer.setName(customerSchema.getName());
//        customer.setEmail(customerSchema.getEmail());
//        customer.setBirthday(
//                javaConversion.stringToLocalDate(
//                        customerSchema.getBirthday()
//                ));
//        customer.setLastName(customerSchema.getLastName());
//        customer.setCreatedAt(LocalDateTime.now());
//
//        em.persist(customer);
//
//
//        return new ResponseEntity<>(customer, HttpStatus.CREATED);
//    }
    @PostMapping(value = "/customer")
    @Operation
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerSchema customer) {
        Customer c = customerService.insertCustomer(customer);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
