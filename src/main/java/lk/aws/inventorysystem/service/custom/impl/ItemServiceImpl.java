package lk.aws.inventorysystem.service.custom.impl;

import lk.aws.inventorysystem.repository.ItemRepository;
import lk.aws.inventorysystem.dto.ItemDTO;
import lk.aws.inventorysystem.entity.Item;
import lk.aws.inventorysystem.service.custom.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> getAllItems()   {
        List<ItemDTO> items = itemRepository.findAll().stream().map(item -> new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand())).collect(Collectors.toList());
        return items;
    }

    @Override
    public ItemDTO getItem(String code) {
        Item item = itemRepository.findById(code).get();
        return new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    public String saveItem(ItemDTO item)   {
        return itemRepository.save(new Item(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand())).getCode();
    }

    public void updateItem(ItemDTO item)   {
        itemRepository.save(new Item(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
    }

    public void deleteItem(String code)   {
        itemRepository.deleteById(code);
    }

    @Override
    public boolean itemExistsByCode(String code) {
        return itemRepository.existsById(code);
    }

}
