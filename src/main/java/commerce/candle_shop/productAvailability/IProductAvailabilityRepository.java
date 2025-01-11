package commerce.candle_shop.productAvailability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductAvailabilityRepository extends JpaRepository<ProductAvailability, Long> {
}
