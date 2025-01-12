package commerce.candle_shop.cart;

import commerce.candle_shop.customer.Customer;
import commerce.candle_shop.productAvailability.ProductAvailability;
import commerce.candle_shop.wishList.WishListKey;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {

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
