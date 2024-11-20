package OrderFoodDrink.OrderFoodDrink.service;

import OrderFoodDrink.OrderFoodDrink.dto.TableUpdateStatusRequestDto;
import OrderFoodDrink.OrderFoodDrink.model.Tables;

import java.util.List;

public interface TableService {
    Tables createTable(Integer table);

    List<Tables> getAllTable();

    void updateStatus(Integer tableId, TableUpdateStatusRequestDto request) throws Exception;
}
