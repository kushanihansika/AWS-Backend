package lk.aws.inventorysystem.repository;

import lk.aws.inventorysystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {

//    Order getTopOrdersByOrderByIdDesc() throws Exception;

    @Query(value = "SELECT o.id FROM `Order` o ORDER BY o.id DESC LIMIT 1", nativeQuery = true)
    int getLastOrderId() ;

}
