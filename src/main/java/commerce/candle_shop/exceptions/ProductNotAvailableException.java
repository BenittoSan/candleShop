package commerce.candle_shop.exceptions;

public class ProductNotAvailableException extends RuntimeException{
    public ProductNotAvailableException(String message){
        super(message);

    }
}
