package commerce.candle_shop.customer;

import commerce.candle_shop.jsonToJavaFormater.IJsonToJavaConversion;
import generated.CustomerSchema;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor()
@Getter
@Setter
public class CustomerRepositoryImpl implements ICustomerRepository {

    @PersistenceContext
    private final EntityManager em;


    private final IJsonToJavaConversion javaConversion;


    @Override
    public List<Customer> findCustomerByName(String name) {
        String queryStr = "Select c from Customer c where c.name = :name";
        TypedQuery<Customer> query = em.createQuery(queryStr, Customer.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Customer insertCustomer(CustomerSchema customerSchema) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        //Root<Customer> root = cq.from(Customer.class);

        Customer customer = new Customer();
        customer.setName(customerSchema.getName());
        customer.setEmail(customerSchema.getEmail());
        customer.setBirthday(
                javaConversion.stringToLocalDate(
                        customerSchema.getBirthday()
                ));
        customer.setLastName(customerSchema.getLastName());
        customer.setCreatedAt(LocalDateTime.now());

        em.persist(customer);
        return customer;
    }
}
