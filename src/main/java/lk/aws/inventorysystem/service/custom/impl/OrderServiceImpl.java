package lk.aws.inventorysystem.service.custom.impl;

import lk.aws.inventorysystem.dto.OrderDTO;
import lk.aws.inventorysystem.dto.OrderDetailDTO;
import lk.aws.inventorysystem.entity.Customer;
import lk.aws.inventorysystem.entity.Item;
import lk.aws.inventorysystem.entity.Order;
import lk.aws.inventorysystem.entity.OrderDetail;
import lk.aws.inventorysystem.repository.CustomerRepository;
import lk.aws.inventorysystem.repository.ItemRepository;
import lk.aws.inventorysystem.repository.OrderDetailRepository;
import lk.aws.inventorysystem.repository.OrderRepository;
import lk.aws.inventorysystem.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.sql.Date;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public void placeOrder(OrderDTO order) {

        if (orderRepository.existsById(order.getOrderId())){
            throw new RuntimeException("Order already exists");
        }

        // Find the customer
        Customer customer = customerRepository.getOne(order.getCustomerId());
        // Save the order
        orderRepository.save(new Order(order.getOrderId(), new Date(order.getOrderDate().getTime()).toLocalDate(), customer));
        //  Save OrderDetails and Update the Qty.
        for (OrderDetailDTO dto : order.getOrderDetails()) {
            orderDetailRepository.save(new OrderDetail(dto.getOrderId(), dto.getItemCode(), dto.getQty(), dto.getUnitPrice()));
            // Find the item
            Item item = itemRepository.getOne(dto.getItemCode());
            // Calculate the qty. on hand
            int qty = item.getQtyOnHand() - dto.getQty();
            // Update the new qty.on hand
            item.setQtyOnHand(qty);
        }

    }

    public int generateOrderId() {
        try {
            return orderRepository.getLastOrderId() + 1;
        } catch (NoResultException e) {
            return 1;
        }
    }

}
