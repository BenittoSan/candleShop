package commerce.candle_shop.productAvailability;

import commerce.candle_shop.dto.AvailabilityProductImageBase64DTO;
import commerce.candle_shop.dto.AvailabilityProductImageByteDTO;
import commerce.candle_shop.exceptions.ProductInventoryNotExistException;
import commerce.candle_shop.productInventory.ProductInventory;
import generated.InserProductAvailabilitySchema;
import generated.SelectProductAvailabilityAndInventorySchema;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Base64;
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
    public List<SelectProductAvailabilityAndInventorySchema> retrieveProductAvailability(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return productAvailabilityRepository.findProductAvailabilityInfo(pageRequest);
    }

    @Override
    public List<AvailabilityProductImageBase64DTO> retriveAvailabilityProductImages(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        List<AvailabilityProductImageByteDTO> productImageByte =
                productAvailabilityRepository.retriveAvailabilityProductInfo(pageRequest);


        List<AvailabilityProductImageBase64DTO> productImageBase64List =
                productImageByte.stream()
                        .map(product ->{

                            String imageBase64 = null;

                            if(product.getImage() != null)
                                 imageBase64 = Base64.getEncoder().encodeToString(product.getImage());
                            else
                                imageBase64 = "";

                            return new AvailabilityProductImageBase64DTO(
                                    product.getProductName(),
                                    product.getPrice(),
                                    product.getQuantity(),
                                    product.getDescription(),
                                    product.getProductInventoryId(),
                                    product.getProductAvailabilityID(),
                                    product.getWeight(),
                                    product.getBurnDuration(),
                                    imageBase64
                            );
                        }).toList();



        return productImageBase64List;
    }


}
