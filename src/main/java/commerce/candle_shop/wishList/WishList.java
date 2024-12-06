package commerce.candle_shop.wishList;

import commerce.candle_shop.customer.Customer;
import commerce.candle_shop.productAvailability.ProductAvailability;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WishList {

    @EmbeddedId
    private WishListKey wishListKey;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(nullable = false)
    private Customer customer;

    @ManyToOne
    @MapsId("productAvailabilityId")
    @JoinColumn(nullable = false)
    private ProductAvailability productAvailability;

    private int quantity;
}
