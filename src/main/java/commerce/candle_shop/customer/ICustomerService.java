package commerce.candle_shop.customer;

import org.springframework.stereotype.Component;

@Component
public interface ICustomerService {

    Customer createCustomer(Customer customer);


}
