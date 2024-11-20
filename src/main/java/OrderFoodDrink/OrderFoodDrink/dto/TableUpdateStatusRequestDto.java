package OrderFoodDrink.OrderFoodDrink.dto;

import OrderFoodDrink.OrderFoodDrink.model.Enums.TableStatusEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TableUpdateStatusRequestDto {

    TableStatusEnum status;

}
