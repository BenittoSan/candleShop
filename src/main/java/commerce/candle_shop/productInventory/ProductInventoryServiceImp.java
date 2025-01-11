package commerce.candle_shop.productInventory;

import commerce.candle_shop.productCategory.ProductCategory;
import generated.ProductInventorySchema;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryServiceImp implements IProductInventoryService {

    private final IProductInventoryRepository productRepository;

    @PersistenceContext
    private  EntityManager em;

    ProductInventoryServiceImp(IProductInventoryRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public ProductInventorySchema insertProductInventory(ProductInventorySchema userInput) {

        ProductInventory product = new ProductInventory();

        product.setProductName(userInput.getProductName());
        product.setDescription(userInput.getDescription());
        product.setQuantity(userInput.getQuantity());
        product.setPrice(userInput.getPrice());
        product.setWeight(userInput.getWeight());
        product.setBurnDuration(userInput.getBurnDuration());


        ProductCategory productCategory = em.find(ProductCategory.class, userInput.getCategoryID());
        product.setCategory(productCategory);


        productRepository.save(product);

        return userInput;
    }
}
