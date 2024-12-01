package commerce.candle_shop.model.address;

import commerce.candle_shop.model.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String houseNumber;
    private String city;
    private String zipCode;
    private String country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_Id", nullable = false)
    private Customer customer;
}
