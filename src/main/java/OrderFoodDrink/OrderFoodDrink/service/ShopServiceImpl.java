package OrderFoodDrink.OrderFoodDrink.service;

import OrderFoodDrink.OrderFoodDrink.dto.ShopRequestDto;
import OrderFoodDrink.OrderFoodDrink.model.Shop;
import OrderFoodDrink.OrderFoodDrink.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;

    @Override
    public Shop configShop(ShopRequestDto request) throws Exception {
        Integer id = 1;
        if(shopRepository.findByShopId(id).isEmpty()){
            Shop shop = Shop.builder()
                    .shopName(request.getShopName())
                    .address(request.getAddress())
                    .build();
            return shopRepository.save(shop);
        }
        Shop shop = shopRepository.findByShopId(id).orElseThrow(() -> new Exception());
        shop.setShopName(request.getShopName());
        shop.setAddress(request.getAddress());
        return shopRepository.save(shop);
    }
}
