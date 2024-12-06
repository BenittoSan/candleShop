package commerce.candle_shop.purchaseProduct;

import commerce.candle_shop.productAvailability.ProductAvailability;
import commerce.candle_shop.purchase.Purchase;
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
public class PurchaseProduct {

    @EmbeddedId
    private PurchaseProductKey purchaseProductKey;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(nullable = false)
    private Purchase purchase;

    @ManyToOne
    @MapsId("productAvailabilityId")
    @JoinColumn(nullable = false)
    private ProductAvailability productAvailability;

    private int quantity;
}
