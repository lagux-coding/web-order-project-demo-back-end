package OrderFoodDrink.OrderFoodDrink.service;

import OrderFoodDrink.OrderFoodDrink.dto.TableUpdateStatusRequestDto;
import OrderFoodDrink.OrderFoodDrink.model.Enums.TableStatusEnum;
import OrderFoodDrink.OrderFoodDrink.model.Tables;
import OrderFoodDrink.OrderFoodDrink.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService{

    private final TableRepository tableRepository;

    @Override
    public Tables createTable(Integer table) {
        if(tableRepository.findByTableNumber(table) != null)
            return null;
        Tables tables = Tables.builder()
                .tableNumber(table)
                .status(TableStatusEnum.NOT_USE)
                .build();
        return tableRepository.save(tables);
    }

    @Override
    public List<Tables> getAllTable() {
        return tableRepository.findAll();
    }

    @Override
    public void updateStatus(Integer tableId, TableUpdateStatusRequestDto request) throws Exception {
        Tables tables = tableRepository.findById(tableId).orElseThrow(() -> new Exception());

        tables.setStatus(request.getStatus());
        tableRepository.save(tables);
    }
}
