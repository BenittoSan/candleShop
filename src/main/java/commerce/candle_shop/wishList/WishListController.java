package commerce.candle_shop.wishList;

import commerce.candle_shop.exceptions.ErrorResponse;
import commerce.candle_shop.exceptions.ProductNotAvailableException;
import generated.InserWishListSchema;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wish-list")
public class WishListController {

    private final IWishListService wishListService;

    public WishListController(IWishListService wishListService) {
        this.wishListService = wishListService;
    }

    @Operation
    @PostMapping("/insert")
    public ResponseEntity<InserWishListSchema> createWishList(@RequestBody InserWishListSchema wishListSchema) {
        InserWishListSchema inserWishListSchema = wishListService.inserIntoWishList(wishListSchema);

        return ResponseEntity.status(HttpStatus.CREATED).body(inserWishListSchema);
    }


    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<ErrorResponse> handleProductNotAvailableException(ProductNotAvailableException e) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                "Product not available."
        );



        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
