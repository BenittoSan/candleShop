package commerce.candle_shop.productImage;

import commerce.candle_shop.productInventory.ProductInventory;
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
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //private Blob image;
    //private imageOrder

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productInventory_id")
    private ProductInventory productInventory;
}
