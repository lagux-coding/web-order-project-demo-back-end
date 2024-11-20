package OrderFoodDrink.OrderFoodDrink.service;

import OrderFoodDrink.OrderFoodDrink.model.Customer;
import OrderFoodDrink.OrderFoodDrink.repository.CustomerRepository;
import OrderFoodDrink.OrderFoodDrink.dto.CustomerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerRequestDto request) {
        Customer customer = Customer.builder()
                .phoneNumber(request.getPhoneNumber())
                .customerName(request.getCustomerName())
                .build();
        customerRepository.save(customer);
    }

    @Override
    public boolean checkCustomer(String phone) {
        if(customerRepository.findByPhoneNumber(phone) == null)
            return false;
        return true;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
