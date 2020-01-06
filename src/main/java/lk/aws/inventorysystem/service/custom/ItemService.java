package lk.aws.inventorysystem.service.custom;

import lk.aws.inventorysystem.dto.ItemDTO;
import lk.aws.inventorysystem.service.SuperService;

import java.util.List;

public interface ItemService extends SuperService {

    List<ItemDTO> getAllItems();

    ItemDTO getItem(String code);

    String saveItem(ItemDTO item);

    void updateItem(ItemDTO item);

    void deleteItem(String code);

    boolean itemExistsByCode(String code);

}
