package commerce.candle_shop.productAvailability;

import commerce.candle_shop.dto.AvailabilityProductImageByteDTO;
import generated.SelectProductAvailabilityAndInventorySchema;
import org.springframework.data.domain.Pageable;
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
    List<SelectProductAvailabilityAndInventorySchema> findProductAvailabilityInfo(Pageable pageable);


    @Query("""
            SELECT new commerce.candle_shop.dto.AvailabilityProductImageByteDTO(
            pi.productName,
           pa.price,
           pi.quantity,
           pi.description,
           pi.id,
           pa.id,
           pi.weight,
           pi.burnDuration,
           image.image
            )
            FROM ProductAvailability pa
            JOIN pa.productInventory pi
            LEFT JOIN pi.productImages image
            """)
    List<AvailabilityProductImageByteDTO>retriveAvailabilityProductInfo(Pageable pageable);
}

