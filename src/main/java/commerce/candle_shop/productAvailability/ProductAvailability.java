package commerce.candle_shop.productAvailability;

import commerce.candle_shop.productInventory.ProductInventory;
import commerce.candle_shop.wishList.WishList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double price;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE,mappedBy = "productAvailability")
    private List<WishList> wishLists;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productInventory_id", nullable = false)
    private ProductInventory productInventory;
}
