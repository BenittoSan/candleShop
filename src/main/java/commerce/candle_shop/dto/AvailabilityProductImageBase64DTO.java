package commerce.candle_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AvailabilityProductImageBase64DTO {

    private String productName;
    private double price;
    private int quantity;
    private String description;
    private long productInventoryId;
    private long productAvailabilityId;
    private double weight;
    private int burnDuration;
    private String image;

}
