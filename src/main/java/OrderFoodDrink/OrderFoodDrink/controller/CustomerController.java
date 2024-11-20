package OrderFoodDrink.OrderFoodDrink.controller;

import OrderFoodDrink.OrderFoodDrink.model.Customer;
import OrderFoodDrink.OrderFoodDrink.service.CustomerService;
import OrderFoodDrink.OrderFoodDrink.dto.CustomerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @PostMapping("/check-customer")
    public String checkCustomer(@RequestParam String phone){
        boolean check = customerService.checkCustomer(phone);
        if(check){
            return "NO";
        }
        return "OK";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@RequestBody CustomerRequestDto request){
        customerService.createCustomer(request);
        return "OK";
    }
}
