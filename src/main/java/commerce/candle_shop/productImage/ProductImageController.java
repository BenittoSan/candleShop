package commerce.candle_shop.productImage;

import commerce.candle_shop.exceptions.ErrorResponse;
import commerce.candle_shop.exceptions.ImageUploadedErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product-image")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductImageController {

    private final IProductImageService productImageService;

    ProductImageController(IProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image,
                                              @RequestParam("productId") long productId){

        String response = productImageService.insertProductImage(image, productId);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @ExceptionHandler(ImageUploadedErrorException.class)
    public ResponseEntity<ErrorResponse> handleImageUploadedErrorException(ImageUploadedErrorException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDetails("Unable to upload image, please try again");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
