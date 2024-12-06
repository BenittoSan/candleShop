package commerce.candle_shop.wishList;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WishListKey implements Serializable {

    private Long customerId;
    private Long productAvailabilityId;
}
