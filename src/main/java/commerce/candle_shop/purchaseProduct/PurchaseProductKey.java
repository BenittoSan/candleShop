package commerce.candle_shop.purchaseProduct;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PurchaseProductKey {

    private long productAvailabilityId;
    private long purchaseId;
}
