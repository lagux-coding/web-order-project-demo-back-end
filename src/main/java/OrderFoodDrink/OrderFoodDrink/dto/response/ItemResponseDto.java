package OrderFoodDrink.OrderFoodDrink.dto.response;

import OrderFoodDrink.OrderFoodDrink.model.Enums.ItemStatusEnum;
import OrderFoodDrink.OrderFoodDrink.model.Enums.ItemType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemResponseDto {

    Integer itemId;

    String itemName;

    String description;

    double price;

    String imageUrl;

    ItemType typeStatus;

    ItemStatusEnum status;

}
