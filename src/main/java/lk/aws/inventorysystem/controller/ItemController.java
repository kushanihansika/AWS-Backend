package lk.aws.inventorysystem.controller;

import lk.aws.inventorysystem.dto.ItemDTO;
import lk.aws.inventorysystem.service.custom.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{code:I\\d{3}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> getItem(@PathVariable("code") String code) {
        ItemDTO dto = null;
        if (itemService.itemExistsByCode(code)){
            dto = itemService.getItem(code);
        }
        return new ResponseEntity<ItemDTO>(dto, (dto != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveItem(@RequestBody ItemDTO item){
        if (item.getCode().isEmpty() || item.getDescription().isEmpty() || item.getQtyOnHand() < 0 || item.getUnitPrice()< 1){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }else{
            String itemId = itemService.saveItem(item);
            return new ResponseEntity<String>("\"" +itemId + "\"" ,HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/{code:I\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable("code") String code, @RequestBody ItemDTO item){
        if (!itemService.itemExistsByCode(code)){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        if (item.getDescription().isEmpty() || item.getQtyOnHand() < 0 || item.getUnitPrice() < 0){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }else{
            item.setCode(code);
            itemService.updateItem(item);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(path = "/{code:I\\d{3}}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("code") String code){
        if (!itemService.itemExistsByCode(code)){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        itemService.deleteItem(code);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }    

}
