package commerce.candle_shop.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

     List<Customer> findCustomersById(long id);
     Optional<Customer> findCustomerById(long id);

}
