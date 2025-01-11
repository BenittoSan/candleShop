package commerce.candle_shop.address;

import commerce.candle_shop.customer.Customer;
import generated.AddressSchema;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements IAddressService {

    private final IAddressRepository addressRepository;

    @PersistenceContext
    private final EntityManager em;

    AddressServiceImp(IAddressRepository addressRepository, EntityManager entityManager) {
        this.addressRepository = addressRepository;
        this.em = entityManager;
    }


    @Override
    @Transactional
    public AddressSchema insertAddress(AddressSchema addressSchema) {

        Address address = new Address();

        address.setStreet(addressSchema.getStreet());
        address.setCity(addressSchema.getCity());
        address.setHouseNumber(addressSchema.getHouseNumber());
        address.setZipCode(addressSchema.getZipCode());
        address.setCountry(addressSchema.getCountry());

        Customer customer = em.find(Customer.class, addressSchema.getCustomerId());

        address.setCustomer(customer);

            addressRepository.save(address);

        return addressSchema;
    }
}
