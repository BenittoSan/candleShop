package commerce.candle_shop.customer;

import generated.CustomerSchema;



public interface ICustomerService {

    Customer insertCustomer(CustomerSchema customerSchema);

//    Optional<Customer> retriveCustomer(long id);
//
//    List<Customer> retriveCustomersByName(String name);
}
