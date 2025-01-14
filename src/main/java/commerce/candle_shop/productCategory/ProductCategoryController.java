package commerce.candle_shop.productCategory;

import generated.ProductCategoryNamesSchema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController {

    IProductCategoryRepository productCategoryRepository;

    ProductCategoryController(IProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @GetMapping("/product/categories")
    public ResponseEntity<ProductCategoryNamesSchema> getProductCategories() {



        ProductCategoryNamesSchema categoryList = new ProductCategoryNamesSchema();

        List<ProductCategory> productCategories = productCategoryRepository.findAll()
                .stream().toList();

        productCategories.forEach(
                productCategory -> {
                    categoryList.getCategoryName().add(productCategory.getCategoryName());
                }
        );
        return ResponseEntity.ok(categoryList);
    }
}
