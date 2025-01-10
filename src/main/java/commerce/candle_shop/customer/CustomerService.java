package commerce.candle_shop.customer;

import generated.CustomerSchema;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private final ICustomerJpaRepository iCustomerJpaRepository;


    public CustomerService( ICustomerRepository customerRepository,
                           ICustomerJpaRepository iCustomerJpaRepository) {
        this.customerRepository = customerRepository;
        this.iCustomerJpaRepository = iCustomerJpaRepository;
    }

    @Override
    public Customer insertCustomer(CustomerSchema customerSchema) {
        Customer customer = customerRepository.insertCustomer(customerSchema);
        return customer;
    }

//
//    @Override
//    public Optional<Customer> retriveCustomer(long id) {
//        return iCustomerJpaRepository.findById(id);
//    }
//
//    @Override
//    public List<Customer> retriveCustomersByName(String name) {
//        return customerRepository.findCustomerByName(name);
//    }

}
