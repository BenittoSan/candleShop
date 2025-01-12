package commerce.candle_shop.cart;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CartKey {
    private Long customerId;
    private Long productAvailabilityId;
}
