package commerce.candle_shop.address;

import generated.AddressSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final IAddressService addressService;

    public AddressController(IAddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping("/address")
    public ResponseEntity<AddressSchema> createAddress(@RequestBody AddressSchema address){

        AddressSchema response = addressService.insertAddress(address);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
