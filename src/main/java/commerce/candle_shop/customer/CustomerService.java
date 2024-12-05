package commerce.candle_shop.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;


    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
}
