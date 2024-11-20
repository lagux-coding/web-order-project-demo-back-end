package OrderFoodDrink.OrderFoodDrink.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopRequestDto {

    String shopName;
    String address;

}
