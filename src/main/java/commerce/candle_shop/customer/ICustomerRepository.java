package commerce.candle_shop.customer;

import generated.CustomerSchema;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> findCustomerByName(String name);
    Customer insertCustomer(CustomerSchema customerSchema);
}
