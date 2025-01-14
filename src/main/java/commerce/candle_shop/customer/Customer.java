package commerce.candle_shop.customer;

import commerce.candle_shop.security.user.User;
import commerce.candle_shop.address.Address;
import commerce.candle_shop.purchase.Purchase;
import commerce.candle_shop.wishList.WishList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String name;

    private String lastName;

    @Email
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;


    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "customer")
    private List<WishList> wishLists = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,mappedBy = "customer")
    private List<Purchase> purchases = new ArrayList<>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private User user;
}
