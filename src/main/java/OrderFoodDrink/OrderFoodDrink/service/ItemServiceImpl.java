package OrderFoodDrink.OrderFoodDrink.service;

import OrderFoodDrink.OrderFoodDrink.dto.AddItemRequestDto;
import OrderFoodDrink.OrderFoodDrink.model.Item;
import OrderFoodDrink.OrderFoodDrink.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addItem(AddItemRequestDto request) {
        Item item = Item.builder()
                .itemName(request.getItemName())
                .description(request.getDescription())
                .price(request.getPrice())
                .imageUrl(request.getImageUrl())
                .typeStatus(request.getTypeStatus())
                .status(request.getStatus())
                .build();

        itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Transactional
    @Override
    public void addMoreItem(List<AddItemRequestDto> request) {
        List<Item> list = request.stream().map(requestItem -> modelMapper.map(requestItem, Item.class)).toList();
        itemRepository.saveAll(list);
    }
}
