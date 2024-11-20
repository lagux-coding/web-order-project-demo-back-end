package OrderFoodDrink.OrderFoodDrink.service;

import OrderFoodDrink.OrderFoodDrink.model.Customer;
import OrderFoodDrink.OrderFoodDrink.dto.CustomerRequestDto;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerRequestDto request);

    boolean checkCustomer(String phone);

    List<Customer> getAllCustomer();
}
