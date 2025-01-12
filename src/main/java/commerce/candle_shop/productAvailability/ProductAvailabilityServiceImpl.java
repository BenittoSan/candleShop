package commerce.candle_shop.productAvailability;

import commerce.candle_shop.exceptions.ProductInventoryNotExistException;
import commerce.candle_shop.productInventory.ProductInventory;
import generated.InserProductAvailabilitySchema;
import generated.SelectProductAvailabilityAndInventorySchema;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAvailabilityServiceImpl implements IProductAvailabilityService {

    private final IProductAvailabilityRepository productAvailabilityRepository;
    private final EntityManager em;

    public ProductAvailabilityServiceImpl(IProductAvailabilityRepository productAvailabilityRepository, EntityManager em) {
        this.productAvailabilityRepository = productAvailabilityRepository;
        this.em = em;
    }

    private void validateProductInventoryExist(ProductInventory productInventory, long productInventoryId) {
        if (productInventory == null){
            throw  new ProductInventoryNotExistException("Product Inventory with ID: " +productInventoryId + " does not exist");
        }
    }

    @Override
    public InserProductAvailabilitySchema insertProductAvailability(InserProductAvailabilitySchema insertProductAvailability) {

        ProductAvailability productAvailability = new ProductAvailability();
            productAvailability.setPrice(insertProductAvailability.getPrice());

            ProductInventory productInventory =
                            em.find(
                                    ProductInventory.class,
                                    insertProductAvailability.getProductInventoryId());

        validateProductInventoryExist(
                productInventory, insertProductAvailability.getProductInventoryId());


            productAvailability.setProductInventory(productInventory);

        productAvailabilityRepository.save(productAvailability);

        return insertProductAvailability;
    }

    @Override
    public List<SelectProductAvailabilityAndInventorySchema> retrieveProductAvailability() {
        return productAvailabilityRepository.finProductAvailabilityInfo();
    }
}
