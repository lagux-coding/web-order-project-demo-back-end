package OrderFoodDrink.OrderFoodDrink.controller;

import OrderFoodDrink.OrderFoodDrink.dto.AddItemRequestDto;
import OrderFoodDrink.OrderFoodDrink.dto.response.ItemResponseDto;
import OrderFoodDrink.OrderFoodDrink.model.Item;
import OrderFoodDrink.OrderFoodDrink.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public String addItem(@RequestBody AddItemRequestDto request){
        itemService.addItem(request);
        return "OK";
    }

    @PostMapping("/add-a-lots")
    public String addMoreItem(@RequestBody List<AddItemRequestDto> request){
        itemService.addMoreItem(request);
        return "OK";
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllItem(){
        List<Item> list = itemService.getAllItem();

        return new ResponseEntity<>(list.stream().map(item -> modelMapper.map(item, ItemResponseDto.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

}
