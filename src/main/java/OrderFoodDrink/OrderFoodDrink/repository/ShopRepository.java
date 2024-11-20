package OrderFoodDrink.OrderFoodDrink.repository;

import OrderFoodDrink.OrderFoodDrink.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    Optional<Shop> findByShopId(Integer id);
}
