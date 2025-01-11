package commerce.candle_shop.productInventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductInventoryRepository extends JpaRepository<ProductInventory,Long> {

}
