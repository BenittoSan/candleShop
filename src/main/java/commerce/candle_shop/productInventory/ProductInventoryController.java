package commerce.candle_shop.productInventory;

import generated.ProductInventorySchema;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-inventory")
public class ProductInventoryController {

    private final IProductInventoryService productInventoryService;

    ProductInventoryController(IProductInventoryService productInventoryService) {
        this.productInventoryService = productInventoryService;
    }

    @PostMapping("/insert")
    @Operation
    public ResponseEntity<ProductInventorySchema> addProductInventory(@RequestBody ProductInventorySchema productInventorySchema) {

        ProductInventorySchema response = productInventoryService.insertProductInventory(productInventorySchema);
        return new ResponseEntity<>(productInventorySchema, HttpStatus.CREATED);
    }
}
