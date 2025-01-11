package commerce.candle_shop.productInventory;

import commerce.candle_shop.productAvailability.ProductAvailability;
import commerce.candle_shop.productCategory.ProductCategory;
import commerce.candle_shop.productImage.ProductImage;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productName;
    private String description;
    private int quantity;
    private double price;
    private double weight;
    private int burnDuration;

    @ManyToOne
    private ProductCategory category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productInventory")
    @Size(min = 1, max = 5, message = "Product need at least one image") // To delete <-
    private List<ProductImage> productImages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productInventory")
    private List<ProductAvailability> productAvailabilities = new ArrayList<>();
}
