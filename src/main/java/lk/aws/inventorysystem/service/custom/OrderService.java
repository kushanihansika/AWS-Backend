package lk.aws.inventorysystem.service.custom;

import lk.aws.inventorysystem.dto.OrderDTO;
import lk.aws.inventorysystem.service.SuperService;

public interface OrderService extends SuperService {

    void placeOrder(OrderDTO order);

    int generateOrderId();

}
