package commerce.candle_shop.productImage;

import org.springframework.web.multipart.MultipartFile;

public interface IProductImageService {

    String insertProductImage(MultipartFile file, Long productInventoryId);
}
