package OrderFoodDrink.OrderFoodDrink.service;

import OrderFoodDrink.OrderFoodDrink.dto.ShopRequestDto;
import OrderFoodDrink.OrderFoodDrink.model.Shop;

public interface ShopService {
    Shop configShop(ShopRequestDto request) throws Exception;
}
