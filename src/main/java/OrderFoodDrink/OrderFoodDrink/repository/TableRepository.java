package OrderFoodDrink.OrderFoodDrink.repository;

import OrderFoodDrink.OrderFoodDrink.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Tables, Integer> {
    Tables findByTableNumber(Integer table);
}
