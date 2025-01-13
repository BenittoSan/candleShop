package commerce.candle_shop.productImage;

import commerce.candle_shop.exceptions.ImageUploadedErrorException;
import commerce.candle_shop.productInventory.ProductInventory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductImageService implements IProductImageService {

    private final IProductImageRepository productImageRepository;

    private final EntityManager em;

    ProductImageService(IProductImageRepository productImageRepository, EntityManager em) {
        this.productImageRepository = productImageRepository;
        this.em = em;
    }



    @Override
    @Transactional
    public String insertProductImage(MultipartFile file, Long productInventoryId) {
        try{

            byte[] imageBytes = file.getBytes();

            ProductInventory productInventory = em.find(ProductInventory.class, productInventoryId);

            ProductImage productImage = new ProductImage();
            productImage.setImage(imageBytes);
            productImage.setProductInventory(productInventory);

            productImageRepository.save(productImage);

            return "Image uploaded successfully";
        }
        catch (IOException e) {
            throw new ImageUploadedErrorException("Image upload failed");
        }
    }
}
