package lk.aws.inventorysystem.controller;

import lk.aws.inventorysystem.dto.OrderDTO;
import lk.aws.inventorysystem.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO order){
        System.out.println(order);
        if (order.getCustomerId().isEmpty() || order.getOrderId() < 1 || order.getOrderDetails().size() == 0){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        orderService.placeOrder(order);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
