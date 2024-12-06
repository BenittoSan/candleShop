package commerce.candle_shop.productCategory;

import commerce.candle_shop.productInventory.ProductInventory;
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
public class ProductCategory {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    private String categoryName;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<ProductInventory> productInventories;
}
