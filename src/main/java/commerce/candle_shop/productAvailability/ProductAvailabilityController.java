package commerce.candle_shop.productAvailability;

import commerce.candle_shop.exceptions.ErrorResponse;
import commerce.candle_shop.exceptions.ProductInventoryNotExistException;
import generated.InserProductAvailabilitySchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-availability")
public class ProductAvailabilityController {

    private final IProductAvailabilityService productAvailabilityService;


    public ProductAvailabilityController(IProductAvailabilityService productAvailabilityService) {
        this.productAvailabilityService = productAvailabilityService;
    }

    @PostMapping("/insert")
    public ResponseEntity<InserProductAvailabilitySchema> insertProductAvailability(
                @RequestBody InserProductAvailabilitySchema inserProductAvailabilitySchema) {

        productAvailabilityService.insertProductAvailability(inserProductAvailabilitySchema);

        return ResponseEntity.status(HttpStatus.CREATED).body(inserProductAvailabilitySchema);
    }
    @ExceptionHandler(ProductInventoryNotExistException.class)
    public ResponseEntity<ErrorResponse> handleProductInventoryNotExistException(ProductInventoryNotExistException e){

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                "Product Inventory Not Exist."
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

}