package commerce.candle_shop.productImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findProductImageByProductInventoryId(long productInventory);
}
