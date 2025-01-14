package commerce.candle_shop.productAvailability;

import commerce.candle_shop.dto.AvailabilityProductImageBase64DTO;
import commerce.candle_shop.exceptions.ErrorResponse;
import commerce.candle_shop.exceptions.ProductInventoryNotExistException;
import generated.InserProductAvailabilitySchema;
import generated.SelectProductAvailabilityAndInventorySchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                "Product Inventory Not Exist."
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

    @GetMapping("/select")
    public ResponseEntity<List<SelectProductAvailabilityAndInventorySchema>> selectProductAvailability(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        List<SelectProductAvailabilityAndInventorySchema> response = productAvailabilityService.retrieveProductAvailability(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @GetMapping("/select/image")
    public ResponseEntity<List<AvailabilityProductImageBase64DTO>> retrieveProductAvailabilityImages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        List<AvailabilityProductImageBase64DTO> response = productAvailabilityService.retriveAvailabilityProductImages(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}