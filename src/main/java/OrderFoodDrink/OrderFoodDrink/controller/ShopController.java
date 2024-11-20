package OrderFoodDrink.OrderFoodDrink.controller;


import OrderFoodDrink.OrderFoodDrink.dto.ShopRequestDto;
import OrderFoodDrink.OrderFoodDrink.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/config")
    public String configShop(@RequestBody ShopRequestDto request) throws Exception {
        shopService.configShop(request);
        return "OK";
    }

}
