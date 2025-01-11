package commerce.candle_shop.wishList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWishListRepository extends JpaRepository<WishList, Long> {


}
