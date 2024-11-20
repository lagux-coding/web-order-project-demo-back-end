package OrderFoodDrink.OrderFoodDrink.repository;

import OrderFoodDrink.OrderFoodDrink.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByPhoneNumber(String phone);
}
