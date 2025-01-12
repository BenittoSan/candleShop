package commerce.candle_shop.productAvailability;

import generated.SelectProductAvailabilityAndInventorySchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductAvailabilityRepository extends JpaRepository<ProductAvailability, Long> {

    @Query("""
           SELECT new generated.SelectProductAvailabilityAndInventorySchema(
           pi.productName,
           pa.price,
           pi.quantity,
           pi.description,
           CAST(pi.id AS integer ),
           CAST(pa.id as integer ),
           pi.weight,
           pi.burnDuration)
            FROM ProductAvailability pa 
            JOIN pa.productInventory pi
            """)
    List<SelectProductAvailabilityAndInventorySchema> finProductAvailabilityInfo();
}
