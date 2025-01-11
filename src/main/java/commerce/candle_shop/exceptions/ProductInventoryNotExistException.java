package commerce.candle_shop.exceptions;

public class ProductInventoryNotExistException extends RuntimeException {
    public ProductInventoryNotExistException(String message) {
        super(message);

    }
}
