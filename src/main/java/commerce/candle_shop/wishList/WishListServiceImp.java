package commerce.candle_shop.wishList;

import commerce.candle_shop.customer.Customer;
import commerce.candle_shop.exceptions.ProductNotAvailableException;
import commerce.candle_shop.productAvailability.ProductAvailability;
import generated.InserWishListSchema;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WishListServiceImp implements IWishListService {

    private final IWishListRepository wishListRepository;

    @PersistenceContext
    private final EntityManager em;

    WishListServiceImp(IWishListRepository wishListRepository, EntityManager em) {
        this.wishListRepository = wishListRepository;
        this.em = em;
    }


    private void validateProductAbailability(ProductAvailability productAvailability, long productAvailabilityId) {
        if(productAvailability == null){
            throw new ProductNotAvailableException(
                    "Product with ID: " + productAvailabilityId + " does not exist."
            );
        }
    }

    @Override
    @Transactional
    public InserWishListSchema inserIntoWishList(InserWishListSchema wishListSchema) {

        Customer customer = em.find(Customer.class,
                wishListSchema.getCustomerID());

        ProductAvailability productAvailability = em.find(ProductAvailability.class,
                wishListSchema.getProductAvailabilityId());

        //Validation
        validateProductAbailability(
                productAvailability, wishListSchema.getProductAvailabilityId());

        WishListKey wishListKey = new WishListKey(customer.getId(), productAvailability.getId());

        WishList wishList = new WishList(wishListKey
                                            ,customer
                                            ,productAvailability
                                            ,wishListSchema.getQuantity()
        );

        wishListRepository.save(wishList);


        return wishListSchema;

    }
}
