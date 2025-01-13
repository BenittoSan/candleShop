package commerce.candle_shop.productAvailability;


import commerce.candle_shop.dto.AvailabilityProductImageBase64DTO;
import generated.InserProductAvailabilitySchema;
import generated.SelectProductAvailabilityAndInventorySchema;

import java.util.List;

public interface IProductAvailabilityService {

    InserProductAvailabilitySchema insertProductAvailability(InserProductAvailabilitySchema insertProductAvailability);
    List<SelectProductAvailabilityAndInventorySchema> retrieveProductAvailability(int page, int size);
    List<AvailabilityProductImageBase64DTO>retriveAvailabilityProductImages(int page, int size);
}
