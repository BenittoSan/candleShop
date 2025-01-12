package commerce.candle_shop.productAvailability;


import generated.InserProductAvailabilitySchema;
import generated.SelectProductAvailabilityAndInventorySchema;

import java.util.List;

public interface IProductAvailabilityService {

    InserProductAvailabilitySchema insertProductAvailability(InserProductAvailabilitySchema insertProductAvailability);
    List<SelectProductAvailabilityAndInventorySchema> retrieveProductAvailability();

}
