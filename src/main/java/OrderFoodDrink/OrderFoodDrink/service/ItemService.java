package OrderFoodDrink.OrderFoodDrink.service;

import OrderFoodDrink.OrderFoodDrink.dto.AddItemRequestDto;
import OrderFoodDrink.OrderFoodDrink.model.Item;

import java.util.List;

public interface ItemService {
    void addItem(AddItemRequestDto request);

    List<Item> getAllItem();

    void addMoreItem(List<AddItemRequestDto> request);
}
