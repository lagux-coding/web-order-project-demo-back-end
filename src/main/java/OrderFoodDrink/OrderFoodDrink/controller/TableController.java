package OrderFoodDrink.OrderFoodDrink.controller;

import OrderFoodDrink.OrderFoodDrink.dto.TableUpdateStatusRequestDto;
import OrderFoodDrink.OrderFoodDrink.model.Tables;
import OrderFoodDrink.OrderFoodDrink.service.TableService;
import OrderFoodDrink.OrderFoodDrink.dto.response.TableResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/table")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;
    private final ModelMapper modelMapper;

    @GetMapping("/create/{table}")
    public String createTable(@PathVariable Integer table){
        if(tableService.createTable(table) == null)
            return "FAIL";
        return "OK";
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllTable(){
        List<Tables> list = tableService.getAllTable();

        if(list.isEmpty())
            return new ResponseEntity<>("nothing", HttpStatus.OK);
        return new ResponseEntity(list.stream().map(table -> modelMapper.map(table, TableResponseDto.class)).collect(Collectors.toList()) ,HttpStatus.OK);
    }

    @PutMapping("/update-status/{tableId}")
    public String updateStatus(@PathVariable Integer tableId, @RequestBody TableUpdateStatusRequestDto request) throws Exception {
        tableService.updateStatus(tableId, request);
        return "OK";
    }

}
